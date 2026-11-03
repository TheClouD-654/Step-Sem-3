import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    // Approach 1 — Brute force: O(n^2) time, O(1) space
    // Approach 2 — HashSet (used): O(n) time, O(n) space
    // Approach 3 — Sort + two pointers: O(n log n) time, O(1) space
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        System.out.println(hasPairWithSum(nums, target));
        scanner.close();
    }
}
