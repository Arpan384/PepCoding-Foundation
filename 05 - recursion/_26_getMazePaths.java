// Question

//  1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
// 3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _26_getMazePaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();

        System.out.println(getMazePaths(0, 0, rows - 1, cols - 1));
    }

    static int[][] dirs = { { 0, 1 }, { 1, 0 } };
    static String[] path = { "h", "v" };

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> res = new ArrayList<>();

        for (int k = 0; k < dirs.length; k++) {
            int nsr = sr + dirs[k][0];
            int nsc = sc + dirs[k][1];
            String np = path[k];

            if (nsr <= dr && nsc <= dc) {
                ArrayList<String> recAns = getMazePaths(nsr, nsc, dr, dc);
                for (String s : recAns) {
                    // System.out.println(sr+" : "+sc+" : "+s);
                    res.add(np + s);
                }
            }
        }

        return res;
    }
}
