// Question

//     1. You've to print all prime numbers between a range. 
//  2. Take as input "low", the lower limit of range
//  3. Take as input "high", the higher limit of range
//  4. For the range print all the primes numbers between low and high (both included)

import java.util.*;

public class _04_printAllPrimesTillN {
    static boolean checkPrime(int num) {
        for (int i = (int) (Math.sqrt(num)); i >= 2; i--) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here

        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int h = s.nextInt();

        for (int i = l; i <= h; i++) {
            if (checkPrime(i)) {
                System.out.println(i);
            }
        }
    }
}