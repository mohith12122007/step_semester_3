package session_five_oop_fundamentals_practice.class_problems;

import java.util.Arrays;

public class TopThree {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int s : scores) {
            if (s > first) {
                third = second;
                second = first;
                first = s;
            } else if (s > second) {
                third = second;
                second = s;
            } else if (s > third) {
                third = s;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTopThreeScores(new int[]{45, 82, 79, 90, 33, 90, 61}))); // [90, 90, 82]
    }
}