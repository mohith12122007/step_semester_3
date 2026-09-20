package session_one_programming_with_strings.assignment_problems;

public class SignalStreak {

    static void findLongestStreak(String signalLog) {
        char longestColor = signalLog.charAt(0);
        int longestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentLength++;
            } else {
                currentColor = signalLog.charAt(i);
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR"); // Longest Streak: 'G' repeated 3 times
        findLongestStreak("RRRRYYGG"); // Longest Streak: 'R' repeated 4 times
    }
}