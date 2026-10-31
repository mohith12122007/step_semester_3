package session_eleven_dsa.assignment_problems;


import java.util.*;

public class DiceThrowTally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] rolls = new int[n];

        int[] count = new int[7];

        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
            count[rolls[i]]++;
        }

        System.out.print("Counts: ");

        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i] + " ");
        }

        System.out.println();

        System.out.print("Sorted: [");

        boolean first = true;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++) {
                if (!first) {
                    System.out.print(", ");
                }

                System.out.print(i);
                first = false;
            }
        }

        System.out.println("]");
    }
}
