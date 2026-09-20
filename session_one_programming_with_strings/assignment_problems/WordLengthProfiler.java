package session_one_programming_with_strings.assignment_problems;

public class WordLengthProfiler {

    static void classifyWordLengths(String review) {
        String[] words = review.split(" ");

        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            int len = word.length();

            if (len <= 4) {
                shortCount++;
            } else if (len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling"); // Short: 3 | Medium: 1 | Long: 3
    }
}