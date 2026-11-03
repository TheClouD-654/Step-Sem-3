import java.util.Scanner;

public class ClassAttendanceTracker {
    public static void attendanceSummary(int[] days) {
        int present = 0, longestStreak = 0, currentStreak = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }
        System.out.println("Present: " + present + ", Longest streak: " + longestStreak);
    }

    // Time: O(n), Space: O(1) — both answers found in a single pass
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = scanner.nextInt();
        }

        attendanceSummary(days);
        scanner.close();
    }
}
