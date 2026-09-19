package session_two_string_operations_performance.class_problems;

public class VowelConsonantCounter {

    static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        String lower = text.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");   // Vowels: 5 | Consonants: 10
        countVowelsAndConsonants("HELLO World");        // Vowels: 3 | Consonants: 7
    }
}