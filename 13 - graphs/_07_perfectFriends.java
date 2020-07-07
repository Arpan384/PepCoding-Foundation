// Question

// 1. You are given a number n (representing the number of students). Each student will have an id from 0 to n - 1.
// 2. You are given a number k (representing the number of clubs)
// 3. In the next k lines, two numbers are given separated by a space. The numbers are ids of students belonging to same club.
// 4. You have to find in how many ways can we select a pair of students such that both students are from different clubs.

import java.io.*;
import java.util.*;

public class _07_perfectFriends {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] edges = new int[k][2];

        for (int i = 0; i < k; i++) {
            String str = br.readLine();
            for (int j = 0; j < 2; j++) {
                edges[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        // write your code here
        int[] pars = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            pars[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < k; i++) {
            int[] edge = edges[i];
            int p1 = findPar(edge[0], pars);
            int p2 = findPar(edge[1], pars);
            if (p1 != p2) {
                merge(p1, p2, pars, size);
            }
        }
        int tot = 0;
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (findPar(i, pars) == i) {
                x.add(size[i]);
                tot += size[i];
            }
        }

        int pairs = 0;
        // for(int i=0; i<x.size()-1; i++){
        // for(int j=i+1; j<x.size(); j++){
        // pairs+= x.get(i)*x.get(j);
        // }
        // }
        for (int i = 0; i < x.size(); i++) {
            pairs += (x.get(i) * (tot - x.get(i)));
            tot -= x.get(i);
        }

        System.out.println(pairs);
    }

    private static int findPar(int v, int[] pars) {
        return pars[v] = pars[v] == v ? v : findPar(pars[v], pars);
    }

    private static void merge(int u, int v, int[] pars, int[] size) {
        pars[u] = v;
        size[v] += size[u];
    }

}