// Question

// 1. You are given a graph, a src vertex and a destination vertex.
// 2. You are required to find if a path exists between src and dest. If it does, print true otherwise print false.

import java.io.*;
import java.util.*;

public class _01_hasPath {
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

    private static boolean hasPathDFS(boolean[] vis, int src, int dest, ArrayList<Edge>[] graph) {
        if (src == dest)
            return true;
        vis[src] = true;
        boolean flag = false;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                flag = flag || hasPathDFS(vis, e.nbr, dest, graph);
            }
        }
        vis[src] = false;

        return flag;
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

        // write your code here
        System.out.println(hasPathDFS(new boolean[vtces], src, dest, graph));
    }

}