public class DuplicatePlayerPickChecker {

    // Problem 2: Duplicate Player Pick Checker
    // Compares names using plain nested loops (no Collections).
    // Reports the first duplicate found in order, or "No Duplicates Found".
    public static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(lineup1));
        // Expected: Duplicate Found: Kohli

        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(lineup2));
        // Expected: No Duplicates Found
    }
}
