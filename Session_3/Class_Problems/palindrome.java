import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int origNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }

        if (origNumber == reversedNumber) {
            System.out.println("The number " + origNumber + " is a Palindrome.");
        } else {
            System.out.println("The number " + origNumber + " is not a Palindrome.");
        }

        sc.close();
    }
}
