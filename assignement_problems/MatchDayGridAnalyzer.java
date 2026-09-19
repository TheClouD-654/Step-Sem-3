public class MatchDayGridAnalyzer {

    // Problem 4: Match Day Grid Analyzer
    // Helper method to calculate the average score of a single match (row).
    static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    // Classifies each match as "Power Surge" (>= threshold) or "Normal" (< threshold).
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            result.append("Match ").append(i).append(": ").append(status);

            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println(classifyMatches(runs, threshold));
        // Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}
