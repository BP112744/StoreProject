package store;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Receipt implements Serializable {
    private static int counter = 1;
    private int id;
    private Cashier cashier;
    private LocalDateTime dateTime;
    private List<SoldProduct> soldProducts;
    private double total;

    public Receipt(Cashier cashier) {
        this.id = counter++;
        this.cashier = cashier;
        this.dateTime = LocalDateTime.now();
        this.soldProducts = new ArrayList<>();
        this.total = 0;
    }

    public void addProduct(SoldProduct product) {
        soldProducts.add(product);
        total += product.getTotalPrice();
    }

    public double getTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public List<SoldProduct> getSoldProducts() {
        return soldProducts;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        StringBuilder sb = new StringBuilder();
        sb.append("КАСОВА БЕЛЕЖКА №").append(id).append("\n");
        sb.append("Дата: ").append(dateTime.format(formatter)).append("\n");
        sb.append("Касиер: ").append(cashier.getName()).append(" (ID: ").append(cashier.getId()).append(")\n");
        for (SoldProduct sp : soldProducts) {
            sb.append(sp.getName()).append(" x ").append(sp.getQuantity())
                    .append(" @ ").append(String.format("%.2f", sp.getSellingPrice())).append("\n");
        }
        sb.append("Общо: ").append(String.format("%.2f", total)).append(" лв.\n");
        return sb.toString();
    }


    public void saveToFile() {
        try {
            // Създаване на директория "receipts", ако я няма
            File dir = new File("receipts");
            if (!dir.exists()) {
                if (dir.mkdirs()) {
                    System.out.println("Създадена е директория receipts.");
                } else {
                    System.out.println("Неуспешен опит за създаване на директорията receipts.");
                }
            }

            // Записване на .txt файл с касовата бележка
            File textFile = new File(dir, "receipt_" + id + ".txt");
            try (PrintWriter writer = new PrintWriter(textFile)) {
                writer.println(this.toString());
            }

            // Сериализация във .ser файл
            File serFile = new File(dir, "receipt_" + id + ".ser");
            try (FileOutputStream fos = new FileOutputStream(serFile);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(this);
            }

        } catch (IOException e) {
            System.out.println("⚠️ Грешка при запис на бележката: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
