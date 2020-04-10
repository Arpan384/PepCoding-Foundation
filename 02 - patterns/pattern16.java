// Question

//   1. You are given a number n.
// 2. You've to write code to print the pattern given in output format below
// 1								1	
// 1	2						2	1	
// 1	2	3				3	2	1	
// 1	2	3	4		4	3	2	1	
// 1	2	3	4	5	4	3	2	1	


import java.util.*;

public class pattern16 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int sp = (n - 1) * 2 - 1;

        for (int i = 1; i <= n; i++) {
            int val = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print((val++) + "\t");
            }
            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            sp -= 2;
            val = i == n ? val - 2 : val - 1;
            int iter = i == n ? i - 1 : i;
            for (int j = 1; j <= iter; j++) {
                System.out.print((val--) + "\t");
            }
            System.out.println();
        }

    }
}