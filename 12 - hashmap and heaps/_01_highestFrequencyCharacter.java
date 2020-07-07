// Question

// 1. You are given a string str.
// 2. You are required to find the character with maximum frequency.

import java.io.*;
import java.util.*;

public class _01_highestFrequencyCharacter {

    public static void main(String[] args) throws Exception {
        // write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        int maxFreq = 0;
        char ch = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            if (maxFreq < map.get(str.charAt(i))) {
                maxFreq = map.get(str.charAt(i));
                ch = str.charAt(i);
            }
        }

        System.out.println(ch);
    }

}