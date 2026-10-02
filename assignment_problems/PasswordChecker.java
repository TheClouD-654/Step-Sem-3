public class PasswordChecker {
    // Stored privately and as final to ensure it can never be altered
    private final String password;

    // Constructor: accepts password once
    public PasswordChecker(String password) {
        this.password = password != null ? password : "";
    }

    // Computes and returns password strength without revealing the password itself
    public String getStrength() {
        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    // Note: No getter method exists for 'password' to maintain strict privacy

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("pc.getStrength() -> " + pc1.getStrength()); // Weak

        PasswordChecker pc2 = new PasswordChecker("mypass12");
        System.out.println("pc2.getStrength() -> " + pc2.getStrength()); // Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("pc3.getStrength() -> " + pc3.getStrength()); // Strong
    }
}
