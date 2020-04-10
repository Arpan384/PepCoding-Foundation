// Question

//  1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are required to print all subarrays of arr. Each subarray should be
// on separate line. For more clasrity check out sample input and output

import java.util.*;

public class _16_printAllSubArrays {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int len = 0; i + len < n; len++) {
                for (int j = 0; j <= len; j++) {
                    System.out.print(arr[j + i] + "	");
                }
                System.out.println();
            }
        }
    }

}