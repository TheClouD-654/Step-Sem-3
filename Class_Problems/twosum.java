import java.util.Scanner;

public class TwoSum {
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) { System.out.print("nums[" + i + "]: "); nums[i] = sc.nextInt(); }
        System.out.print("Target: ");
        int[] res = twoSum(nums, sc.nextInt());
        System.out.println("Indices: [" + res[0] + ", " + res[1] + "]");
        sc.close();
    }
}
