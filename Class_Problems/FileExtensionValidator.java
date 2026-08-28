import java.util.Scanner;

public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        int dotPosition = filename.lastIndexOf('.');

        if (dotPosition == -1 || dotPosition == filename.length() - 1) {
            return "Rejected - invalid file type";
        }

        String extension = filename.substring(dotPosition + 1);
        if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx") || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected - invalid file type";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();
        System.out.println(validateFileExtension(filename));
        scanner.close();
    }
}
