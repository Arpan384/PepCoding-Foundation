// Question

// 1. You are given a graph, representing people and their connectivity.
// 2. You are also given a src person (who got infected) and time t.
// 3. You are required to find how many people will get infected in time t, if the infection spreads to neighbors of infected person in 1 unit of time.

import java.io.*;
import java.util.*;

public class _12_spreadOfInfection {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static int bfs1(ArrayList<Edge>[] graph, int src, int t, boolean vis[]) {
        Queue<Integer> que = new ArrayDeque<>();
        int count = 0;
        que.add(src);

        while (que.size() > 0 && t > 0) {
            int s = que.size();
            while (s-- > 0) {
                int rvtx = que.remove();
                if (vis[rvtx])
                    continue;
                count++;
                vis[rvtx] = true;

                for (Edge e : graph[rvtx]) {
                    if (vis[e.nbr] == false) {
                        // vis[e.nbr] = true;
                        // count++;
                        que.add(e.nbr);
                    }
                }
            }
            t = t - 1;

        }
        return count;
    }

    private static int bfs(int inf, int t, ArrayList<Edge>[] graph) {
        LinkedList<int[]> ll = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        int count = 0;
        ll.add(new int[] { inf, 0 });
        vis[inf] = true;

        while (ll.size() > 0) {
            int[] curr = ll.removeFirst();
            if (curr[1] >= t)
                break;
            count++;
            for (Edge e : graph[curr[0]]) {
                if (!vis[e.nbr]) {
                    vis[e.nbr] = true;
                    ll.add(new int[] { e.nbr, curr[1] + 1 });
                }
            }
        }
        return count;
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
        int t = Integer.parseInt(br.readLine());

        // write your code here
        System.out.println(bfs(src, t, graph));
    }

}