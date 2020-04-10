// Question

//  1. You are given two numbers n and k. You are required to rotate n, k times to the right. If k is positive, rotate to the right i.e. remove rightmost
//    digit and make it leftmost. Do the reverse for negative value of k. Also k can have an absolute value larger than number of digits in n.
//    2. Take as input n and k.
//    3. Print the rotated number.
//    4. Note - Assume that the number of rotations will not cause leading 0's in the result. e.g. such an input will not be given
//    n = 12340056
//    k = 3
//    r = 05612340

// Input Format

// "n" where n is any integer.
//    "K" where k is any integer.

// Output Format

// "r", the rotated number

// Constraints

// 1 <= n < 10^9
//    -10^9 < k < 10^9

import java.util.*;

public class _10_rotateANumber {
    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);

        // int n = s.nextInt();
        // String str = Integer.toString(n);
        String str = s.nextLine();
        int rot = s.nextInt();

        // int x = n;

        // int c=0;
        // while(n!=0){
        // c++;
        // n/=10;
        // }

        // n=x;

        int c = str.length();

        if (Math.abs(rot) >= c)
            rot = rot % c;

        int temp = 0, t = rot;

        if (rot < 0)
            rot = c + rot;

        // System.out.println(rot);
        // while(t>0){
        // temp = temp*10 + n%10;
        // str = n%10 + str;
        // // System.out.println(temp);
        // n/=10;
        // t--;
        // }

        // System.out.println(n);

        // System.out.println(((int)Math.pow(10, (c-rot))*temp + n));
        // rot = rot==0? 1: rot;
        System.out.println(str.substring(str.length() - rot) + str.substring(0, str.length() - rot));

    }
}