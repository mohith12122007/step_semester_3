package session_eleven_dsa.class_problems;

import java.util.*;

public class EmployeeIDLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String department = sc.next();

            map.put(id, department);
        }

        String searchId = sc.next();

        if (map.containsKey(searchId)) {
            System.out.println(map.get(searchId));
        } else {
            System.out.println("Unknown");
        }
    }
}

