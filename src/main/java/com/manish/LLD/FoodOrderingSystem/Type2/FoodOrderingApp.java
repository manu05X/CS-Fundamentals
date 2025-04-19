import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// Enums
enum OrderStatus {
    PENDING, ACCEPTED, COMPLETED, REJECTED
}

enum SelectionCriteria {
    LOWEST_COST, HIGHEST_RATING, MAX_CAPACITY
}

// Model Classes
class MenuItem {
    private final String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

class OrderItem {
    private final String itemName;
    private final int quantity;

    public OrderItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
}

// Main Classes
class Restaurant {
    private final String id;
    private final String name;
    private final double rating;
    private final int maxOrderCapacity;
    private final AtomicInteger currentOrders = new AtomicInteger(0);
    private final Map<String, MenuItem> menu = new HashMap<>();

    public Restaurant(String name, double rating, int maxOrderCapacity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.rating = rating;
        this.maxOrderCapacity = maxOrderCapacity;
    }

    public boolean canAcceptOrder() {
        return currentOrders.get() < maxOrderCapacity;
    }

    public boolean acceptOrder() {
        return currentOrders.getAndUpdate(curr -> curr < maxOrderCapacity ? curr + 1 : curr) < maxOrderCapacity;
    }

    public void completeOrder() {
        currentOrders.decrementAndGet();
    }

    public void addMenuItem(String name, double price) {
        menu.put(name, new MenuItem(name, price));
    }

    public void updateMenuItem(String name, double price) {
        if (menu.containsKey(name)) {
            menu.get(name).setPrice(price);
        }
    }

    public boolean hasAllItems(Map<String, Integer> items) {
        return items.keySet().stream()
                .allMatch(menu::containsKey);
    }

    public double calculateOrderCost(Map<String, Integer> items) {
        return items.entrySet().stream()
                .mapToDouble(entry -> menu.get(entry.getKey()).getPrice() * entry.getValue())
                .sum();
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getRating() { return rating; }
    public int getMaxOrderCapacity() { return maxOrderCapacity; }
    public int getCurrentOrders() { return currentOrders.get(); }
    public int getRemainingCapacity() { return maxOrderCapacity - currentOrders.get(); }
    public Map<String, MenuItem> getMenu() { return new HashMap<>(menu); }
}

class Order {
    private final String id;
    private final String customerName;
    private final List<OrderItem> items;
    private Restaurant restaurant;
    private OrderStatus status;
    private double totalCost;
    private final SelectionCriteria selectionCriteria;

    public Order(String customerName, List<OrderItem> items, SelectionCriteria criteria) {
        this.id = UUID.randomUUID().toString();
        this.customerName = customerName;
        this.items = new ArrayList<>(items);
        this.status = OrderStatus.PENDING;
        this.selectionCriteria = criteria;
    }

    public void assignToRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.status = OrderStatus.ACCEPTED;
        calculateTotalCost();
    }

    private void calculateTotalCost() {
        Map<String, Integer> itemMap = new HashMap<>();
        for (OrderItem item : items) {
            itemMap.put(item.getItemName(), item.getQuantity());
        }
        this.totalCost = restaurant.calculateOrderCost(itemMap);
    }

    public void markAsCompleted() {
        this.status = OrderStatus.COMPLETED;
    }

