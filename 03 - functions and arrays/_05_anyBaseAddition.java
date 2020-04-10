// Question

//   1. You are given a base b.
//   2. You are given two numbers n1 and n2 of base b.
//   3. You are required to add the two numbes and print their value in base b.

import java.util.*;

public class _05_anyBaseAddition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2) {
        // write ur code here
        String ans = "";
        int c = 0;

        while (n1 != 0 || n2 != 0 || c != 0) {
            int ld = c + n1 % 10 + n2 % 10;
            ans = (ld % b) + ans;
            c = ld / b;
            n1 /= 10;
            n2 /= 10;
        }

        return Integer.parseInt(ans);
    }
}