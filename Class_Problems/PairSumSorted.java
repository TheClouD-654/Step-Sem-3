import java.util.Scanner;

public class PairSumSorted {
    public static void pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                System.out.println("(" + nums[left] + ", " + nums[right] + ")");
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Not Found");
    }

    // Two-pointer: O(n) time, O(1) space
    // Without using sorted property (e.g., brute force): O(n^2) time, O(1) space
    // HashSet approach (ignoring sorted): O(n) time, O(n) space
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        pairSumSorted(nums, target);
        scanner.close();
    }
}
