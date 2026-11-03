import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;
        if (k == 0) return names;

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];
        }
        return result;
    }

    // Time: O(n), Space: O(n)
    // Rotating one place at a time, k times, is O(n * k) which is very slow for large k
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] names = scanner.nextLine().trim().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine().trim());

        String[] rotated = rotateRoster(names, k);
        System.out.println(Arrays.toString(rotated));
        scanner.close();
    }
}
