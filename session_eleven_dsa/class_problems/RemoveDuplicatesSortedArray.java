package session_eleven_dsa.class_problems;

import java.util.*;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (n == 0) {
            System.out.println("Length = 0");
            return;
        }

        int j = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }

        System.out.println("Length = " + (j + 1));

        for (int i = 0; i <= j; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

