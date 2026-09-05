package session_one_topic.class_problems;
public class PalindromeCheck {
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] chars = text.toCharArray();
        String reversed = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }
        return text.equals(reversed);
    }
    public static void main(String[] args) {
        String[] testCases = {"madam", "hello"};
        for (String text : testCases) {
            boolean iter = isPalindromeIterative(text);
            boolean rec = isPalindromeRecursive(text);
            boolean arr = isPalindromeArrayReversal(text);
            System.out.println("Input: \"" + text + "\"");
            System.out.println("Iterative: " + (iter ? "Palindrome" : "Not Palindrome") +
                               " | Recursive: " + (rec ? "Palindrome" : "Not Palindrome") +
                               " | Array Reversal: " + (arr ? "Palindrome" : "Not Palindrome") + "\n");
        }
    }
}