package session_five_oop_fundamentals_practice.assignment_problems;

import java.util.Arrays;

public class ScoreMultiplier {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2;       // Captain: 2x
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5; // Vice-captain: 1.5x
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores)); // [40.0, 110.0, 30.0, 93.0]
    }
}