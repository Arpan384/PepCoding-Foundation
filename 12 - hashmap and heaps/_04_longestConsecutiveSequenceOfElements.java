// Question

// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates)

// Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.

import java.io.*;
import java.util.*;

public class _04_longestConsecutiveSequenceOfElements {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int ans = 0;
        int minIdx = n;

        for (int i = 0; i < n; i++) {
            int num = scn.nextInt();
            map.put(num, Math.min(i, map.getOrDefault(num, n)));
        }

        for (Integer x : map.keySet()) {
            if (map.get(x) == -1)
                continue;
            int curr = x - 1;
            int len = 1;
            int idx = map.get(x);
            map.put(x, -1);
            while (map.containsKey(curr)) {
                idx = map.get(curr);
                map.put(curr, -1);
                curr--;
                len++;
            }
            int st = curr + 1;

            curr = x + 1;
            while (map.containsKey(curr)) {
                map.put(curr, -1);
                curr++;
                len++;
            }
            if ((len == maxLen && minIdx > idx) || len > maxLen) {
                ans = st;
                maxLen = len;
                minIdx = idx;
            }
        }

        for (int i = 0; i < maxLen; i++) {
            System.out.println(ans++);
        }
    }

}