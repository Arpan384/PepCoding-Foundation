// Question

//  1. You've to print first n fibonacci numbers.
//   2. Take as input "n", the count of fibonacci numbers to print.
//   3. Print first n fibonacci numbers.

import java.util.*;

public class _05_printFibonacciNumbersTillN {
    public static void main(String[] args) {
        // write your code here

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int a = 0, b = 0, c = 1;

        System.out.println(a);
        // a++;

        for (int i = 1; i < n; i++) {
            System.out.println(c);
            a = b;
            b = c;
            c = a + b;

        }

    }
}