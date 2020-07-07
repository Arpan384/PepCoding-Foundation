// Question

//  1. You are given an infix expression.
// 2. You are required to convert it to postfix and print it.
// 3. You are required to convert it to prefix and print it.

import java.io.*;
import java.util.*;

public class _08_infixConversionsMain {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        postConv(exp);
        preConv(exp);
    }

    public static void preConv(String exp) {
        Stack<String> st = new Stack<>();
        Stack<Character> op = new Stack<>();

        int n = exp.length();

        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i);
            // System.out.println(st.size());
            if (ch == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    String two = st.pop();
                    String one = st.pop();
                    st.push(op.pop() + one + two);
                }
                // st.push("("+st.pop()+")");
                op.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (op.size() > 0 && getPriority(op.peek()) >= getPriority(ch)) {
                    String two = st.pop();
                    String one = st.pop();
                    st.push(op.pop() + one + two);
                }
                op.push(ch);
            }
            // else if(ch>='0' && ch<='9'){
            // String x = ch+"";
            // System.out.println(x);
            // st.push(x);
            // }
            else if (ch != ' ') {
                String x = ch + "";
                // System.out.println(x);
                st.push(x);
            }
        }

        while (op.size() > 0) {
            String two = st.pop();
            String one = st.pop();
            st.push(op.pop() + one + two);
        }

        System.out.println(st.peek());
    }

    public static void postConv(String exp) {
        Stack<String> st = new Stack<>();
        Stack<Character> op = new Stack<>();

        int n = exp.length();

        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i);
            // System.out.println(st.size());
            if (ch == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    String two = st.pop();
                    String one = st.pop();
                    st.push(one + two + op.pop());
                }
                // st.push("("+st.pop()+")");
                op.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (op.size() > 0 && getPriority(op.peek()) >= getPriority(ch)) {
                    String two = st.pop();
                    String one = st.pop();
                    st.push(one + two + op.pop());
                }
                op.push(ch);
            }
            // else if(ch>='0' && ch<='9'){
            // String x = ch+"";
            // System.out.println(x);
            // st.push(x);
            // }
            else if (ch != ' ') {
                String x = ch + "";
                // System.out.println(x);
                st.push(x);
            }
        }

        while (op.size() > 0) {
            String two = st.pop();
            String one = st.pop();
            st.push(one + two + op.pop());
        }

        System.out.println(st.peek());
    }

    public static int getPriority(char c) {
        if (c == '+' || c == '-')
            return 1;
        if (c == '*' || c == '/')
            return 2;

        return -1;
    }

}