// Question

// 1. Implement the functions of class StockSpanner.
//   2. next() collects daily price quotes for the stock, and returns the span of that stock's price for the current day.
//   3. The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

//   Example
//   If the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], 
//   then the stock spans would be [1, 1, 1, 2, 1, 4, 6].

import java.util.*;

public class _04_stockSpan {
    static class StockSpanner {
        // Complete the functions
        Stack<int[]> st;

        // int count = 0;
        public StockSpanner() {
            st = new Stack<>();
            // count = 1;
        }

        public int next(int price) {
            if (st.empty()) {
                st.push(new int[] { price, 1 });
                return 1;
            }

            int count = 1;
            while (!st.isEmpty() && st.peek()[0] < price) {
                count += st.peek()[1];
                st.pop();
            }

            st.push(new int[] { price, count });

            return count;

        }

    }

    // Dont make chamnges here
    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(ss.next(sc.nextInt()));
        }
    }

}