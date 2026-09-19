import java.util.Arrays;

// Player class implementing Comparable<Player> for standard library sorting
class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Ranks players by batting average (fantasy points) in descending order
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class AutoDraftRankingEngine {

    // Overloaded rule 1: Established players qualify on matches played alone (>= 10)
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded rule 2: Newer players qualify if reasonably experienced (>= 5) and not injured
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Filters draftable players, sorts them using Arrays.sort, and returns ranked display string
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        // Count how many players qualify
        int draftableCount = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableCount++;
            }
        }

        // Collect qualifying players into an array
        Player[] draftable = new Player[draftableCount];
        int index = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable[index++] = p;
            }
        }

        // Sort by batting average descending using Player's compareTo
        Arrays.sort(draftable);

        // Build the formatted ranking string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].name);
            if (i < draftable.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
        // Expected: 1. Rahul | 2. Virat | 3. Dev
    }
}
