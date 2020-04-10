// Question

//  1. You've to display the digits of a number in reverse.
//    2. Take as input "n", the number for which digits have to be displaye in reverse.
//    3. Print the digits of the number line-wise, but in reverse order.

import java.util.*;

public class _08_reverseANumber {
    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n != 0) {
            System.out.println(n % 10);
            n /= 10;
        }
    }
}