import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * 1.5 * rate;
    }
}

class InternStaff extends StaffMember {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<StaffMember> staff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0].toUpperCase();
            String name = parts[1];

            switch (type) {
                case "FULLTIME":
                    staff.add(new FullTimeStaff(name, Double.parseDouble(parts[2])));
                    break;
                case "HOURLY":
                    staff.add(new HourlyStaff(name, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                    break;
                case "INTERN":
                    staff.add(new InternStaff(name, Double.parseDouble(parts[2])));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown staff type: " + type);
            }
        }

        double totalPayroll = 0.0;
        for (StaffMember s : staff) {
            double pay = s.calculatePay();
            System.out.printf(Locale.US, "%s: %.2f%n", s.getName(), pay);
            totalPayroll += pay;
        }

        System.out.printf(Locale.US, "Total Payroll: %.2f%n", totalPayroll);
        scanner.close();
    }
}
