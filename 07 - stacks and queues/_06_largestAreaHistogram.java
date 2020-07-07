// Question

//   1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the height of bars in a bar chart.
// 3. You are required to find and print the area of largest rectangle in the histogram.

// e.g.
// for the array [6 2 5 4 5 1 6] -> 12

import java.io.*;
import java.util.*;

public class _06_largestAreaHistogram {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // code

        int[] rt = nsor(a);
        int[] lt = nsol(a);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int w = rt[i] - lt[i] - 1;
            int area = a[i] * w;
            max = Math.max(max, area);
        }

        System.out.println(max);
    }

    public static int[] nsor(int[] arr) {
        int[] sm = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                sm[st.pop()] = i;
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            sm[st.pop()] = arr.length;
        }

        return sm;
    }

    public static int[] nsol(int[] arr) {
        int[] sm = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                sm[st.pop()] = i;
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            sm[st.pop()] = -1;
        }

        return sm;
    }
}