package com.manish.LLD.BookMyShow.Part1.models;

import com.manish.LLD.BookMyShow.Part1.models.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Booking {
    private String bookingId;
    private User user;
    private Show show;
    private LocalDateTime bookingTime;
    private BookingStatus status;
    private List<Ticket> tickets;
    private Payment payment;
    private DiscountCoupon coupon;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public DiscountCoupon getCoupon() {
        return coupon;
    }

    public void setCoupon(DiscountCoupon coupon) {
        this.coupon = coupon;
    }

    // Constructor, getters, setters
    public double calculateTotalAmount() {
        double total = tickets.stream().mapToDouble(Ticket::getPrice).sum();
        if (coupon != null) {
            double discount = total * coupon.getDiscountPercentage() / 100;
            discount = Math.min(discount, coupon.getMaxDiscount());
            total -= discount;
        }
        return total;
    }


}
