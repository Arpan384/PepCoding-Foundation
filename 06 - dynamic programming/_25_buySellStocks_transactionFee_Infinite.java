// Question

//     1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are give a number fee, representing the transaction fee for every transaction.
// 4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)

import java.io.*;
import java.util.*;

public class _25_buySellStocks_transactionFee_Infinite {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int fee = s.nextInt();
        int ans = BuyAndSellInfinite(arr, fee);
        System.out.println(ans);
    }

    public static int BuyAndSellInfinite(int prices[], int fee) {
        int bp = prices[0], sp = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > bp) {
                if (prices[i] > sp)
                    sp = prices[i];
                else if (sp - prices[i] >= fee) {
                    profit += (sp - bp - fee);
                    sp = prices[i];
                    bp = prices[i];
                }
            } else {
                if ((sp - bp - fee) > 0)
                    profit += (sp - bp - fee);
                sp = prices[i];
                bp = prices[i];
            }
        }
        if ((sp - bp - fee) > 0)
            profit += (sp - bp - fee);
        return profit;
    }
}