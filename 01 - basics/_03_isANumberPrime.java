// Question

//  1. You've to check whether a given number is prime or not.
//   2. Take a number "t" as input representing count of input numbers to be tested.
//   2. Take a number "n" as input "t" number of times.
//   3. For each input value of n, print "prime" if the number is prime and "not prime" otherwise.

import java.util.*;

public class _03_isANumberPrime {
    static boolean checkPrime(int num) {
        if (num == 2)
            return true;
        for (int i = (int) (Math.sqrt(num)); i >= 2; i--) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // write ur code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int num = s.nextInt();
            if (checkPrime(num)) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }

    }
}