// Question

//  1. You are given a string str.
// 2. Complete the body of printSS function - without changing signature - to calculate and print all subsequences of str.
// Use sample input and output to take idea about subsequences.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _17_printSubsequences {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        printSS(str, "");
        System.out.println();
    }

    public static void printSS(String str, String ans) {
        if (str.length() == 0) {
            if (ans.length() != 0)
                System.out.println(ans);
            return;
        }

        String ans1 = ans + Character.toString(str.charAt(0));
        // System.out.println(ans+" "+ans1);

        printSS(str.substring(1), ans);
        printSS(str.substring(1), ans1);
    }
}