// Question

//  1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are required to find the maximum of input. 
// 4. For the purpose complete the body of maxOfArray function. Don't change the signature.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _11_maxOfAnArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        int max = maxOfArray(arr, 0);
        System.out.println(max);

    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1)
            return arr[idx];
        return Math.max(arr[idx], maxOfArray(arr, idx + 1));
    }
}