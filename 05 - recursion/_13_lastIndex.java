// Question

//  1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number x. 
// 4. You are required to find the last index at which x occurs in array a.
// 5. If x exists in array, print the last index where it is found otherwise print -1.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _13_lastIndex {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        int x = s.nextInt();
        System.out.println(lastIndex(arr, 0, x));

    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if (idx == arr.length)
            return -1;
        int index = lastIndex(arr, idx + 1, x);
        if (index == -1)
            index = arr[idx] == x ? idx : -1;
        return index;
    }
}