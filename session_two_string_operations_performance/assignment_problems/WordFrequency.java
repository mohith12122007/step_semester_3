package session_two_string_operations_performance.assignment_problems;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class WordFrequency {

    static void printFilteredWordFrequency(String feedback) {
        // 1. Stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        // 2. Normalize: lowercase + strip punctuation
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "");

        // 3. Split into words
        String[] words = cleaned.split("\\s+");

        // 4. Count frequency, skipping stop words
        HashMap<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            boolean isStopWord = false;
            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }
            if (!isStopWord) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // 5. Sort by count (descending) and print
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());

        entries.sort((e1, e2) -> e2.getValue() - e1.getValue());

        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    
    }
}