// Question

//   1. You are given a number n.
//   2. You are given a digit d.
//   3. You are required to calculate the frequency of digit d in number n.

import java.util.*;

public class _01_digitFrequesncy {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int d) {
        // write code here
        int fr = 0;
        while (n != 0) {
            if (n % 10 == d)
                fr++;
            n /= 10;
        }

        return fr;
    }
}