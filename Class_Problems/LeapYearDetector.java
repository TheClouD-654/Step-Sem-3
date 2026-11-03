import java.util.Scanner;

public class LeapYearDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            int year = Integer.parseInt(scanner.nextLine().trim());
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            System.out.println(isLeap ? "Leap year" : "Not a leap year");
        }

        scanner.close();
    }
}
