// Question

// 1. You are given a driected acyclic graph. The vertices represent tasks and edges represent dependencies between tasks.
// 2. You are required to find and print the order in which tasks could be done. The task that should be done at last should be printed first and the task which should be done first should be printed last. This is called topological sort. Check out the question video for details.

// Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if for all directed edges uv, u appears before v in the graph

// Note -> for output, check the sample output and question video

import java.io.*;
import java.util.*;

public class _14_orderOfCompilation_topologicalSort {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    private static void topoDfs(int src, boolean[] vis, ArrayList<Edge>[] graph, Stack<Integer> st) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                topoDfs(e.nbr, vis, graph, st);
            }
        }
        st.add(src);
    }

    private static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topoDfs(i, vis, graph, st);
                // System.out.println(st);
                // while(st.size()>0){
                // ans.add(0,st.pop());
                // }
            }
        }
        // System.out.println(st);
        while (st.size() > 0)
            System.out.println(st.pop());
        // for(int x:ans)System.out.println(x);
    }

    private static void topoBfs(ArrayList<Edge>[] graph) {
        // boolean[] vis = new boolean[graph.length];
        int[] inDeg = new int[graph.length];

        for (ArrayList<Edge> x : graph) {
            for (Edge e : x) {
                inDeg[e.nbr]++;
            }
        }

        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0)
                ll.add(i);
        }

        while (ll.size() > 0) {
            int top = ll.removeFirst();

            System.out.println(top);

            for (Edge e : graph[top]) {
                if (--inDeg[e.nbr] == 0)
                    ll.addLast(e.nbr);
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
            graph[v1].add(new Edge(v1, v2));
        }

        // write your code here
        topologicalSort(graph);
        // topoBfs(graph);
    }

}