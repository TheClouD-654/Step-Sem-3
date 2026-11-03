import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {
    protected String type;
    protected double km;
    protected String time;
    private static final double MINIMUM_FARE = 100.0;

    public Cab(String type, double km, String time) {
        this.type = type;
        this.km = km;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    protected abstract double getRatePerKm();

    public boolean isNightTrip() {
        return time.equalsIgnoreCase("NIGHT");
    }

    public double calculateFare() {
        double fare = km * getRatePerKm();
        fare = Math.max(fare, MINIMUM_FARE);
        if (isNightTrip() && this instanceof NightService) {
            fare = ((NightService) this).applyNightCharge(fare);
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) {
        super("MINI", km, time);
    }

    @Override
    protected double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km, String time) {
        super("SEDAN", km, time);
    }

    @Override
    protected double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double km, String time) {
        super("SUV", km, time);
    }

    @Override
    protected double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Cab> cabs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            double km = Double.parseDouble(parts[1]);
            String time = parts[2].toUpperCase();

            switch (type) {
                case "MINI":
                    cabs.add(new MiniCab(km, time));
                    break;
                case "SEDAN":
                    cabs.add(new SedanCab(km, time));
                    break;
                case "SUV":
                    cabs.add(new SUVCab(km, time));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cab type: " + type);
            }
        }

        double total = 0.0;
        for (Cab cab : cabs) {
            if (cab.isNightTrip() && !(cab instanceof NightService)) {
                System.out.printf(Locale.US, "%s: night service not available%n", cab.getType());
            } else {
                double fare = cab.calculateFare();
                System.out.printf(Locale.US, "%s: %.2f%n", cab.getType(), fare);
                total += fare;
            }
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        scanner.close();
    }
}
