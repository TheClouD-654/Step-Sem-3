import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Customer {
    protected String type;
    protected double amount;

    public Customer(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFinalAmount();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super("STUDENT", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super("STAFF", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super("GUEST", amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0;
    }
}

public class CanteenBilling {
    public static Customer createCustomer(String type, double amount) {
        switch (type.toUpperCase()) {
            case "STUDENT":
                return new StudentCustomer(amount);
            case "STAFF":
                return new StaffCustomer(amount);
            case "GUEST":
                return new GuestCustomer(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            bills.add(createCustomer(type, amount));
        }

        double grandTotal = 0.0;
        for (Customer customer : bills) {
            double finalAmount = customer.calculateFinalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", customer.getType(), finalAmount);
            grandTotal += finalAmount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
