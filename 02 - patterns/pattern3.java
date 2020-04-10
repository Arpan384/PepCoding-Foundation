// Question

//   1. You are given a number n.
//        2. You've to create a pattern of * and separated by tab as shown in output format
//                 *
//             *   *
//         *   *   *   
//     *   *   *   * 
// *   *   *   *   * 

import java.util.*;

public class pattern3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= n - i; j++)
                System.out.print("	");
            for (int j = 1; j <= i; j++)
                System.out.print("*	");
            System.out.println();
        }
    }
}