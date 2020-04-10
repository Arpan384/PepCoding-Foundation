// Question

//   1. You are given a number n.
// 2. You've to create a pattern as shown in output format
// 1	
// 1	1	
// 1	2	1	
// 1	3	3	1	
// 1    4	6	4	1	

import java.util.*;

public class pattern13 {

    public static int fact(int n) {
        if (n == 0)
            return 1;
        int s = 1;
        while (n != 0) {
            s *= n;
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((fact(i) / (fact(j) * fact(i - j))) + "	");
            }
            System.out.println();
        }
    }
}