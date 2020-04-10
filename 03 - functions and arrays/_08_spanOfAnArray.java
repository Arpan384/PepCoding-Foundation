// Question

//    1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are required to find the span of input. Span is defined as difference of maximum value and minimum value.

import java.util.*;

public class _08_spanOfAnArray {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int x = scn.nextInt();
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        System.out.println(max - min);
    }
}