// Question

//   1. You are required to display the prime factorization of a number.
//     2. Take as input a number n.
//     3. Print all its prime factors from smallest to largest.

import java.util.*;

public class _12_primeFactorizationOfANumber {
    public static void main(String[] args) {
        // write your code here

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int factor = 2;
        if (n == 1 || n == -1 || n == 0) {
            System.out.print(n);
            return;
        }

        while (n != 1) {
            if (n % factor == 0) {
                System.out.print(factor + " ");
                n /= factor;
            } else
                factor++;
        }
    }
}