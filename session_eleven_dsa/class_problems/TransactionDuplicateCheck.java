package session_eleven_dsa.class_problems;


import java.util.*;

public class TransactionDuplicateCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashSet<String> set = new HashSet<>();
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            String id = sc.next();

            if (set.contains(id)) {
                duplicate = true;
            }

            set.add(id);
        }

        System.out.println(duplicate);
    }
}
