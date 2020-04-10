// Question

//   1. You are given a number n.
//        2. You've to create a pattern of * and separated by tab as shown in output format
// *				*
// 	   *		*
// 		   *
// 	   *		*
// *				*	

import java.util.*;

public class pattern9 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here

        int sp = 1;
        int n = scn.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < sp; j++)
                System.out.print("	");
            System.out.print("*");
            for (int j = 0; j <= n - (2 * (sp)); j++)
                System.out.print("	");
            // sp++;
            if (i < (n / 2 + 1)) {
                System.out.println("*");
                sp++;
            } else if (i == (n / 2 + 1)) {
                sp -= 1;
                System.out.println();
            } else {
                sp--;
                System.out.println("*");
            }
        }

    }
}