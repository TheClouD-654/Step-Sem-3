import java.util.Locale;
import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double getAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 60) return "C";
        if (avg >= 40) return "D";
        return "F";
    }

    public void printResult() {
        System.out.printf(Locale.US, "%s: Average %.1f, Grade %s%n",
                name.toUpperCase(), getAverage(), getGrade());
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String name = parts[0];
            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) {
                marks[j] = Integer.parseInt(parts[j + 1]);
            }
            Student student = new Student(name, marks);
            student.printResult();
        }

        scanner.close();
    }
}
