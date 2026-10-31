package session_eleven_dsa.class_problems;


import java.util.*;

public class LibraryCatalogLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] isbn = new String[n];
        String[] title = new String[n];

        for (int i = 0; i < n; i++) {
            isbn[i] = sc.next();
            title[i] = sc.next();
        }

        String target = sc.next();

        int low = 0, high = n - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isbn[mid].equals(target)) {
                System.out.println(title[mid]);
                found = true;
                break;
            } else if (isbn[mid].compareTo(target) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (!found)
            System.out.println("Not Found");
    }
}
