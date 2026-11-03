import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeIdLookup {
    public static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    // buildLookup: O(n) time, O(n) space
    // getDepartment: O(1) average time after lookup is built
    // HashMap is ideal because queries vastly outnumber updates
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[][] records = new String[n][2];
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            records[i][0] = parts[0];
            records[i][1] = parts[1];
        }

        Map<String, String> lookup = buildLookup(records);

        int q = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < q; i++) {
            String id = scanner.nextLine().trim();
            System.out.println(getDepartment(lookup, id));
        }

        scanner.close();
    }
}
