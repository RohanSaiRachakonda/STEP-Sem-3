import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    // Problem 1: Fantasy Team Score Multiplier
    // Applies 2x multiplier to Captain and 1.5x to Vice-Captain in-place
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }
        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        System.out.println("Before: " + Arrays.toString(scores));
        applyMultipliers(scores, 1, 3);
        System.out.println("After: " + Arrays.toString(scores));
        // Output: [40.0, 110.0, 30.0, 93.0]
    }
}
