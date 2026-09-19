public class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Static fields (shared company information)
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor for permanent employees (with known salary)
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
        employeeCount++;
    }

    // Constructor for interns (chains via this(...) with salary = 0)
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    // Overloaded constructor for empName and salary (used in M5)
    public Employee(String empName, double salary) {
        this("EMP-" + (employeeCount + 1), empName, salary);
    }

    // Prints all four fields on one line
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    // Static method to print company information without referencing instance fields
    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        Employee permanentEmp = new Employee("E-101", "Divya", 65000);
        Employee internEmp = new Employee("E-102", "Arjun");

        permanentEmp.printProfile();
        internEmp.printProfile();
    }
}
