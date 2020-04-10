// Question

//   1. You are given a number n.
// 2. You've to write code to print the pattern given in output format below
// *	*	*	*			*
// 			    *			*
// 			    *			*
// *    *	*	*	*	*	*
// *			*			
// *			*			
// *			*	*	*	*

import java.util.*;

public class pattern19 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        for (int i = 0; i <= n / 2; i++)
            System.out.print("*	");
        for (int i = 1; i < (n / 2); i++)
            System.out.print("	");
        System.out.println("*");

        for (int i = 1; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++)
                System.out.print("	");
            System.out.print("*");
            for (int j = 0; j < n / 2; j++)
                System.out.print("	");
            System.out.println("*");
            // System.out.println();
        }

        for (int i = 0; i < n; i++)
            System.out.print("*	");
        System.out.println();

        for (int i = 1; i < n / 2; i++) {
            System.out.print("*");
            for (int j = 0; j < n / 2; j++)
                System.out.print("	");
            System.out.print("*");
            for (int j = 0; j < n / 2; j++)
                System.out.print("	");
            System.out.println();
        }

        System.out.print("*");
        for (int i = 1; i <= (n / 2); i++)
            System.out.print("	");
        for (int i = 0; i <= n / 2; i++)
            System.out.print("*	");
    }
}