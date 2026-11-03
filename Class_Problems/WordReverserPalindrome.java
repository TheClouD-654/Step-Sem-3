import java.util.Scanner;

public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine().trim();
            String reversed = new StringBuilder(word).reverse().toString();

            if (word.equals(reversed)) {
                System.out.println(reversed + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        }

        scanner.close();
    }
}
