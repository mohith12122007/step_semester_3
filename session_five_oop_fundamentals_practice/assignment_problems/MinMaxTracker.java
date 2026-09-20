package session_five_oop_fundamentals_practice.assignment_problems;

public class MinMaxTracker {

    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int s : scores) {
            if (s < min) {
                min = s;
            }
            if (s > max) {
                max = s;
            }
        }

        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        System.out.println(findMinMaxSpread(new int[]{45, 82, 79, 90, 33, 90, 61})); // Min: 33 | Max: 90 | Spread: 57
    }
}