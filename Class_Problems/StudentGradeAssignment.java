import java.util.Scanner;

public class StudentGradeAssignment {
    public static String getGrade(int marks) {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 60) return "C";
        if (marks >= 40) return "D";
        return "F";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            int marks = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Grade " + getGrade(marks));
        }

        scanner.close();
    }
}
