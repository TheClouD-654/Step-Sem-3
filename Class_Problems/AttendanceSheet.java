public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    // Constructor: initializes internal array with fixed capacity
    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    // Marks a student present; checks first to prevent duplicate counting
    public void markPresent(String name) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }

        // Check if student is already marked present
        if (isPresent(name)) {
            return;
        }

        // Add student if space remains
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount++] = name;
        } else {
            System.out.println("Attendance sheet is full.");
        }
    }

    // Returns total count of present students
    public int getPresentCount() {
        return presentCount;
    }

    // Checks if a specific student is present without exposing the array
    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
