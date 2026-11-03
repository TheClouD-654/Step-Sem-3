import java.util.Scanner;

public class WarehouseBinGridScan {
    public static void warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1, maxRow = 0, maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")");
    }

    // Time: O(m * n), Space: O(1) additional
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        warehouseSummary(grid);
        scanner.close();
    }
}

