// Question

// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are given a number k.
// 4. You are required to find and print the k largest elements of array in increasing order.

import java.io.*;
import java.util.*;

public class _05_kLargestElements {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // write your code here
        kLargest(arr, k);
    }

    private static void kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) {
            if (pq.size() < k)
                pq.add(x);
            else {
                if (pq.peek() < x) {
                    pq.poll();
                    pq.add(x);
                }
            }
        }

        while (!pq.isEmpty())
            System.out.println(pq.poll());
    }

}
