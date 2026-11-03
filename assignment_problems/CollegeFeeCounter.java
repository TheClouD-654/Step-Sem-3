import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class CollegeStudent {
    protected String name;
    private static final double TRANSPORT_FEE = 12000.0;

    public CollegeStudent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTuition();

    public double calculateTotalFee() {
        double fee = calculateTuition();
        if (this instanceof BusUser) {
            fee += TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholar extends CollegeStudent implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

class Hosteller extends CollegeStudent {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class Scholar extends CollegeStudent implements BusUser {
    public Scholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<CollegeStudent> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            String name = parts[1];

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new Scholar(name));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown student type: " + type);
            }
        }

        double totalCollected = 0.0;
        for (CollegeStudent s : students) {
            double fee = s.calculateTotalFee();
            System.out.printf(Locale.US, "%s: %.2f%n", s.getName(), fee);
            totalCollected += fee;
        }

        System.out.printf(Locale.US, "Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}
