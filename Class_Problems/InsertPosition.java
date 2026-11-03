import java.util.Scanner;

public class InsertPosition {
    public static int searchInsertPosition(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // Time: O(log n) — binary search on sorted array, appropriate for frequent lookups
    // Space: O(1)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        System.out.println(searchInsertPosition(nums, target));
        scanner.close();
    }
}

