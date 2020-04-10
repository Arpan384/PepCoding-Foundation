// Question

//  1. You are given a number n representing number of stairs in a staircase.
// 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
// 3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
// Use sample input and output to take idea about output.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _25_getStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        // if(n<0)return new ArrayList<String>();
        if (n == 0) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            if (n - i >= 0) {
                ArrayList<String> recAns = getStairPaths(n - i);
                for (String s : recAns) {
                    ans.add(i + s);
                }
            }
        }

        return ans;
    }
}
