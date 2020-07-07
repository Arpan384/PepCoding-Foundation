// Question

//  1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
// 2. 'd' stands for decreasing and 'i' stands for increasing
// 3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that 
// the digit decreases following a d and increases follwing an i.

// e.g.
// d -> 21
// i -> 12
// ddd -> 4321
// iii -> 1234
// dddiddd -> 43218765
// iiddd -> 126543



import java.io.*;
import java.util.*;

public class _12_smallestNumberFollowingPattern {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        // code

        int curr = 1;
        Stack<Integer> st = new Stack<>();
        // StringBuilder sb = new StringBuilder();
        int num = 0;

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            st.push(curr++);
            if (ch == 'd') {
                continue;
            } else {
                while (!st.isEmpty()) {
                    num *= 10;
                    num += st.pop();
                }
            }
        }

        st.push(curr);

        while (!st.isEmpty()) {
            num *= 10;
            num += st.pop();
        }

        System.out.println(num);
    }
}