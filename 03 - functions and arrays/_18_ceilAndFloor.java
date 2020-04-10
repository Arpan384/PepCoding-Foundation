// Question

//  1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are given another number d.
// 4. You are required find the ceil and floor of d in the array a.

// Ceil is defined as value in array which is just greater than d. If an element equal to d exists that will be considered as ceil.

// Floor is defined as value in array which is just lesser than d. If an element equal to d exists that will be considered as floor.

// Asssumption - Array is sorted

import java.util.*;

public class _18_ceilAndFloor {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int d = scn.nextInt();

        int ceil = Integer.MAX_VALUE, floor = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > d && arr[i] < ceil)
                ceil = arr[i];
            else if (arr[i] < d && arr[i] > floor)
                floor = arr[i];
        }

        System.out.println(ceil + "\n" + floor);
    }
}