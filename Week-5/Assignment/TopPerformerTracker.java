public class TopPerformerTracker {

    // Problem 3: Top Performer Tracker
    // Single-pass min and max tracking without sorting
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            throw new IllegalArgumentException("Scores array must have at least 2 elements.");
        }

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;
        return String.format("Min: %d | Max: %d | Spread: %d", min, max, spread);
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores));
        // Output: Min: 33 | Max: 90 | Spread: 57
    }
}
