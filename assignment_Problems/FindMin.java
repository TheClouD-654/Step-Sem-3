import java.util.Scanner;

public class FindMin {
    static int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) { System.out.print("nums[" + i + "]: "); nums[i] = sc.nextInt(); }
        System.out.println("Minimum: " + findMin(nums));
        sc.close();
    }
}
