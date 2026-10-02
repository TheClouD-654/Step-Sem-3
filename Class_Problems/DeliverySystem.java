import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Delivery {
    protected String type;
    protected double weight;
    protected double distance;

    public Delivery(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 20.0 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    private final double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 35.0 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split("\\s+");
            String type = parts[0].toUpperCase();
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            switch (type) {
                case "STANDARD":
                    deliveries.add(new StandardDelivery(weight, distance));
                    break;
                case "EXPRESS":
                    deliveries.add(new ExpressDelivery(weight, distance));
                    break;
                case "INTERNATIONAL":
                    double customsFee = Double.parseDouble(parts[3]);
                    deliveries.add(new InternationalDelivery(weight, distance, customsFee));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown delivery type: " + type);
            }
        }

        double grandTotal = 0.0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.printf(Locale.US, "%s: %.2f%n", d.getType(), fee);
            grandTotal += fee;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
