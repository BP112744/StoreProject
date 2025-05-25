package store;

public class Main {
    public static void main(String[] args) {

        Cashier[] cashiers = {
                new Cashier(1, "Иван Петров", 1000),
                new Cashier(2, "Мария Иванова", 1100),
                new Cashier(3, "Георги Георгиев", 1200),
                new Cashier(4, "Елена Стоянова", 1150)
        };

        Store store = new Store(cashiers);
        store.sellProducts(1,
                new SoldProduct("Шампоан", 2.00, 3.50, 1),
                new SoldProduct("Кисело мляко", 0.50, 0.67, 2)
        );

        store.sellProducts(2,
                new SoldProduct("Хляб", 0.80, 1.20, 2),
                new SoldProduct("Сирене", 4.00, 5.50, 1),
                new SoldProduct("Масло", 2.20, 3.00, 1)
        );

        store.sellProducts(3,
                new SoldProduct("Сок", 1.00, 1.80, 3),
                new SoldProduct("Бисквити", 0.60, 1.00, 4)
        );

        store.sellProducts(4,
                new SoldProduct("Кафе", 4.50, 6.00, 1),
                new SoldProduct("Захар", 1.20, 1.70, 1),
                new SoldProduct("Мляко", 1.00, 1.50, 2)
        );
        store.printReport();
    }
}
