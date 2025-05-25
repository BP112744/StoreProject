package store;

public class InsufficientQuantityException extends Exception {
    public InsufficientQuantityException(String productName, int missingQty) {
        super("Недостатъчно количество от \"" + productName + "\". Липсват " + missingQty + " броя.");
    }
}