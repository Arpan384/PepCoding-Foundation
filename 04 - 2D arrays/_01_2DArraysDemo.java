// Question

//   1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a.
// 4. You are required to display the contents of 2d array as suggested by output format below

import java.util.*;

public class _01_2DArraysDemo {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            mat[i] = new int[m];
            for (int j = 0; j < m; j++)
                mat[i][j] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}