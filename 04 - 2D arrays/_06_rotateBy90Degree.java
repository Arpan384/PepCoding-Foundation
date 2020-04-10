// Question

//  1. You are given a number n, representing the number of rows and number of columns.
// 2. You are given n*n numbers, representing elements of 2d array a.
// 3. You are required to rotate the matrix by 90 degree clockwise and then display the contents using display function.
// *Note - you are required to do it in-place i.e. no extra space should be used to achieve it*

import java.util.*;

public class _06_rotateBy90Degree {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = r;

        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        // display(mat);
        // System.out.println();
        rotateby90_2(mat);
        display(mat);
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateby90(int mat[][]) {
        int n = mat.length;
        int x = 1;

        for (int i = 0; i < n / 2; i++) {
            for (int count = 0; count < n - i - x; count++) {
                int r = i;
                int c = r + count;

                // System.out.print(r+" "+c+" ");
                // System.out.print((n-c-1)+" "+r+" ");
                // System.out.print((n-r-1)+" "+(n-c-1)+" ");
                // System.out.println(c+" "+(n-r-1)+" ");

                int temp = mat[r][c];
                mat[r][c] = mat[n - c - 1][r];
                mat[n - c - 1][r] = mat[n - r - 1][n - c - 1];
                mat[n - r - 1][n - c - 1] = mat[c][n - r - 1];
                mat[c][n - r - 1] = temp;
            }
            x++;
            // System.out.println();
        }
    }

    public static void rotateby90_2(int mat[][]) {
        // Transpose

        transpose(mat);

        // Reverse
        for (int i = 0; i < mat.length; i++) {
            reverse(mat[i]);
        }
    }

    public static void transpose(int mat[][]) {
        for (int i = 0; i < mat.length - 1; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void reverse(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

}