public class NameTag {
    // Stored as final fields to ensure immutability
    private final String firstName;
    private final String lastName;
    private final String nickname;

    // Constructor: splits the full name once upon creation
    public NameTag(String fullName) {
        String[] parts = fullName.trim().split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
        this.nickname = this.firstName + " " + this.lastName.charAt(0) + ".";
    }

    // Returns the pre-built nickname
    public String getNickname() {
        return nickname;
    }

    // Optional getters for first and last name (immutable)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> \"" + tag.getNickname() + "\"");
        // Expected: "Maria G."
    }
}
