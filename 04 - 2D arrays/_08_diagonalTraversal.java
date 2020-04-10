// Question

//     1. You are given a number n, representing the number of rows and columns of a square matrix.
// 2. You are given n * n numbers, representing elements of 2d array a.
// 3. You are required to diagonally traverse the upper half of the matrix and print the contents.
// For details check image.

import java.util.*;

public class _08_diagonalTraversal {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = r;

        int[][] mat = new int[r][c];
        int[] rowMin = new int[r];

        for (int i = 0; i < r; i++) {
            int minColIdx = 0;
            for (int j = 0; j < c; j++) {
                mat[i][j] = scn.nextInt();
                if (mat[i][minColIdx] > mat[i][j])
                    minColIdx = j;
            }
            rowMin[i] = minColIdx;
        }

        for (int i = 0; i < c; i++) {
            for (int offset = 0; offset < c - i; offset++) {
                System.out.println(mat[offset][offset + i]);
            }
        }

    }
}