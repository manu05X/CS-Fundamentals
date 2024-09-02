package com.manish.OOP.OOD.SOLID.SingleResponsibility.Good;

public class Invoice {
        private Book book;
        private int quantity;
        private double discountRate;
        private double taxRate;

        public Invoice(Book book, int quantity, double discountRate, double taxRate) {
            this.book = book;
            this.quantity = quantity;
            this.discountRate = discountRate;
            this.taxRate = taxRate;
        }

        // Getters and setters for Invoice class
        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            this.book = book;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getDiscount() {
            return discountRate;
        }

        public void setDiscount(double discount) {
            this.discountRate = discount;
        }

        public double getTax() {
            return taxRate;
        }

        public void setTax(double taxRate) {
            this.taxRate = taxRate;
        }

    public double calculateTotal() {
        double price = ((book.getPrice() - book.getPrice() * discountRate) * this.quantity);
        return price * (1 + taxRate);
    }
}
