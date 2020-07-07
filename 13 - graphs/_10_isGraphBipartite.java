// Question

// 1. You are given a graph.
// 2. You are required to find and print if the graph is bipartite

// Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually exlusive and exhaustive vertices such that all edges are across sets

import java.io.*;
import java.util.*;

public class Main {
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

    private static boolean bfs(ArrayList<Edge>[] graph, int src, int[] vis) {
        LinkedList<int[]> ll = new LinkedList<>();
        // boolean[] vis = new boolean[graph.length];
        // vis[src] = 0;
        ll.add(new int[] { src, 0 });

        while (ll.size() > 0) {
            int[] vtx = ll.removeFirst();
            // System.out.println(front.vtx+"@"+front.path);
            if (vis[vtx[0]] != 2) {
                if (vtx[1] != vis[vtx[0]])
                    return false;
                else
                    continue;
            }

            vis[vtx[0]] = vtx[1];
            int curr = (vtx[1] + 1) % 2;

            for (Edge e : graph[vtx[0]]) {
                if (vis[e.nbr] == 2) {
                    // vis[e.nbr] = curr;
                    ll.addLast(new int[] { e.nbr, curr });
                }
            }
        }
        return true;
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

        boolean flag = true;
        int[] vis = new int[vtces];
        Arrays.fill(vis, 2);

        for (int i = 0; i < vtces && flag; i++) {
            if (vis[i] == 2) {
                flag = flag && bfs(graph, i, vis);
            }
        }

        // S
        System.out.println(flag);
    }
}