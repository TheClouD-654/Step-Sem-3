import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) result[i] = result[i-1] * nums[i-1];
        int right = 1;
        for (int i = n-1; i >= 0; i--) { result[i] *= right; right *= nums[i]; }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) { System.out.print("nums[" + i + "]: "); nums[i] = sc.nextInt(); }
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        sc.close();
    }
}
