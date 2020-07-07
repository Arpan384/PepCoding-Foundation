// Question

// 1. You are given a graph.
// 2. You are required to find and print all connected components of the graph.

import java.io.*;
import java.util.*;

public class _04_getConnectedComponents {
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

   private static void dfs(int src, boolean[] vis, ArrayList<Integer> ans, ArrayList<Edge>[] graph) {
      vis[src] = true;
      ans.add(src);
      for (Edge e : graph[src]) {
         if (!vis[e.nbr]) {
            dfs(e.nbr, vis, ans, graph);
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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

      // write your code here

      boolean[] vis = new boolean[vtces];
      for (int i = 0; i < graph.length; i++) {
         if (!vis[i]) {
            ArrayList<Integer> ans = new ArrayList<>();
            dfs(i, vis, ans, graph);
            comps.add(ans);
         }
      }

      System.out.println(comps);
   }
}