// Question

//   1. You are given a number n.
// 2. You've to write code to print the pattern given in output format below
// *						*	
// *						*	
// *						*	
// *			*			*	
// *		*		*		*	
// *	*				*	*	
// *						*	

import java.util.*;

public class pattern20 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        // if(n==1){System.out.print(" *"); return;}
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1 || j == n)
                    System.out.print("*	");
                else if (i > n / 2) {
                    if (i == j || i + j == n + 1)
                        System.out.print("*	");
                    else
                        System.out.print("	");
                } else
                    System.out.print("	");
            }

            System.out.println();
        }
    }
}