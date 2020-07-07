// Question

// 1. You are given a graph and a src vertex.
// 2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."

// Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
// Note -> Print in lexicographically increasing order.


import java.io.*;
import java.util.*;

public class _17_hamiltonianPathAndCycle {
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

        int src = Integer.parseInt(br.readLine());

        // write all your codes here
        hamiltonian(src, graph);
    }

    private static void hamiltonian(int src, ArrayList<Edge>[] graph) {
        dfs(src, "", graph, new HashSet<Integer>());
    }

    private static boolean cycle(int vtx, ArrayList<Edge> edges) {
        for (Edge e : edges) {
            if (e.nbr == vtx)
                return true;
        }
        return false;
    }

    private static void dfs(int src, String psf, ArrayList<Edge>[] graph, HashSet<Integer> vis) {
        if (vis.size() == graph.length - 1) {
            char ch = cycle(psf.charAt(0) - '0', graph[src]) ? '*' : '.';
            System.out.println(psf + src + ch);
            return;
        }

        vis.add(src);
        for (Edge e : graph[src]) {
            if (!vis.contains(e.nbr)) {
                dfs(e.nbr, psf + src, graph, vis);
            }
        }
        vis.remove(src);
    }

}