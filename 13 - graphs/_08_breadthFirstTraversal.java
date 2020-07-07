// Question

//  1. You are given a graph, and a src vertex.
// 2. You are required to do a breadth first traversal and print which vertex is reached via which path, starting from the src.

// Note -> for output, check the sample output and question video

import java.io.*;
import java.util.*;

public class _08_breadthFirstTraversal {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int vtx;
        String path;
        int dist;

        Pair(int v, String str, int d) {
            vtx = v;
            path = str;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here

        LinkedList<Pair> ll = new LinkedList<>();
        boolean[] vis = new boolean[vtces];
        ll.addLast(new Pair(src, "" + src, 0));
        vis[src] = true;

        while (ll.size() > 0) {
            Pair front = ll.removeFirst();
            System.out.println(front.vtx + "@" + front.path);

            for (Edge e : graph[front.vtx]) {
                if (!vis[e.nbr]) {
                    vis[e.nbr] = true;
                    ll.addLast(new Pair(e.nbr, front.path + e.nbr, front.dist + 1));
                }
            }
        }
    }
}