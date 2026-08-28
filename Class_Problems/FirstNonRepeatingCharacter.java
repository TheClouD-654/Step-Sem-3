import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        int[] count = new int[256];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (count[text.charAt(i)] == 1) return text.charAt(i);
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        char result = findFirstNonRepeatingChar(text);
        if (result == '\0') System.out.println("No Non-Repeating Character Found");
        else System.out.println("First Non-Repeating Character: '" + result + "'");
        scanner.close();
    }
}
