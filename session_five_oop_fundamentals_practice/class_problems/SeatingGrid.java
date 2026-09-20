package session_five_oop_fundamentals_practice.class_problems;
public class SeatingGrid {

    // Helper: computes the average of ONE row — nothing else
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]); // helper called once per row
            String zone = (avg < threshold) ? "Quiet Zone" : "Buzzing Zone";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ").append(zone);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
        // Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}