// Question

//    1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
// 2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two fences have same colors.


import java.io.*;
import java.util.*;

public class _18_paintFence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();

        int[][] dp = new int[2][n];
        dp[0][0] = 0; // 0-row -> combinations that will paint mine and prev house same
        dp[1][0] = c; // 1-row -> combinations that will not paint mine and prev house same

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = dp[0][i - 1] * (c - 1) + dp[1][i - 1] * (c - 1);
        }

        System.out.println((dp[0][n - 1] + dp[1][n - 1]));
        
        scn.close();
    }
}