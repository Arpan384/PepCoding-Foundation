// Question

//  1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. You are required to find the intersection of a1 and a2. To get an idea check the example below

// e.g. 
// if a1 -> 1 1 2 2 2 3 5
// and a2 -> 1 1 1 2 2 4 5
// intersection is -> 1 1 2 2 5

// Note -> Don't assume the arrays to be sorted. Check out the question video.

import java.io.*;
import java.util.*;

public class _03_getCommonElements_2 {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();
        int n1 = scn.nextInt();
        for (int i = 0; i < n1; i++) {
            int num = scn.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n2 = scn.nextInt();
        for (int i = 0; i < n2; i++) {
            int num = scn.nextInt();
            if (map.getOrDefault(num, 0) > 0) {
                System.out.println(num);
                map.put(num, map.get(num) - 1);
            }
        }
    }

}