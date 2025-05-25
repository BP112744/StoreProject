package store;

import java.time.LocalDate;

public class FoodProduct extends Product {
    private static double markup = 0.2;

    public FoodProduct(String id, String name, double purchasePrice, LocalDate expiryDate, int quantity) {
        super(id, name, purchasePrice, expiryDate, quantity);
    }

    public double getSellingPrice(LocalDate currentDate, int daysBeforeExpiry, double discountPercent) {
        double basePrice = getPurchasePrice() * (1 + markup);
        long daysLeft = java.time.temporal.ChronoUnit.DAYS.between(currentDate, getExpiryDate());

        if (daysLeft >= 0 && daysLeft < daysBeforeExpiry) {
            basePrice *= (1 - discountPercent);
        }

        return basePrice;
    }
}
