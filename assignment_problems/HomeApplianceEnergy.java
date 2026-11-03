import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    protected String name;
    protected double hours;
    protected boolean saverRequested;
    private static final double COST_PER_UNIT = 8.0;

    public Appliance(String name, double hours, boolean saverRequested) {
        this.name = name;
        this.hours = hours;
        this.saverRequested = saverRequested;
    }

    public String getName() {
        return name;
    }

    public boolean isSaverRequested() {
        return saverRequested;
    }

    protected abstract double getPowerWatts();

    public double calculateUnits() {
        double units = getPowerWatts() * hours / 1000.0;
        if (saverRequested && this instanceof SaverMode) {
            units = ((SaverMode) this).applySaver(units);
        }
        return units;
    }

    public double calculateCost() {
        return calculateUnits() * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saverRequested) {
        super("FRIDGE", hours, saverRequested);
    }

    @Override
    protected double getPowerWatts() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {
    public AC(double hours, boolean saverRequested) {
        super("AC", hours, saverRequested);
    }

    @Override
    protected double getPowerWatts() {
        return 1500.0;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    public TV(double hours, boolean saverRequested) {
        super("TV", hours, saverRequested);
    }

    @Override
    protected double getPowerWatts() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    public Washer(double hours, boolean saverRequested) {
        super("WASHER", hours, saverRequested);
    }

    @Override
    protected double getPowerWatts() {
        return 500.0;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Appliance> appliances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equalsIgnoreCase("SAVER");

            switch (type) {
                case "FRIDGE":
                    appliances.add(new Fridge(hours, saver));
                    break;
                case "AC":
                    appliances.add(new AC(hours, saver));
                    break;
                case "TV":
                    appliances.add(new TV(hours, saver));
                    break;
                case "WASHER":
                    appliances.add(new Washer(hours, saver));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown appliance: " + type);
            }
        }

        double totalCost = 0.0;
        for (Appliance a : appliances) {
            if (a.isSaverRequested() && !(a instanceof SaverMode)) {
                System.out.printf(Locale.US, "%s: saver mode not supported%n", a.getName());
            } else {
                double units = a.calculateUnits();
                double cost = a.calculateCost();
                System.out.printf(Locale.US, "%s: Units=%.2f Cost=%.2f%n", a.getName(), units, cost);
                totalCost += cost;
            }
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}
