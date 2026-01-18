package exceptions;

public class InsufficientFundsException extends Exception {

    private double amount;

    public InsufficientFundsException (double amount) {
        super("What do you want ? You don't have money.");
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
