// Question

//  1. You've to count the number of digits in a number.
//   2. Take as input "n", the number for which the digits has to be counted.
//   3. Print the digits in that number.

import java.util.*;

public class _06_countDigitsInANumber {

    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = 0;
        while (n != 0) {
            c++;
            n /= 10;
        }
        System.out.println(c);
    }
}