    // Getters
    public String getId() { return id; }
    public String getCustomerName() { return customerName; }
    public List<OrderItem> getItems() { return new ArrayList<>(items); }
    public Restaurant getRestaurant() { return restaurant; }
    public OrderStatus getStatus() { return status; }
    public double getTotalCost() { return totalCost; }
    public SelectionCriteria getSelectionCriteria() { return selectionCriteria; }
}

// Strategy Pattern
interface OrderAssignmentStrategy {
    Restaurant assignOrder(List<Restaurant> restaurants, Map<String, Integer> items);
}

class LowestCostStrategy implements OrderAssignmentStrategy {
    @Override
    public Restaurant assignOrder(List<Restaurant> restaurants, Map<String, Integer> items) {
        Restaurant selected = null;
        double minCost = Double.MAX_VALUE;

        for (Restaurant restaurant : restaurants) {
            double cost = restaurant.calculateOrderCost(items);
            if (cost < minCost) {
                minCost = cost;
                selected = restaurant;
            }
        }
        return selected;
    }
}

class HighestRatingStrategy implements OrderAssignmentStrategy {
    @Override
    public Restaurant assignOrder(List<Restaurant> restaurants, Map<String, Integer> items) {
        Restaurant selected = null;
        double maxRating = 0;

        for (Restaurant restaurant : restaurants) {
            if (restaurant.getRating() > maxRating) {
                maxRating = restaurant.getRating();
                selected = restaurant;
            }
        }
        return selected;
    }
}

class MaxCapacityStrategy implements OrderAssignmentStrategy {
    @Override
    public Restaurant assignOrder(List<Restaurant> restaurants, Map<String, Integer> items) {
        Restaurant selected = null;
        int maxCapacity = 0;

        for (Restaurant restaurant : restaurants) {
            int capacity = restaurant.getRemainingCapacity();
            if (capacity > maxCapacity) {
                maxCapacity = capacity;
                selected = restaurant;
            }
        }
        return selected;
    }
}

// Repository Classes
class RestaurantRepository {
    private final Map<String, Restaurant> restaurants = new HashMap<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public Restaurant getRestaurant(String id) {
        return restaurants.get(id);
    }

    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurants.values());
    }
}

class OrderRepository {
    private final Map<String, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public Order getOrder(String id) {
        return orders.get(id);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }
}

// Main System
class FoodOrderingSystem {
    private final RestaurantRepository restaurantRepository = new RestaurantRepository();
    private final OrderRepository orderRepository = new OrderRepository();
    private final Map<SelectionCriteria, OrderAssignmentStrategy> strategies = new EnumMap<>(SelectionCriteria.class);

    public FoodOrderingSystem() {
        initializeStrategies();
    }

    private void initializeStrategies() {
        strategies.put(SelectionCriteria.LOWEST_COST, new LowestCostStrategy());
        strategies.put(SelectionCriteria.HIGHEST_RATING, new HighestRatingStrategy());
        strategies.put(SelectionCriteria.MAX_CAPACITY, new MaxCapacityStrategy());
    }

    public void onboardRestaurant(String name, double rating, int maxOrderCapacity) {
        restaurantRepository.addRestaurant(new Restaurant(name, rating, maxOrderCapacity));
    }

    public void updateRestaurantMenu(String restaurantId, String itemName, double price, boolean isAdd) {
        Restaurant restaurant = restaurantRepository.getRestaurant(restaurantId);
        if (restaurant != null) {
            if (isAdd) {
                restaurant.addMenuItem(itemName, price);
            } else {
                restaurant.updateMenuItem(itemName, price);
            }
        }
    }

    public Order placeOrder(String customerName, List<OrderItem> items, SelectionCriteria criteria) {
        Map<String, Integer> itemMap = new HashMap<>();
        for (OrderItem item : items) {
            itemMap.put(item.getItemName(), item.getQuantity());
        }

        OrderAssignmentStrategy strategy = strategies.get(criteria);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid selection criteria");
        }

        List<Restaurant> eligibleRestaurants = restaurantRepository.getAllRestaurants().stream()
                .filter(r -> r.hasAllItems(itemMap))
                .filter(Restaurant::canAcceptOrder)
                .toList();

        Restaurant assignedRestaurant = strategy.assignOrder(eligibleRestaurants, itemMap);
        if (assignedRestaurant == null) {
            return null;
        }

        Order order = new Order(customerName, items, criteria);
        if (assignedRestaurant.acceptOrder()) {
            order.assignToRestaurant(assignedRestaurant);
            orderRepository.addOrder(order);
            return order;
        }
        return null;
    }

    public void markOrderAsCompleted(String orderId) {
        Order order = orderRepository.getOrder(orderId);
        if (order != null && order.getStatus() == OrderStatus.ACCEPTED) {
            order.markAsCompleted();
            order.getRestaurant().completeOrder();
        }
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }
}

