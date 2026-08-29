import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
    static int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of days: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) { System.out.print("Day " + (i+1) + " price: "); prices[i] = sc.nextInt(); }
        System.out.println("Max Profit: " + maxProfit(prices));
        sc.close();
    }
}
