import java.util.Scanner;

public class ExamScoreBandCounter {
    // Returns index of first element >= target
    private static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // Returns index of first element > target
    private static int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static int countInBand(int[] scores, int low, int high) {
        int left = lowerBound(scores, low);
        int right = upperBound(scores, high);
        return right - left;
    }

    // Linear scan: O(n) time, O(1) space
    // Binary search solution: O(log n) time, O(1) space
    // Duplicates at edges require finding first >= low and first > high, not just any match
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        int low = scanner.nextInt();
        int high = scanner.nextInt();

        System.out.println(countInBand(scores, low, high));
        scanner.close();
    }
}
