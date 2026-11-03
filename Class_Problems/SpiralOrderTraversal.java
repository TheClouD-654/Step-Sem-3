import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralOrderTraversal {
    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid.length == 0) return result;

        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) result.add(grid[top][j]);
            top++;

            for (int i = top; i <= bottom; i++) result.add(grid[i][right]);
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(grid[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(grid[i][left]);
                left++;
            }
        }

        return result;
    }

    // Time: O(m * n), Space: O(m * n) for output
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

        System.out.println(spiralOrder(grid));
        scanner.close();
    }
}
