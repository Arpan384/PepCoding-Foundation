// Question

//    1. You are given a number n, representing the number of rows of a matrix.
// 2. You are given a number m, representing the number of columns of a matrix.
// 3. You are given n * m numbers, representing elements of 2d array a.

// shell-rotate

// 4. You are given a shell number s. For details check image.
// 5. You are given a number r, representing number of anti-clockwise rotations (for +ve numbers) of the shell s.
// 6. You are required to rotate the sth shell of matrix by r rotations and display the matrix using display function.

import java.util.*;

public class _07_shellRotate {
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

        int shell = scn.nextInt();
        int rot = scn.nextInt();

        if ((r - shell) - (shell - 1) < 0 || (c - shell) - (shell - 1) < 0)
            return;

        int num = 2 * ((r - shell) - (shell - 1) + (c - shell) - (shell - 1));
        if (r - shell == shell - 1) {
            num = (c - shell) - (shell - 1) + 1;
        } else if (c - shell == shell - 1) {
            num = (r - shell) - (shell - 1) + 1;
        }

        if (num == 1) {
            display(mat);
            return;
        }

        int[] arr = new int[num];
        int idx = 0;

        for (int i = shell - 1, j = shell - 1; j < c - shell && idx < num; j++) {
            arr[idx++] = mat[i][j];
        }

        for (int i = shell - 1, j = c - shell; i < r - shell && idx < num; i++) {
            arr[idx++] = mat[i][j];
        }

        for (int i = r - shell, j = c - shell; j > shell - 1 && idx < num; j--) {
            arr[idx++] = mat[i][j];
        }

        for (int i = r - shell, j = shell - 1; i > shell - 1 && idx < num; i--) {
            arr[idx++] = mat[i][j];
        }

        // display(mat);
        // for(int i=0; i<num; i++)System.out.print(arr[i]+" ");

        rotateArray(arr, rot);
        // System.out.println();

        idx = 0;
        for (int i = shell - 1, j = shell - 1; j < c - shell && idx < num; j++) {
            mat[i][j] = arr[idx++];
        }

        for (int i = shell - 1, j = c - shell; i < r - shell && idx < num; i++) {
            mat[i][j] = arr[idx++];
        }

        for (int i = r - shell, j = c - shell; j > shell - 1 && idx < num; j--) {
            mat[i][j] = arr[idx++];
        }

        for (int i = r - shell, j = shell - 1; i > shell - 1 && idx < num; i--) {
            mat[i][j] = arr[idx++];
        }

        display(mat);

    }

    public static void rotateArray(int[] arr, int k) {
        k *= (-1);
        k %= arr.length;
        if (k < 0)
            k = arr.length + k;

        // System.out.println(k);

        // for(int i=0; i<arr.length; i++)System.out.print(arr[i]+" ");
        // System.out.println();
        reverse(arr, 0, arr.length - k - 1);
        // for(int i=0; i<arr.length; i++)System.out.print(arr[i]+" ");
        // System.out.println();
        reverse(arr, arr.length - k, arr.length - 1);
        // for(int i=0; i<arr.length; i++)System.out.print(arr[i]+" ");
        // System.out.println();
        reverse(arr, 0, arr.length - 1);
        // for(int i=0; i<arr.length; i++)System.out.print(arr[i]+" ");
        // System.out.println();
    }

    public static void reverse(int[] arr, int st, int en) {
        while (st < en) {
            int temp = arr[st];
            arr[st] = arr[en];
            arr[en] = temp;
            st++;
            en--;
        }
    }

    public static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}