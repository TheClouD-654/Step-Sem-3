import java.util.Arrays;
import java.util.Scanner;

public class PrizeTable {
    public static int prizeTable(int[] marks) {
        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        int swaps = prizeTable(marks);
        System.out.println(Arrays.toString(marks) + "swaps = " + swaps);
        scanner.close();
    }
}
