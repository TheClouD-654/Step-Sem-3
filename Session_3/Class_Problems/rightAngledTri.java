import java.util.Scanner;

public class rightAngledTri{
    public static void main(String[] args) {
        int a, i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how man rows you want: ");
        a=sc.nextInt();
        for(i=0; i<a; i++) {
            System.out.print("*".repeat(i+1)+"\n");
        }
        
    }
}