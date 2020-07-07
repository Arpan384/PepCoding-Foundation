// Question

// 1. You are given a 2d array where 0's represent land and 1's represent water. Assume every cell is linked to it's north, east, west and south cell.
// 2. You are required to find and count the number of islands.

import java.io.*;
import java.util.*;

public class _06_numberOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        // write your code here
        System.out.println(islands(arr));
        // System.out.println(dsu(arr));
    }

    private static void dfs(int sr, int sc, int[][] arr, boolean[][] vis) {
        vis[sr][sc] = true;
        if (sr + 1 < arr.length && !vis[sr + 1][sc] && arr[sr + 1][sc] == 0) {
            dfs(sr + 1, sc, arr, vis);
        }
        if (sr - 1 > -1 && !vis[sr - 1][sc] && arr[sr - 1][sc] == 0) {
            dfs(sr - 1, sc, arr, vis);
        }
        if (sc + 1 < arr[0].length && !vis[sr][sc + 1] && arr[sr][sc + 1] == 0) {
            dfs(sr, sc + 1, arr, vis);
        }
        if (sc - 1 > -1 && !vis[sr][sc - 1] && arr[sr][sc - 1] == 0) {
            dfs(sr, sc - 1, arr, vis);
        }
    }

    private static int islands(int[][] arr) {
        boolean[][] vis = new boolean[arr.length][arr[0].length];

        int comps = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && !vis[i][j]) {
                    comps++;
                    dfs(i, j, arr, vis);
                }
            }
        }

        return comps;
    }

    private static int findPar(int v, int[] pars) {
        return pars[v] = pars[v] == v ? v : findPar(pars[v], pars);
    }

    private static void merge(int u, int v, int[] pars) {
        pars[u] = v;
    }

    private static int dsu(int[][] arr) {
        int[] pars = new int[arr.length * arr[0].length];

        int comps = arr.length * arr[0].length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                pars[i * arr[0].length + j] = i * arr[0].length + j;
                if (arr[i][j] == 1)
                    comps--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    if (i - 1 > -1 && arr[i - 1][j] == 0) {
                        int p1 = findPar((i - 1) * arr[0].length + j, pars);
                        int p2 = findPar((i) * arr[0].length + j, pars);
                        if (p1 != p2) {
                            merge(p1, p2, pars);
                            comps--;
                        }
                    }
                    if (j - 1 > -1 && arr[i][j - 1] == 0) {
                        int p1 = findPar((i) * arr[0].length + j - 1, pars);
                        int p2 = findPar((i) * arr[0].length + j, pars);
                        if (p1 != p2) {
                            merge(p1, p2, pars);
                            comps--;
                        }
                    }
                }
            }
        }

        return comps;
    }

}