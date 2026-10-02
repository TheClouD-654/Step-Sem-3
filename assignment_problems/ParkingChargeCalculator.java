import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Vehicle {
    protected String type;
    protected int hours;

    public Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateCharge();
}

class BikeVehicle extends Vehicle {
    public BikeVehicle(int hours) {
        super("BIKE", hours);
    }

    @Override
    public double calculateCharge() {
        return 10.0 * hours;
    }
}

class CarVehicle extends Vehicle {
    public CarVehicle(int hours) {
        super("CAR", hours);
    }

    @Override
    public double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + ((hours - 1) * 20.0);
    }
}

class TruckVehicle extends Vehicle {
    public TruckVehicle(int hours) {
        super("TRUCK", hours);
    }

    @Override
    public double calculateCharge() {
        double fee = 50.0 * hours;
        return Math.max(100.0, fee);
    }
}

public class ParkingChargeCalculator {
    public static Vehicle createVehicle(String type, int hours) {
        switch (type.toUpperCase()) {
            case "BIKE":
                return new BikeVehicle(hours);
            case "CAR":
                return new CarVehicle(hours);
            case "TRUCK":
                return new TruckVehicle(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            vehicles.add(createVehicle(type, hours));
        }

        double grandTotal = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf(Locale.US, "%s: %.2f%n", v.getType(), charge);
            grandTotal += charge;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
