// Question

//  1. You are given a graph and a src vertex. The vertices represent computers and the edges represent length of lan wire required to connect them.
// 2. You are required to find the minimum length of wire required to connect all PCs over a network. Print the output in terms of which all PCs need to be connected, and the length of wire between them.

// Note -> for output, check the sample output and question video

import java.io.*;
import java.util.*;

public class _16_minimumWireToConnectAllPcs_PrimMst {
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

        // write your code here
        primsMST(graph);
    }

    private static class Pair implements Comparable<Pair> {
        int vtx, par, wt;

        Pair(int v, int p, int w) {
            vtx = v;
            par = p;
            wt = w;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    private static void primsMST(ArrayList<Edge>[] graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean[] vis = new boolean[graph.length];

        while (!pq.isEmpty()) {
            Pair rem = pq.poll();

            if (vis[rem.vtx])
                continue;

            vis[rem.vtx] = true;

            if (rem.vtx != 0)
                System.out.println("[" + rem.vtx + "-" + rem.par + "@" + rem.wt + "]");

            for (Edge e : graph[rem.vtx]) {
                if (!vis[e.nbr]) {
                    pq.add(new Pair(e.nbr, rem.vtx, e.wt));
                }
            }
        }
    }

}