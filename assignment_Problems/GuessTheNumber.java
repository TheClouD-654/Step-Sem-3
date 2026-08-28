import java.util.Scanner;

public class GuessTheNumber {
    static void guessTheNumber(int secret, int maxTries, Scanner sc) {
        int tries = 0;
        boolean guessed = false;
        while (tries < maxTries && !guessed) {
            System.out.print("Guess: ");
            int guess = sc.nextInt();
            tries++;
            if (guess > secret) System.out.println("Too high");
            else if (guess < secret) System.out.println("Too low");
            else { System.out.println("Correct! You guessed it"); guessed = true; }
        }
        if (!guessed) System.out.println("Out of tries — the number was " + secret);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter secret number: ");
        int secret = sc.nextInt();
        System.out.print("Enter max tries: ");
        int maxTries = sc.nextInt();
        guessTheNumber(secret, maxTries, sc);
        sc.close();
    }
}
