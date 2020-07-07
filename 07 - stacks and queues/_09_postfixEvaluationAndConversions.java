// Question

//   1. You are given a postfix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to prefix and print it.

// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
                               

import java.io.*;
import java.util.*;

public class _09_postfixEvaluationAndConversions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        int n = exp.length();
        // code
        Stack<Integer> nums = new Stack<>();
        Stack<String> inf = new Stack<>();
        Stack<String> pre = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                nums.push(ch - '0');
                inf.push(ch + "");
                pre.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int op2 = nums.pop();
                int op1 = nums.pop();
                int res = eval(op1, ch, op2);
                nums.push(res);

                String in2 = inf.pop();
                String in1 = inf.pop();
                inf.push("(" + in1 + ch + in2 + ")");

                String pre2 = pre.pop();
                String pre1 = pre.pop();
                pre.push(ch + pre1 + pre2);
            }
        }

        System.out.println(nums.peek());
        System.out.println(inf.peek());
        System.out.println(pre.peek());
        // while()
    }

    public static int eval(int op1, char op, int op2) {
        if (op == '+')
            return op1 + op2;
        if (op == '-')
            return op1 - op2;
        if (op == '*')
            return op1 * op2;
        if (op == '/')
            return op1 / op2;
        return -1;
    }
}