import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract String getShape();

    public abstract double calculateArea();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String shape = parts[0].toUpperCase();
            String owner = parts[1];

            switch (shape) {
                case "CIRCLE":
                    plots.add(new CirclePlot(owner, Double.parseDouble(parts[2])));
                    break;
                case "RECTANGLE":
                    plots.add(new RectanglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                    break;
                case "TRIANGLE":
                    plots.add(new TrianglePlot(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown shape: " + shape);
            }
        }

        double totalArea = 0.0;
        for (Plot plot : plots) {
            double area = plot.calculateArea();
            System.out.printf(Locale.US, "%s (%s): %.2f%n", plot.getOwner(), plot.getShape(), area);
            totalArea += area;
        }

        System.out.printf(Locale.US, "Total Area: %.2f%n", totalArea);
        scanner.close();
    }
}
