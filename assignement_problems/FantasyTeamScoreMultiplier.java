import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    // Problem 1: Fantasy Team Score Multiplier
    // Captain gets 2x points, Vice-Captain gets 1.5x points.
    // Modifies the caller's array directly in place.
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
        // Expected: [40.0, 110.0, 30.0, 93.0]
    }
}
