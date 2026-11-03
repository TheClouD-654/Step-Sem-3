import java.util.Scanner;

public class FactorialCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine().trim());
            long factorial = 1;
            for (int j = 1; j <= num; j++) {
                factorial *= j;
            }
            System.out.println(factorial);
        }

        scanner.close();
    }
}
