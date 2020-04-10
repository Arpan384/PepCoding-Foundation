// Question

//   1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.

// Asssumption - Array is sorted. Array may have duplicate values.

import java.util.*;

public class _19_FirstIndexAndLastIndex {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();

        int d = s.nextInt();
        int f = -1, l = -1;

        int i = 0, j = n - 1;
        while (i <= j) {
            if (arr[i] == d) {
                f = i;
            } else {
                i++;
            }
            if (arr[j] == d) {
                l = j;
            } else {
                j--;
            }
            if (f != -1 && l != -1)
                break;
        }

        System.out.println(f + "\n" + l);
    }
}