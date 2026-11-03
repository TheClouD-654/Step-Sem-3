import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Booking {
    protected String mode;
    protected double distanceKm;
    private static final double BOOKING_FEE = 50.0;

    public Booking(String mode, double distanceKm) {
        this.mode = mode;
        this.distanceKm = distanceKm;
    }

    public String getMode() {
        return mode;
    }

    protected abstract double calculateBaseFare();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distanceKm) {
        super("BUS", distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2.0 * distanceKm;
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distanceKm) {
        super("TRAIN", distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 1.5 * distanceKm;
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distanceKm) {
        super("FLIGHT", distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2500.0 + 4.0 * distanceKm;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String mode = parts[0].toUpperCase();
            double distance = Double.parseDouble(parts[1]);

            switch (mode) {
                case "BUS":
                    bookings.add(new BusBooking(distance));
                    break;
                case "TRAIN":
                    bookings.add(new TrainBooking(distance));
                    break;
                case "FLIGHT":
                    bookings.add(new FlightBooking(distance));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown mode: " + mode);
            }
        }

        for (Booking b : bookings) {
            double total = b.calculateTotal();
            System.out.printf(Locale.US, "%s: %.2f%n", b.getMode(), total);
        }

        scanner.close();
    }
}
