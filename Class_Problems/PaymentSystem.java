import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class PaymentMethod {
    protected String type;
    protected double amount;

    public PaymentMethod(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public abstract double getAdjustedAmount();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super("CARD", amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super("WALLET", amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }

    @Override
    public double getAdjustedAmount() {
        return amount;
    }
}

public class PaymentSystem {
    public static PaymentMethod createPayment(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<PaymentMethod> transactions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            transactions.add(createPayment(type, amount));
        }

        double grandTotal = 0.0;
        for (PaymentMethod tx : transactions) {
            double adjusted = tx.getAdjustedAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", tx.getType(), adjusted);
            grandTotal += adjusted;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
