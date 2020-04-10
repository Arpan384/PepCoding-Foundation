// Question

//  1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a. The numbers can be 1 or 0 only.
// 4. You are standing in the top-left corner and have to reach the bottom-right corner. 
// Only four moves are allowed 't' (1-step up), 'l' (1-step left), 'd' (1-step down) 'r' (1-step right). 
// You can only move to cells which have 0 value in them. You can't move out of the boundaries or in the cells which have value 1 in them (1 means obstacle)
// 5. Complete the body of floodfill function - without changing signature - to print all paths that can be used to move from top-left to bottom-right.

// Note1 -> Please check the sample input and output for details
// Note2 -> If all four moves are available make moves in the order 't', 'l', 'd' and 'r'

import java.util.*;

public class _20_floodFill {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] board = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                board[i][j] = scn.nextInt();
        }

        floodfill(board, 0, 0, "");
        // System.out.println(vis[0][0]);
    }

    static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    static String[] path = { "t", "l", "d", "r" };

    public static boolean isSafe(int r, int c, int[][] maze) {
        if (r >= maze.length || r <= -1 || c >= maze[0].length || c <= -1 || maze[r][c] == 1)
            return false;
        return true;
    }

    public static void floodfill(int[][] maze, int row, int col, String psf) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }

        maze[row][col] = 1;

        for (int k = 0; k < dirs.length; k++) {
            int nsr = row + dirs[k][0];
            int nsc = col + dirs[k][1];

            if (isSafe(nsr, nsc, maze)) {
                floodfill(maze, nsr, nsc, psf + path[k]);
            }
        }

        maze[row][col] = 0;
    }
}