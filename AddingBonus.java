import java.util.Arrays;
import java.util.Scanner;

public class AddingBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter scores separated by spaces: ");
        String[] input = scanner.nextLine().trim().split("\\s+");
        int[] newScores = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            newScores[i] = Integer.parseInt(input[i]) + 10;
        }

        System.out.println(Arrays.toString(newScores));
        scanner.close();
    }
}
