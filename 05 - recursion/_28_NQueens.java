// Question

//  1. You are given a number n, the size of a chess board.
// 2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
// Note - Queens kill at distance in all 8 directions
// 3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens
// Use sample input and output to get more idea.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _28_NQueens {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = printNQueens(n, "", 0);
        System.out.println();
    }

    static int row_bit = 0;
    static int col_bit = 0;
    static int diag_bit = 0;
    static int anti_bit = 0;

    static boolean isSafe(int row, int i, int n) {
        if (((1 << row) & row_bit) != 0 || ((1 << i) & col_bit) != 0 || ((1 << (i + row)) & diag_bit) != 0
                || ((1 << (i - row + n - 1)) & anti_bit) != 0)
            return false;
        return true;
    }

    public static int printNQueens(int n, String qsf, int row) {
        if (row == n) {
            System.out.println(qsf + ".");
            return 1;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (isSafe(row, i, n)) {
                row_bit |= (1 << row);
                col_bit |= (1 << i);
                diag_bit |= (1 << (i + row));
                anti_bit |= (1 << (i - row + n - 1));

                count += printNQueens(n, qsf + row + "-" + i + ", ", row + 1);

                row_bit ^= (1 << row);
                col_bit ^= (1 << i);
                diag_bit ^= (1 << (i + row));
                anti_bit ^= (1 << (i - row + n - 1));
            }
        }

        return count;
    }
}