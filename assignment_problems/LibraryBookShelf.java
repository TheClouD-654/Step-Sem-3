import java.util.Arrays;
import java.util.Scanner;

public class LibraryBookShelf {
    public static void shelf(int[] books) {
        int n = books.length;

        for (int i = 1; i < n; i++) {
            int key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;

            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] books = new int[n];
        for (int i = 0; i < n; i++) {
            books[i] = scanner.nextInt();
        }

        shelf(books);
        scanner.close();
    }
}
