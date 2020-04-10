// Question

//    1. You are given a number n, the size of a chess board.
// 2. You are given a row and a column, as a starting point for a knight piece.
// 3. You are required to generate the all moves of a knight starting in (row, col) such that knight visits all cells of the board exactly once.
// 3. Complete the body of printKnightsTour function - without changing signature - to calculate and print all configurations of the chess board representing the route
// of knight through the chess board. Use sample input and output to get more idea.

// Note -> When moving from (r, c) to the possible 8 options give first precedence to (r - 2, c + 1) and move in clockwise manner to
// explore other options.
// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _28_NQueens {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int r = s.nextInt();
        int c = s.nextInt();
        int[][] board = new int[n][n];
        printKnightsTour(r, c, 1, board);
        System.out.println();
    }

    static int[][] dirs = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

    static boolean isSafe(int r, int c, int[][] board) {
        if (r <= -1 || c <= -1 || r >= board.length || c >= board[0].length || board[r][c] != 0)
            return false;
        return true;
    }

    public static void printKnightsTour(int r, int c, int idx, int[][] chess) {

        chess[r][c] = idx;

        if (idx == chess.length * chess[0].length) {
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }
        idx++;

        for (int i = 0; i < dirs.length; i++) {
            int nsr = r + dirs[i][0];
            int nsc = c + dirs[i][1];

            if (isSafe(nsr, nsc, chess)) {
                printKnightsTour(nsr, nsc, idx, chess);
            }
        }

        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}