import java.util.Scanner;

public class BankTransactionReference {
    public static String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference.toUpperCase();
        }

        return reference.substring(0, 3).toUpperCase() + reference.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);
        StringBuilder output = new StringBuilder();
        output.append("[").append(bankCode).append("] DATE: ");
        output.append(date.substring(0, 2)).append("/");
        output.append(date.substring(2, 4)).append("/");
        output.append(date.substring(4, 6)).append(" | SEQ: ");
        output.append(sequence);
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String rawReference = scanner.nextLine();
        String reference = normalizeReference(rawReference);
        System.out.println(validateAndFormat(reference));
        scanner.close();
    }
}
