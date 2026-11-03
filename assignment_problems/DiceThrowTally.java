import java.util.Arrays;
import java.util.Scanner;

public class DiceThrowTally {
    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }

        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            if (v > 1) System.out.print(" ");
            System.out.print(v + ":" + count[v]);
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[idx++] = v;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] rolls = new int[n];
        for (int i = 0; i < n; i++) {
            rolls[i] = scanner.nextInt();
        }

        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));
        scanner.close();
    }
}
