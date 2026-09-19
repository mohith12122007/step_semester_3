package session_two_string_operations_performance.assignment_problems;

public class WordReverser {

    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversed = new StringBuilder();

            for (int j = word.length() - 1; j >= 0; j--) {
                reversed.append(word.charAt(j));
            }

            if (i > 0) {
                result.append(" ");
            }
            result.append(reversed);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club")); // olleh bulc
    }
}