// Question

//     1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to "next greater element on the right" for all elements of array
// 4. Input and output is handled for you.

// "Next greater element on the right" of an element x is defined as the first element to right of x having value greater than x.
// Note -> If an element does not have any element on it's right side greater than it, consider -1 as it's "next greater element on right"
// e.g.
// for the array [2 5 9 3 1 12 6 8 7]
// Next greater for 2 is 5
// Next greater for 5 is 9
// Next greater for 9 is 12
// Next greater for 3 is 12
// Next greater for 1 is 12
// Next greater for 12 is -1
// Next greater for 6 is 8
// Next greater for 8 is -1
// Next greater for 7 is -1

import java.util.*;
import java.io.*;

public class _03_nextGreaterElementToTheRight {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new InputStreamReader(System.in));

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] ans = solve(arr);
        display(ans);
    }

    public static int[] solve(int[] arr) {

        Stack<Integer> st = new Stack();
        int[] ngor = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
                continue;
            }

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ngor[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ngor[st.peek()] = -1;
            st.pop();
        }

        return ngor;
    }
}