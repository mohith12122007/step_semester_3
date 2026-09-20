package session_five_oop_fundamentals_practice.assignment_problems;
public class MatchGrid {

    // Helper: computes the average of ONE match row — nothing else
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]); // helper called once per match
            String type = (avg >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(type);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
        // Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}