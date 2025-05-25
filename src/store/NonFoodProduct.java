package store;

import java.time.LocalDate;

public class NonFoodProduct extends Product {
    private static double markup = 0.4;

    public NonFoodProduct(String id, String name, double purchasePrice, LocalDate expiryDate, int quantity) {
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
