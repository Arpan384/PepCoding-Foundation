// Question

//  1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are given a number k.
// 4. Rotate the array a, k times to the right (for positive values of k), and to
// the left for negative values of k.

import java.util.*;

public class _15_inverseOfAnArray {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        // for(int val: a){
        // sb.append(val + " ");
        // }
        // System.out.println(sb);
        for (int x : a) {
            System.out.println(x);
        }
    }

    public static int[] inverse(int[] a) {
        // write your code here
        int[] ans = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            ans[a[i]] = i;
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] inv = inverse(a);
        display(inv);
    }
}