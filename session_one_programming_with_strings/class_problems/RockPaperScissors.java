package session_one_topic.class_problems;

import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        String[] predefinedPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"}; // Example sequence

        int wins = 0, losses = 0, draws = 0;
        int totalRounds = 5;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            String playerMove = predefinedPlayerMoves[i];
            String computerMove = moves[random.nextInt(moves.length)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Round " + (i + 1) + " | " + playerMove + " | " + computerMove + " | " + result);
        }

        double winPercentage = ((double) wins / totalRounds) * 100.0;
        System.out.println("\nFinal Summary (after " + totalRounds + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }
}