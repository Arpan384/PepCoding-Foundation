// Question

//   1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
// i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)

import java.io.*;
import java.util.*;

public class _26_buySellStocks_cooldown_Infinite {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int prices[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = s.nextInt();
        }

        int ans = cooldown(prices);
        System.out.println(ans);
    }

    public static int cooldown(int prices[]) {
        int n = prices.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return 0;

        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < i; j++) {
                if (j - 2 >= 0)
                    dp[i] = Math.max(dp[i], prices[i] - prices[j] + dp[j - 2]);
                else
                    dp[i] = Math.max(dp[i], prices[i] - prices[j]);

            }
        }

        return dp[n - 1];
    }
}