public class Scorecard {
    private final boolean[] results;
    private final int totalQuestions;
    private int recordedCount;

    // Constructor: total questions is fixed at creation
    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    // Records the next answer's result; rejects if all questions are already answered
    public void recordAnswer(boolean isCorrect) {
        if (recordedCount >= totalQuestions) {
            System.out.println("Cannot record more answers: limit reached (" + totalQuestions + ")");
            return;
        }
        results[recordedCount++] = isCorrect;
    }

    // Computes and returns the total score (count of correct answers)
    // Never exposes the internal array
    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("sc.getScore() -> " + sc.getScore());
        // Expected: 3
    }
}
