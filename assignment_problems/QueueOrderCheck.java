import java.util.Scanner;

public class QueueOrderCheck {
    public static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tokens = new int[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = scanner.nextInt();
        }

        int result = firstBreak(tokens);
        System.out.println(result);
        scanner.close();
    }
}
