// Question

//   1. You are given a number n.
//        2. You've to create a pattern of * and separated by tab as shown in output format
//                 *	
//             *	
//         *	
//     *	
// *	


import java.util.*;

public class pattern8 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i + j == n + 1) {
                    System.out.println("*	");
                    break;
                } else
                    System.out.print("	");
            }
        }
    }
}