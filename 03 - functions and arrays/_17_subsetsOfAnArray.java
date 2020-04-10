// Question

//  1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are required to print all subsets of arr. Each subset should be
// on separate line. For more clarity check out sample input and output

import java.util.*;

public class _17_subsetsOfAnArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int arr[] = new int[n];
        
        for(int i=0; i<n; i++)arr[i] = scn.nextInt();
        printSubsets(arr);
        
     }

    public static void printSubsets(int[] arr) {
        int tot = (int) Math.pow(2, arr.length);
        int i = 0;

        while (i < tot) {
            for (int j = 0; j < arr.length; j++) {
                int mask = 1 << (arr.length - j - 1);
                // System.out.print("-> "+mask+" ");
                if ((i & mask) != 0)
                    System.out.print(arr[j] + "	");
                else
                    System.out.print("-	");
            }
            System.out.println();
            i++;
        }
    }
}