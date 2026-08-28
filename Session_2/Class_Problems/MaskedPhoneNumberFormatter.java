import java.util.Scanner;

public class MaskedPhoneNumberFormatter {
    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFourDigits = phone.substring(6);
        StringBuilder maskedNumber = new StringBuilder("XXXXXX" + lastFourDigits);
        maskedNumber.insert(6, "-");
        return maskedNumber.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10-digit phone number: ");
        String phone = scanner.nextLine();
        System.out.println(maskPhoneNumber(phone));
        scanner.close();
    }
}
