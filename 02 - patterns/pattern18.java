// Question

//   1. You are given a number n.
// 2. You've to write code to print the pattern given in output format below
// *	*	*	*	*	*	*	
// 	    *				*		
// 		    *		*			
// 			    *				
// 		    *	*	*			
// 	    *	*	*	*	*		
// *	*	*	*	*	*	*	

import java.util.*;

public class pattern18 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here

        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < n / 2 && (i == 0 || i == j || i + j == n - 1)) {
                    System.out.print("*	");
                } else if (i == n / 2 && j == n / 2) {
                    System.out.print("*	");
                } else if (i > n / 2 && (i == n - 1 || (j >= n - i - 1 && j <= i))) {
                    System.out.print("*	");
                } else {
                    System.out.print("	");
                }
            }
            System.out.println();
        }

    }
}