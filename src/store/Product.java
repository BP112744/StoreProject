package store;

import java.time.LocalDate;

public class Product {
    private String id;
    private String name;
    private double purchasePrice;
    private LocalDate expiryDate;
    private int quantity;

    public Product(String id, String name, double purchasePrice, LocalDate expiryDate, int quantity) {
        this.id = id;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    public boolean isExpired(LocalDate currentDate) {
        return currentDate.isAfter(expiryDate);
    }


}
