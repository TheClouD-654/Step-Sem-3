import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TransactionDuplicateCheck {
    public static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    // Chosen: HashSet approach — Time: O(n) average, Space: O(n)
    // Alternative: Sort the array first — Time: O(n log n), Space: O(1) or O(n)
    //   Sorting uses less memory if done in-place but takes longer
    // Another alternative: Nested loops — Time: O(n^2), Space: O(1), much slower
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] ids = scanner.nextLine().trim().split("\\s+");

        System.out.println(hasDuplicate(ids));
        scanner.close();
    }
}
