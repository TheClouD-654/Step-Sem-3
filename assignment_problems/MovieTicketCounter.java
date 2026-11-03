import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Ticket {
    protected String seatType;
    protected int count;
    private static final double CONVENIENCE_FEE = 20.0;

    public Ticket(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    protected abstract double getPricePerTicket();

    public double calculateAmount() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super("REGULAR", count);
    }

    @Override
    protected double getPricePerTicket() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super("PREMIUM", count);
    }

    @Override
    protected double getPricePerTicket() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super("RECLINER", count);
    }

    @Override
    protected double getPricePerTicket() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Ticket> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String seat = parts[0].toUpperCase();
            int count = Integer.parseInt(parts[1]);

            switch (seat) {
                case "REGULAR":
                    bookings.add(new RegularTicket(count));
                    break;
                case "PREMIUM":
                    bookings.add(new PremiumTicket(count));
                    break;
                case "RECLINER":
                    bookings.add(new ReclinerTicket(count));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown seat type: " + seat);
            }
        }

        double total = 0.0;
        for (Ticket t : bookings) {
            double amount = t.calculateAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", t.getSeatType(), amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        scanner.close();
    }
}
