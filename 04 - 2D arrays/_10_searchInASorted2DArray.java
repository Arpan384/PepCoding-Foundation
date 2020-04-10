// Question

//  1. You are given a number n, representing the number of rows and columns of a square matrix.
// 2. You are given n * n numbers, representing elements of 2d array a. 
// Note - Each row and column is sorted in increasing order.
// 3. You are given a number x.
// 4. You are required to find x in the matrix and print it's location int (row, col) format as discussed in output format below.
// 5. In case element is not found, print "Not Found".

import java.util.*;

public class _10_searchInASorted2DArray {

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

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

        int elem = scn.nextInt();

        int i = 0, j = mat[0].length - 1;

        while (true) {
            if (i == mat.length || j == -1)
                break;
            if (mat[i][j] == elem) {
                System.out.print(i + "\n" + j);
                return;
            } else if (mat[i][j] > elem) {
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Not Found");
    }
}