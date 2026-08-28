import java.util.Scanner;

public class NumberPyramid {
    static void printNumberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        printNumberPyramid(sc.nextInt());
        sc.close();
    }
}
