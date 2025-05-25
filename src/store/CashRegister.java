package store;

public class CashRegister {
    private int number;
    private Cashier currentCashier;

    public CashRegister(int number) {
        this.number = number;
    }

    public void assignCashier(Cashier cashier) {
        this.currentCashier = cashier;
    }

    public Cashier getCurrentCashier() {
        return currentCashier;
    }

    public int getNumber() {
        return number;
    }
}
