package session_eleven_dsa.class_problems;


import java.util.*;

public class WarehouseBinGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        int total = 0;
        int max = -1;
        int row = 0, col = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                total += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println("Total = " + total);
        System.out.println("Max Coordinate = (" + row + ", " + col + ")");
    }
}
