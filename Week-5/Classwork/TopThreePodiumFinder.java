import java.util.Arrays;

public class TopThreePodiumFinder {

    // Problem 3: Top-3 Podium Finder
    // Single pass without sorting or Arrays.sort to track top 3 scores in descending order
    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            throw new IllegalArgumentException("Scores array must have at least 3 elements.");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score >= third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        int[] result = findTopThreeScores(scores);
        System.out.println(Arrays.toString(result)); // Output: [90, 90, 82]
    }
}
