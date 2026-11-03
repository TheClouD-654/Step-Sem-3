import java.util.Scanner;

public class BestSingleTradeProfit {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    // Single pass: O(n) time, O(1) space — preferable at scale
    // Brute force (every pair): O(n^2) time, O(1) space
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.println(maxProfit(prices));
        scanner.close();
    }
}

