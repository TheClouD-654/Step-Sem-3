public class EmployeeCompanyInfo {
    public static void main(String[] args) {
        // Reset count for fresh demonstration
        Employee.employeeCount = 0;

        // Create three Employee objects
        Employee emp1 = new Employee("Divya", 65000);
        Employee emp2 = new Employee("Arjun", 25000);
        Employee emp3 = new Employee("Kavya", 70000);

        // Call printCompanyInfo() through the class name, not through any object
        Employee.printCompanyInfo();
    }
}
