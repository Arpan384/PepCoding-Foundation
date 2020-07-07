// Question

// 1. You are given a graph and a src vertex. The vertices represent cities and the edges represent distance in kms.
// 2. You are required to find the shortest path to each city (in terms of kms) from the src city alongwith the total distance on path from src to destinations.

// Note -> for output, check the sample output and question video

import java.io.*;
import java.util.*;

public class _13_shortestPathInWeights_dijkstra {
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

    private static class Pair implements Comparable<Pair> {
        int v;
        int wsf;
        String psf;

        Pair(int v, int wt, String p) {
            this.v = v;
            wsf = wt;
            psf = p;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    private static void djikstrasBFS(int src, ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0, "" + src));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            if (vis[top.v])
                continue;

            vis[top.v] = true;
            System.out.println(top.v + " via " + top.psf + " @ " + top.wsf);

            for (Edge e : graph[top.v]) {
                if (!vis[e.nbr]) {
                    pq.add(new Pair(e.nbr, top.wsf + e.wt, top.psf + e.nbr));
                }
            }
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

        int src = Integer.parseInt(br.readLine());
        // write your code here
        djikstrasBFS(src, graph);

    }
}