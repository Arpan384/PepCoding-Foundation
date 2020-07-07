// Question

//   1. You are given a string exp representing an expression.
// 2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

// e.g.
// [(a + b) + {(c + d) * (e / f)}] -> true
// [(a + b) + {(c + d) * (e / f)]} -> false
// [(a + b) + {(c + d) * (e / f)} -> false
// ([(a + b) + {(c + d) * (e / f)}] -> false

import java.io.*;
import java.util.*;

public class _02_balancedBrackets {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new InputStreamReader(System.in));

        String str = scn.nextLine();

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                st.push(i);
                continue;
            }

            if (str.charAt(i) == '}') {
                if (!st.isEmpty() && str.charAt(st.peek()) == '{')
                    st.pop();
                else {
                    System.out.println(false);
                    return;
                }
            } else if (str.charAt(i) == ']') {
                if (!st.isEmpty() && str.charAt(st.peek()) == '[')
                    st.pop();
                else {
                    System.out.println(false);
                    return;
                }
            } else if (str.charAt(i) == ')') {
                if (!st.isEmpty() && str.charAt(st.peek()) == '(')
                    st.pop();
                else {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(st.isEmpty());
    }

}