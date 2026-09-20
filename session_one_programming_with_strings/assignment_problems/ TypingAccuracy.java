package session_one_programming_with_strings.assignment_problems;

public class TypingAccuracy {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPos = -1; // -1 means no mismatch

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based position
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        System.out.print("Matched: " + matched + "/" + original.length()
                + " | Accuracy: " + String.format("%.2f", accuracy) + "%");

        if (firstMismatchPos == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position " + firstMismatchPos
                    + " ('" + original.charAt(firstMismatchPos - 1)
                    + "' vs '" + typed.charAt(firstMismatchPos - 1) + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt"); 
        checkTypingAccuracy("coding", "coding");          
    }
}