import java.util.Arrays;
import java.util.Scanner;

public class HeightLineUp {
    public static void lineUp(int[] heights) {
        int n = heights.length;
        for (int pass = 1; ; pass++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        lineUp(heights);
        scanner.close();
    }
}
