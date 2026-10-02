import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Room {
    protected String type;
    protected int units;

    public Room(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super("SINGLE", units);
    }

    @Override
    public double calculateBill() {
        return 8.0 * units;
    }
}

class SharedRoom extends Room {
    private final int occupants;

    public SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (6.0 * units) / occupants;
    }
}

class AcRoom extends Room {
    public AcRoom(int units) {
        super("AC", units);
    }

    @Override
    public double calculateBill() {
        return (10.0 * units) + 200.0;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split("\\s+");
            String type = parts[0].toUpperCase();
            int units = Integer.parseInt(parts[1]);

            switch (type) {
                case "SINGLE":
                    rooms.add(new SingleRoom(units));
                    break;
                case "SHARED":
                    int occupants = Integer.parseInt(parts[2]);
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                case "AC":
                    rooms.add(new AcRoom(units));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown room type: " + type);
            }
        }

        double grandTotal = 0.0;
        for (Room room : rooms) {
            double bill = room.calculateBill();
            System.out.printf(Locale.US, "%s: %.2f%n", room.getType(), bill);
            grandTotal += bill;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
