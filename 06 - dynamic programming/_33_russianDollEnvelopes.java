// Question

// 1. You are given a number n, representing the number of envelopes.
// 2. You are given n pair of numbers, representing the width and height of each envelope.
// 3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
// Note -> Rotation is not allowed


import java.io.*;
import java.util.*;


public class _33_russianDollEnvelopes {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(new InputStreamReader(System.in));
        int n = scn.nextInt();

        int[][] envelopes = new int[n][n];

        for (int i = 0; i < n; i++) {
            envelopes[i][0] = scn.nextInt();
            envelopes[i][1] = scn.nextInt();
        }

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });

        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i]++;
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}