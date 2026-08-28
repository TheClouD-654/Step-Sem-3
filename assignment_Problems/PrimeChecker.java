import java.util.Scanner;

public class PrimeChecker {
    static void checkPrime(int n) {
        boolean isPrime = n > 1;
        for (int i = 2; i <= n / 2 && isPrime; i++) {
            if (n % i == 0) isPrime = false;
        }
        System.out.println(isPrime ? "Prime" : "Not Prime");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        checkPrime(sc.nextInt());
        sc.close();
    }
}
