package session_one_topic.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonRepeating {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word or short sentence: ");
        String text = input.nextLine();

        Map<Character, Integer> frequency = new HashMap<>();

        for (char ch : text.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        char result = '\0';
        for (char ch : text.toCharArray()) {
            if (frequency.get(ch) == 1) {
                result = ch;
                break;
            }
        }

        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }
    }
}
