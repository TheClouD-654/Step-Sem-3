import java.util.Scanner;

public class BusiestBusRow {
    public static void busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = 0;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        System.out.println("Row " + bestRow + ", Total " + bestTotal);
    }

    // Time: O(r * c), Space: O(1) additional
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        busiestRow(grid);
        scanner.close();
    }
}
