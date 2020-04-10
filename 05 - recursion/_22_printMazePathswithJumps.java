// Question

//   1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
// 4. Complete the body of printMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
// Use sample input and output to take idea about output.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _22_printMazePathsWithJumps {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();

        printMazePaths(0, 0, rows - 1, cols - 1, "");
        System.out.println();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column

    static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
    static String[] path = { "h", "v", "d" };

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        for (int k = 0; k < dirs.length; k++) {

            for (int jump = 1; jump <= Math.max(dr, dc); jump++) {
                int nsr = sr + dirs[k][0] * jump;
                int nsc = sc + dirs[k][1] * jump;
                String np = psf + path[k] + jump;

                if (nsr <= dr && nsc <= dc) {
                    printMazePaths(nsr, nsc, dr, dc, np);
                } else
                    break;
            }
        }
    }
}