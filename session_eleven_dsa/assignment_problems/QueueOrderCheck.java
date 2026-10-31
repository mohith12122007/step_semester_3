package session_eleven_dsa.assignment_problems;


import java.util.*;

public class QueueOrderCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int position = -1;

        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                position = i;
                break;
            }
        }

        System.out.println(position);
    }
}
