import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Connection {
    protected String type;
    protected int units;

    public Connection(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateBill();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return 5.0 * units;
        }
        return 5.0 * 100 + 7.0 * (units - 100);
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return 8.0 * units + 100;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        double bill = 6.0 * units;
        return Math.max(bill, 1000.0);
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            int units = Integer.parseInt(parts[1]);

            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown connection type: " + type);
            }
        }

        double total = 0.0;
        for (Connection conn : connections) {
            double bill = conn.calculateBill();
            System.out.printf(Locale.US, "%s: %.2f%n", conn.getType(), bill);
            total += bill;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        scanner.close();
    }
}
