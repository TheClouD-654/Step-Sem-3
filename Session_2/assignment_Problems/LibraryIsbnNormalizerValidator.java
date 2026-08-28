public class LibraryIsbnNormalizerValidator {
    public static String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() < 3) {
            return code.toUpperCase();
        }

        return code.substring(0, 3).toUpperCase() + code.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year and catalog number must contain digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);
        StringBuilder display = new StringBuilder();
        display.append("[").append(publisherCode).append("] YEAR: ").append(year);
        display.append(" | CATALOG: ").append(catalog);
        return display.toString();
    }

    public static void main(String[] args) {
        String normalizedCode = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalizedCode));
    }
}