// Main Application
public class FoodOrderingApp {
    public static void main(String[] args) {
        FoodOrderingSystem system = new FoodOrderingSystem();
        Scanner scanner = new Scanner(System.in);

        // Initialize restaurants
        initializeRestaurants(system);

        while (true) {
            System.out.println("\n1. Place Order");
            System.out.println("2. Mark Order as Completed");
            System.out.println("3. Print Restaurant Status");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: placeOrder(system, scanner); break;
                case 2: completeOrder(system, scanner); break;
                case 3: printRestaurantStatus(system); break;
                case 4: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private static void initializeRestaurants(FoodOrderingSystem system) {
        system.onboardRestaurant("R1", 4.5, 5);
        system.updateRestaurantMenu("R1", "Veg Biryani", 100, true);
        system.updateRestaurantMenu("R1", "Chicken Biryani", 150, true);

        system.onboardRestaurant("R2", 4.0, 5);
        system.updateRestaurantMenu("R2", "Chicken Biryani", 175, true);
        system.updateRestaurantMenu("R2", "Idli", 10, true);
        system.updateRestaurantMenu("R2", "Dosa", 50, true);
        system.updateRestaurantMenu("R2", "Veg Biryani", 80, true);

        system.onboardRestaurant("R3", 4.9, 1);
        system.updateRestaurantMenu("R3", "Gobi Manchurian", 150, true);
        system.updateRestaurantMenu("R3", "Idli", 15, true);
        system.updateRestaurantMenu("R3", "Chicken Biryani", 175, true);
        system.updateRestaurantMenu("R3", "Dosa", 30, true);
    }

    private static void placeOrder(FoodOrderingSystem system, Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine().trim();

        List<OrderItem> items = new ArrayList<>();
        while (true) {
            System.out.print("Enter item (format: quantity*name) or 'done': ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) break;

            try {
                String[] parts = input.split("\\*");
                if (parts.length != 2) throw new IllegalArgumentException();

                int quantity = Integer.parseInt(parts[0].trim());
                String itemName = parts[1].trim();

                if (quantity <= 0) {
                    System.out.println("Quantity must be positive");
                    continue;
                }

                items.add(new OrderItem(itemName, quantity));
            } catch (Exception e) {
                System.out.println("Invalid format. Use format: 2*ItemName");
            }
        }

        if (items.isEmpty()) {
            System.out.println("No items in order");
            return;
        }

        System.out.println("Select criteria: 1. Lowest Cost, 2. Highest Rating, 3. Max Capacity");
        int criteriaChoice = scanner.nextInt();
        scanner.nextLine();

        SelectionCriteria criteria = switch (criteriaChoice) {
            case 1 -> SelectionCriteria.LOWEST_COST;
            case 2 -> SelectionCriteria.HIGHEST_RATING;
            case 3 -> SelectionCriteria.MAX_CAPACITY;
            default -> {
                System.out.println("Invalid choice, using Lowest Cost");
                yield SelectionCriteria.LOWEST_COST;
            }
        };

        Order order = system.placeOrder(customerName, items, criteria);
        if (order != null) {
            System.out.println("\nOrder placed successfully!");
            System.out.println("Order ID: " + order.getId());
            System.out.println("Assigned to: " + order.getRestaurant().getName());
            System.out.printf("Total cost: Rs. %.2f%n", order.getTotalCost());
            System.out.println("Status: " + order.getStatus());
        } else {
            System.out.println("Order could not be fulfilled by any restaurant");
        }
    }

    private static void completeOrder(FoodOrderingSystem system, Scanner scanner) {
        System.out.print("Enter order ID to mark as completed: ");
        String orderId = scanner.nextLine().trim();
        system.markOrderAsCompleted(orderId);
        System.out.println("Order status updated");
    }

    private static void printRestaurantStatus(FoodOrderingSystem system) {
        System.out.println("\n=== Restaurant Status ===");
        for (Restaurant r : system.getRestaurantRepository().getAllRestaurants()) {
            System.out.printf("%s - Capacity: %d/%d, Rating: %.1f%n",
                    r.getName(),
                    r.getCurrentOrders(),
                    r.getMaxOrderCapacity(),
                    r.getRating());
            System.out.println("Menu: " + r.getMenu().keySet());
        }
    }
}