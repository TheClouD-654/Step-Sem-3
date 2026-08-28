import java.util.Scanner;

public class BmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("\nPerson\tHeight\tWeight\tBMI\tStatus");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.println((i + 1) + "\t" + heights[i] + "\t" + weights[i] + "\t" + bmi + "\t" + getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        double[] heights = new double[count];
        double[] weights = new double[count];
        for (int i = 0; i < count; i++) {
            try {
                System.out.print("Person " + (i + 1) + " height (m): ");
                heights[i] = scanner.nextDouble();
                System.out.print("Person " + (i + 1) + " weight (kg): ");
                weights[i] = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Please enter numbers only.");
                return;
            }
        }
        printWellnessReport(heights, weights);
        scanner.close();
    }
}
