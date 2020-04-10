// Question

//   1. You are given a number n.
// 2. You've to create a pattern of * and separated by tab as shown in output format
//          *			
//      *		*		
//  *				*	
//      *		*		
//          *		

import java.util.*;

public class pattern10 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j - n / 2) == i || (j - n / 2) + i == 0 || (i - n / 2) == j || (i - n / 2 + j - n / 2) == n / 2)
                    System.out.print("*	");
                else
                    System.out.print("	");
            }
            System.out.println();
        }
    }
}