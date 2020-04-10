// Question

//     1. You are given a base b.
//   2. You are given two numbers n1 and n2 of base b.
//   3. You are required to multiply n1 and n2 and print the value.

import java.util.*;

public class _07_anyBaseMultiplication {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getProduct(int b, int n1, int n2) {
        // write your code here
        int p = 0;
        int ans = 0;

        while (n1 != 0) {
            int pr = 0, a = 0;
            int t = n2;
            int car = 0;
            // System.out.println("==> " + n1%10 + " : "+ n2);
            while (t != 0 || car != 0) {
                int ld = (t % 10) * (n1 % 10) + car;
                // System.out.println("-> " + ld + " : "+ car);
                car = ld / b;
                ld = ld % b;
                t /= 10;
                a += ld * Math.pow(10, pr++);
                // System.out.println("-> " + ld + " : "+ car);
            }
            a *= Math.pow(10, p++);
            // System.out.println("& : "+a);
            ans = add(ans, a, b);
            n1 /= 10;
        }

        return ans;
    }

    public static int add(int n1, int n2, int b) {
        int ans = 0, p = 0, c = 0;

        while (n1 != 0 || n2 != 0 || c != 0) {
            int ld = n1 % 10 + n2 % 10 + c;
            c = ld / b;
            ld = ld % b;
            ans += ld * Math.pow(10, p++);
            n1 /= 10;
            n2 /= 10;
        }

        return ans;

    }

}