package session_eleven_dsa.class_problems;


import java.util.*;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int low = 0, high = n - 1;
        int position = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                position = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(position);
    }
}

