// Question

//   1. You are given a number n1, representing the number of rows of 1st matrix.
// 2. You are given a number m1, representing the number of columns of 1st matrix.
// 3. You are given n1*m1 numbers, representing elements of 2d array a1.
// 4. You are given a number n2, representing the number of rows of 2nd matrix.
// 5. You are given a number m2, representing the number of columns of 2nd matrix.
// 6. You are given n2*m2 numbers, representing elements of 2d array a2.
// 7. If the two arrays representing two matrices of dimensions n1 * m1 and n2 * m2 can be multiplied, display the contents of prd array as specified in output Format
// 8. If the two arrays can't be multiplied, print "Invalid input"

import java.util.*;

public class _02_matrixMultiplication {

    public static void takeInput(int[][] mat, Scanner scn) {
        int r = mat.length;
        int c = mat[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                mat[i][j] = scn.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int r1 = scn.nextInt();
        int c1 = scn.nextInt();
        int[][] mat1 = new int[r1][c1];
        takeInput(mat1, scn);

        int r2 = scn.nextInt();
        int c2 = scn.nextInt();

        if (c1 != r2) {
            System.out.println("Invalid input");
            return;
        }

        int[][] mat2 = new int[r2][c2];
        takeInput(mat2, scn);

        int[][] res = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }
}