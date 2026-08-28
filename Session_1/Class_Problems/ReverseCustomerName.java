import java.util.Scanner;

public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        String reversed = "";
        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversed = reversed + customerName.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
        scanner.close();
    }
}
