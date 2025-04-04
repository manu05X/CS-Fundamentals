package com.manish.LLD.DeliveryP2PSystem.system;

import com.manish.LLD.DeliveryP2PSystem.dashboard.Dashboard;
import com.manish.LLD.DeliveryP2PSystem.enums.NotificationType;
import com.manish.LLD.DeliveryP2PSystem.enums.OrderStatus;
import com.manish.LLD.DeliveryP2PSystem.model.*;
import com.manish.LLD.DeliveryP2PSystem.service.NearestDriverStrategy;
import com.manish.LLD.DeliveryP2PSystem.service.NotificationService;
import com.manish.LLD.DeliveryP2PSystem.service.OrderAssignmentStrategy;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class DeliverySystem {
    private final Map<String, Customer> customers = new ConcurrentHashMap<>();
    private final Map<String, Driver> drivers = new ConcurrentHashMap<>();
    private final Map<String, Order> orders = new ConcurrentHashMap<>();
    private final Set<Item> items = ConcurrentHashMap.newKeySet();
    private final Map<String, List<DriverRating>> driverRatings = new ConcurrentHashMap<>();
    
    private final BlockingQueue<Driver> availableDrivers = new LinkedBlockingQueue<>();
    private final BlockingQueue<Order> pendingOrders = new LinkedBlockingQueue<>();
    
    private final OrderAssignmentStrategy assignmentStrategy = new NearestDriverStrategy();
    private final NotificationService notificationService = new NotificationService();
    private final Dashboard dashboard;
    
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final long orderTimeoutMillis = 30 * 60 * 1000; // 30 minutes
    
    public DeliverySystem() {
        this.dashboard = new Dashboard(this);
        scheduler.scheduleAtFixedRate(this::checkOrderTimeouts, 1, 1, TimeUnit.MINUTES);
    }
    
    // Customer management
    public boolean onboardCustomer(Customer customer) {
        return customers.putIfAbsent(customer.getId(), customer) == null;
    }
    
    public Customer getCustomer(String customerId) {
        return customers.get(customerId);
    }
    
    // Driver management
    public boolean onboardDriver(Driver driver) {
        if (drivers.putIfAbsent(driver.getId(), driver) == null) {
            availableDrivers.add(driver);
            return true;
        }
        return false;
    }
    
    public Driver getDriver(String driverId) {
        return drivers.get(driverId);
    }
    
    public List<Driver> getAllDrivers() {
        return new ArrayList<>(drivers.values());
    }
    
    // Item management
    public boolean addItem(Item item) {
        return items.add(item);
    }
    
    public Item getItem(String itemId) {
        return items.stream().filter(i -> i.getId().equals(itemId)).findFirst().orElse(null);
    }
    
    // Order management
    public String placeOrder(String customerId, String itemId) {
        Customer customer = getCustomer(customerId);
        Item item = getItem(itemId);
        
        if (customer == null || item == null) {
            throw new IllegalArgumentException("Invalid customer or item");
        }
        
        String orderId = "ORD-" + System.currentTimeMillis();
        Order order = new Order(orderId, customerId, itemId);
        orders.put(orderId, order);
        pendingOrders.add(order);
        
        notificationService.sendNotification(
            customer.getEmail(), customer.getPhone(), 
            NotificationType.ORDER_PLACED, 
            "Your order " + orderId + " has been placed"
        );
        
        assignOrdersToDrivers();
        return orderId;
    }
    
    public boolean cancelOrder(String orderId) {
        Order order = orders.get(orderId);
        if (order == null) return false;
        
        synchronized (order) {
            if (!order.cancel()) return false;
            
            if (order.getDriverId() != null) {
                Driver driver = drivers.get(order.getDriverId());
                if (driver != null) {
                    driver.completeOrder();
                    availableDrivers.add(driver);
                }
            }
            
            Customer customer = customers.get(order.getCustomerId());
            if (customer != null) {
                notificationService.sendNotification(
                    customer.getEmail(), customer.getPhone(), 
                    NotificationType.ORDER_CANCELLED, 
                    "Your order " + orderId + " has been cancelled"
                );
            }
            
            return true;
        }
    }
    
    public OrderStatus getOrderStatus(String orderId) {
        Order order = orders.get(orderId);
        return order != null ? order.getStatus() : null;
    }
    
    public boolean pickupOrder(String driverId, String orderId) {
        Driver driver = drivers.get(driverId);
        Order order = orders.get(orderId);
        
        if (driver == null || order == null || !driverId.equals(order.getDriverId())) {
            return false;
        }
        
        synchronized (order) {
            if (order.pickup()) {
                Customer customer = customers.get(order.getCustomerId());
                if (customer != null) {
                    notificationService.sendNotification(
                        customer.getEmail(), customer.getPhone(), 
                        NotificationType.ORDER_PICKED_UP, 
                        "Your order " + orderId + " has been picked up by driver " + driver.getName()
                    );
                }
                return true;
            }
            return false;
        }
    }
    
    public boolean deliverOrder(String driverId, String orderId) {
        Driver driver = drivers.get(driverId);
        Order order = orders.get(orderId);
        
        if (driver == null || order == null || !driverId.equals(order.getDriverId())) {
            return false;
        }
        
        synchronized (order) {
            if (order.deliver()) {
                driver.completeOrder();
                availableDrivers.add(driver);
                
                Customer customer = customers.get(order.getCustomerId());
                if (customer != null) {
                    notificationService.sendNotification(
                        customer.getEmail(), customer.getPhone(), 
                        NotificationType.ORDER_DELIVERED, 
                        "Your order " + orderId + " has been delivered by driver " + driver.getName()
                    );
                }
                
                assignOrdersToDrivers();
                return true;
            }
            return false;
        }
    }
    
    // Rating
    public boolean rateDriver(String customerId, String orderId, int rating, String comment) {
        Order order = orders.get(orderId);
        if (order == null || order.getStatus() != OrderStatus.DELIVERED || 
            !order.getCustomerId().equals(customerId)) {
            return false;
        }
        
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        
        DriverRating driverRating = new DriverRating(
            order.getDriverId(), customerId, orderId, rating, comment);
        
        driverRatings.computeIfAbsent(order.getDriverId(), k -> new CopyOnWriteArrayList<>())
                    .add(driverRating);
        
        return true;
    }
    
    public double getAverageRating(String driverId) {
        List<DriverRating> ratings = driverRatings.get(driverId);
        if (ratings == null || ratings.isEmpty()) return 0;
        return ratings.stream().mapToInt(DriverRating::getRating).average().orElse(0);
    }
    
    public int getCompletedOrdersCount(String driverId) {
        return (int) orders.values().stream()
            .filter(o -> o.getDriverId() != null && o.getDriverId().equals(driverId) && 
                         o.getStatus() == OrderStatus.DELIVERED)
            .count();
    }
    
    // Dashboard access
    public Dashboard getDashboard() {
        return dashboard;
    }
    
    // Driver status
    public boolean isDriverAvailable(String driverId) {
        Driver driver = drivers.get(driverId);
        return driver != null && driver.isAvailable();
    }
    
    // Private methods
    private void assignOrdersToDrivers() {
        while (!pendingOrders.isEmpty() && !availableDrivers.isEmpty()) {
            Order order = pendingOrders.peek();
            if (order == null) break;
            
            synchronized (order) {
                if (order.getStatus() != OrderStatus.PLACED) {
                    pendingOrders.poll();
                    continue;
                }
                
                Driver driver = availableDrivers.poll();
                if (driver == null) break;
                
                if (driver.assignOrder(order.getId()) && order.assignDriver(driver.getId())) {
                    pendingOrders.poll();
                    
                    Customer customer = customers.get(order.getCustomerId());
                    if (customer != null) {
                        notificationService.sendNotification(
                            customer.getEmail(), customer.getPhone(), 
                            NotificationType.ORDER_ASSIGNED, 
                            "Your order " + order.getId() + " has been assigned to driver " + driver.getName()
                        );
                    }
                    
                    notificationService.sendNotification(
                        driver.getEmail(), driver.getPhone(), 
                        NotificationType.ORDER_ASSIGNED, 
                        "You have been assigned order " + order.getId()
                    );
                } else {
                    availableDrivers.add(driver);
                }
            }
        }
    }
    
    private void checkOrderTimeouts() {
        long currentTime = System.currentTimeMillis();
        for (Order order : orders.values()) {
            if (order.getStatus() == OrderStatus.PLACED || order.getStatus() == OrderStatus.ASSIGNED) {
                if (currentTime - order.getCreationTime() > orderTimeoutMillis) {
                    cancelOrder(order.getId());
                }
            }
        }
    }
    
    public void shutdown() {
        scheduler.shutdown();
    }
}