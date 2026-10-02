import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Transport {
    protected String type;
    protected double distance;

    public Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateFare();
}

class BusTransport extends Transport {
    public BusTransport(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(10.0, fare);
    }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroTransport extends Transport {
    private final double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class TransportFareSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split("\\s+");
            String type = parts[0].toUpperCase();
            double distance = Double.parseDouble(parts[1]);

            switch (type) {
                case "BUS":
                    journeys.add(new BusTransport(distance));
                    break;
                case "TRAIN":
                    journeys.add(new TrainTransport(distance));
                    break;
                case "METRO":
                    double factor = Double.parseDouble(parts[2]);
                    journeys.add(new MetroTransport(distance, factor));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown transport type: " + type);
            }
        }

        double grandTotal = 0.0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            System.out.printf(Locale.US, "%s: %.2f%n", t.getType(), fare);
            grandTotal += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
