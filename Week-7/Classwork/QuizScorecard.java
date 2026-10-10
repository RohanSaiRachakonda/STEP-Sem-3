public class QuizScorecard {
    // Private array storing results internally
    private final boolean[] answers;
    private int count;

    public QuizScorecard(int totalQuestions) {
        this.answers = new boolean[totalQuestions];
        this.count = 0;
    }

    // Record next answer's result; ignores/rejects if beyond fixed question count
    public void recordAnswer(boolean isCorrect) {
        if (count < answers.length) {
            answers[count++] = isCorrect;
        } else {
            System.out.println("Rejected: Cannot record more than " + answers.length + " questions.");
        }
    }

    // Expose only the total score (count of correct answers)
    public int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        QuizScorecard sc = new QuizScorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}
