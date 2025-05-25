package store;

import java.io.Serializable;

public class SoldProduct implements Serializable {
    private String name;
    private double purchasePrice;
    private double sellingPrice;
    private int quantity;

    public SoldProduct(String name, double purchasePrice, double sellingPrice, int quantity) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return sellingPrice * quantity;
    }
}
