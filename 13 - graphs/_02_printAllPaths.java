// Question

//  1. You are given a graph, a src vertex and a destination vertex.
// 2. You are required to find and print all paths between src and dest. Print them in lexicographical order.
// e.g. check the following paths
// 012546
// 01256
// 032546
// 03256
// the lexicographically smaller path is printed first

import java.io.*;
import java.util.*;

public class _02_printAllPaths {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    private static void printPathsDFS(int src, int dest, boolean[] vis, ArrayList<Edge>[] graph, String psf) {
        if (src == dest) {
            System.out.println(psf + dest);
            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                printPathsDFS(e.nbr, dest, vis, graph, psf + src);
            }
        }
        vis[src] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());

        // write all your codes here
        printPathsDFS(src, dest, new boolean[vtces], graph, "");
    }

}