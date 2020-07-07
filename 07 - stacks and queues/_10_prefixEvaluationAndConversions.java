// Question

//  1. You are given a prefix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to postfix and print it.

// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.


import java.io.*;
import java.util.*;

public class _10_prefixEvaluationAndConversions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        int n = exp.length();
        // code
        Stack<Integer> nums = new Stack<>();
        Stack<String> inf = new Stack<>();
        Stack<String> post = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            char ch = exp.charAt(i);
            if (ch >= '0' && ch <= '9') {
                nums.push(ch - '0');
                inf.push(ch + "");
                post.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int op1 = nums.pop();
                int op2 = nums.pop();
                int res = eval(op1, ch, op2);
                nums.push(res);

                String in1 = inf.pop();
                String in2 = inf.pop();
                inf.push("(" + in1 + ch + in2 + ")");

                String post1 = post.pop();
                String post2 = post.pop();
                post.push(post1 + post2 + ch);
            }
        }

        System.out.println(nums.peek());
        System.out.println(inf.peek());
        System.out.println(post.peek());
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