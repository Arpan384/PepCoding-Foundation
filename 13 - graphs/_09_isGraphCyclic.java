// Question

// 1. You are given a graph.
// 2. You are required to find and print if the graph is cyclic 

import java.io.*;
import java.util.*;

public class _09_isGraphCyclic {
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

    private static boolean bfs(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        LinkedList<Integer> ll = new LinkedList<>();
        // boolean[] vis = new boolean[graph.length];
        // vis[0] = true;
        ll.add(src);

        while (ll.size() > 0) {
            int vtx = ll.removeFirst();
            // System.out.println(front.vtx+"@"+front.path);
            if (vis[vtx]) {
                return true;
            }

            vis[vtx] = true;

            for (Edge e : graph[vtx]) {
                if (!vis[e.nbr]) {
                    // vis[e.nbr] = true;
                    ll.addLast(e.nbr);
                }
            }
        }
        return false;
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
        boolean flag = false;
        boolean[] vis = new boolean[vtces];

        for (int i = 0; i < vtces && !flag; i++) {
            if (!vis[i]) {
                flag = flag || bfs(graph, i, vis);
            }
        }

        System.out.println(flag);
    }
}