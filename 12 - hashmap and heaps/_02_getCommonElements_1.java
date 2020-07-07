// Question

// 1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). Make sure to not print duplicates (a2 may have same value present many times)

import java.io.*;
import java.util.*;

public class _02_getCommonElements_1 {

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
            if (map.containsKey(num)) {
                System.out.println(num);
                map.remove(num);
            }
        }
    }

}