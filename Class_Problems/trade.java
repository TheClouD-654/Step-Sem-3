import java.util.Scanner;

public class trade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] prices = new int[7];

        for (int i = 0; i < prices.length; i++) {
            System.out.print("Enter price for day " + (i + 1) + ": ");
            prices[i] = input.nextInt();
        }

        int minimum = prices[0];
        int maximum = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minimum) {
                minimum = prices[i];
            }
            if (prices[i] > maximum) {
                maximum = prices[i];
            }
        }

        System.out.println("Minimum price: " + minimum);
        System.out.println("Maximum price: " + maximum);
        input.close();
    }
}
