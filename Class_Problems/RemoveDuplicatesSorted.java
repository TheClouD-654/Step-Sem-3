import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesSorted {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int writeIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[writeIndex]) {
                writeIndex++;
                nums[writeIndex] = nums[i];
            }
        }

        return writeIndex + 1;
    }

    // Time: O(n), Space: O(1) additional — qualifies as in-place
    // Uses two pointers: one reads, one writes unique values
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.print("nums[0.." + (length - 1) + "] = [");
        for (int i = 0; i < length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(nums[i]);
        }
        System.out.println("]");

        scanner.close();
    }
}

