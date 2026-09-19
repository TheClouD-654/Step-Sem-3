public class Student {
    // Instance fields
    String name;
    double attendance;

    // Static fields shared across all student instances
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor: increments the static counter on every creation
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method: only accesses static fields
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 85.5);
        Student s2 = new Student("Priya", 92.0);

        // Called through the class name, not an instance
        Student.printCollegeInfo();
    }
}
