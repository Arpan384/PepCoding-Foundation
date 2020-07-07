
// Merge K Sorted Lists
// Question

// 1. You are given a list of lists, where each list is sorted.
// 2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.

import java.io.*;
import java.util.*;

public class _08_mergeKSortedLists {
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();

        // write your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return lists.get(a[0]).get(a[1]) - lists.get(b[0]).get(b[1]);
        });
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new int[] { i, 0 });
        }

        while (pq.size() > 0) {
            int[] top = pq.poll();
            rv.add(lists.get(top[0]).get(top[1]++));
            if (top[1] < lists.get(top[0]).size()) {
                pq.add(top);
            }
        }

        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}