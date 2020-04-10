// Question

//   1. You are given a number n.
// 2. You've to create a pattern as shown in output format
// 0	
// 1	1	
// 2	3	5	
// 8	13	21	34	
// 55	89	144	233	377	

import java.util.*;

public class pattern12 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int a = 0, b = 1, c = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(c + "	");
                a = b;
                b = c;
                c = a + b;
            }
            System.out.println();
        }
    }
}