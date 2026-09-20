package session_seven_oop_fundamentals.class_problems;

public class Scorecard {

    private final boolean[] results; // fixed size, private forever
    private int recorded = 0;        // how many answers recorded so far

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
    }

    public void recordAnswer(boolean correct) {
        if (recorded >= results.length) {
            System.out.println("Rejected: all questions already answered");
            return;
        }
        results[recorded] = correct;
        recorded++;
    }

    public int getScore() {   // only a number leaves the class — never the array
        int score = 0;
        for (int i = 0; i < recorded; i++) {
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
        sc.recordAnswer(true); // ignored — past the fixed count
        System.out.println("score = " + sc.getScore()); // 3
    }
}