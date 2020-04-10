// Question

//  1. You are given a string str.
// 2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
// Use sample input and output to take idea about subsequences.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _23_getSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> res = gss(str);
        System.out.println(res);
        // for(String s:res){
        // System.out.println(s);
        // }
    }

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        ArrayList<String> recAns = gss(str.substring(1));

        int s = recAns.size();
        for (int i = 0; i < s; i++) {
            recAns.add(str.charAt(0) + recAns.get(i));
        }

        return recAns;
    }
}
