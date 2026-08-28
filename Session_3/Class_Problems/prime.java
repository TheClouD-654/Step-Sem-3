import java.util.Scanner;

public class prime {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        boolean isPrime=true;
        int a;
        System.out.print("Enter a no.");
        a=sc.nextInt();

        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime){
            System.out.println("Is Prime");
        }
        else{
            System.out.println("Is not Prime");
        }
        sc.close();
    }
}
