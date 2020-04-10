// Question

//  1. You are given a number n, representing the number of rows and columns of a square matrix.
// 2. You are given n * n numbers, representing elements of 2d array a.
// 3. You are required to find the saddle point of the matrix which is defined as the value which is smallest in it's row but largest in it's column.
// Note - There can be only 1 saddle point or none. Think why?

import java.util.*;

public class _09_saddlePoint {
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

        int[] colMax = new int[c];
        for (int i = 0; i < c; i++)
            colMax[i] = -1;

        for (int i = 0; i < r; i++) {
            int minColIdx = rowMin[i];
            int maxRowIdx = 0;
            if (colMax[minColIdx] != -1) {
                maxRowIdx = colMax[minColIdx];
            } else {
                for (int j = 1; j < r; j++) {
                    if (mat[maxRowIdx][minColIdx] < mat[j][minColIdx])
                        maxRowIdx = j;
                }
                colMax[minColIdx] = maxRowIdx;
            }

            if (maxRowIdx == i) {
                System.out.println(mat[maxRowIdx][minColIdx]);
                return;
            }
        }

        System.out.println("Invalid input");

    }
}