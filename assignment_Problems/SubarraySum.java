import java.util.*;

public class SubarraySum {
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) { System.out.print("nums[" + i + "]: "); nums[i] = sc.nextInt(); }
        System.out.print("k: ");
        System.out.println("Count: " + subarraySum(nums, sc.nextInt()));
        sc.close();
    }
}
