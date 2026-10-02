import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.00;
    }
}

public class FestivalBonusCalculator {
    public static Employee createEmployee(String type, String name, double salary) {
        switch (type.toUpperCase()) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            case "INTERN":
                return new InternEmployee(name, salary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            employees.add(createEmployee(type, name, salary));
        }

        double grandTotal = 0.0;
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            System.out.printf(Locale.US, "%s: %.2f%n", emp.getName(), bonus);
            grandTotal += bonus;
        }

        System.out.printf(Locale.US, "Total Bonus: %.2f%n", grandTotal);
        scanner.close();
    }
}
