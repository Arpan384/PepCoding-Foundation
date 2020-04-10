// Question

//   1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to print a bar chart representing value of arr a.

// 5
// 3 1 0 7 5
//             *   
//             *   
//             *   *
//             *   *
// *           *   *
// *           *   *
// *   *       *   *

import java.util.*;

public class _10_barChart {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
        }

        for (int i = max; i > 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print((i - arr[j] <= 0 ? "*	" : "	"));
            }
            System.out.println();
        }
    }
}