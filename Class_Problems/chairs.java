import java.util.Scanner;

public class chairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many roll numbers are there? ");
        int size = input.nextInt();
        int[] rollNumbers = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter roll number " + (i + 1) + ": ");
            rollNumbers[i] = input.nextInt();
        }

        boolean duplicateFound = false;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (rollNumbers[i] == rollNumbers[j]) {
                    System.out.println(rollNumbers[i] + " is repeated.");
                    duplicateFound = true;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No roll number is repeated.");
        }

        input.close();
    }
}
