package store;

public class Store {
    private Cashier[] cashiers;
    private double totalRevenue;
    private double totalProfit;

    public Store(Cashier[] cashiers) {
        this.cashiers = cashiers;
        this.totalRevenue = 0;
        this.totalProfit = 0;
    }

    public void sellProducts(int cashierId, SoldProduct... products) {
        Cashier cashier = getCashierById(cashierId);
        if (cashier == null) {
            System.out.println("Невалиден касиер.");
            return;
        }

        Receipt receipt = new Receipt(cashier);
        double totalCost = 0;
        double totalPrice = 0;

        for (SoldProduct product : products) {
            receipt.addProduct(product);
            totalCost += product.getPurchasePrice() * product.getQuantity();
            totalPrice += product.getSellingPrice() * product.getQuantity();
        }

        totalRevenue += totalPrice;
        totalProfit += (totalPrice - totalCost);

        System.out.println(receipt);
        receipt.saveToFile();
    }

    private Cashier getCashierById(int id) {
        for (Cashier c : cashiers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void printReport() {
        System.out.println("Оборот: " + String.format("%.2f", totalRevenue) + " лв.");
        System.out.println("Печалба: " + String.format("%.2f", totalProfit) + " лв.");
    }
}
