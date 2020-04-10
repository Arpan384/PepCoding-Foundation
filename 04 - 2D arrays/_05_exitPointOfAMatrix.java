// Question

//   1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
// 4. Consider this array a maze and a player enters from top-left corner in east direction.
// 5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
// 6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.

import java.util.*;

public class _05_exitPointOfAMatrix {
    public static boolean isSafe(int sr, int sc, int[][] mat) {
        if (sr <= -1 || sc <= -1 || sr >= mat.length || sc >= mat[0].length)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        int curr = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int[] prev = { -1, -1 };
        int sr = 0, sc = 0;

        // while(true){
        while (isSafe(sr, sc, mat)) {
            prev[0] = sr;
            prev[1] = sc;

            if (mat[sr][sc] == 1) {
                curr = (curr + 1) % directions.length;
            }
            sr += directions[curr][0];
            sc += directions[curr][1];
        }
        // }

        System.out.println(prev[0] + "\n" + prev[1]);
    }
}