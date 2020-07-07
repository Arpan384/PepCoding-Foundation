// Question

//  1. You are given an infix expression.
// 2. You are required to evaluate and print it's value.



import java.io.*;
import java.util.*;

public class _07_infixEvaluation {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<Integer> nums = new Stack<>();
        Stack<Character> oprs = new Stack<>();

        int n = exp.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // display(nums,oprs);
            if (exp.charAt(i) == '(') {
                oprs.push(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {

                // System.out.println(nums.peek()+"===="+oprs.peek());
                if (sb.toString().length() > 0) {
                    nums.push(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                }
                // System.out.println(nums.peek()+"===="+oprs.peek());
                while (oprs.peek() != '(') {
                    int op2 = nums.pop();
                    int op1 = nums.pop();
                    char op = oprs.pop();
                    int res = eval(op1, op, op2);
                    nums.push(res);
                }

                oprs.pop();
                // System.out.println(nums.peek()+"===="+oprs.peek());
            } else if (isDig(exp.charAt(i))) {
                sb.append(exp.charAt(i));
            } else if (isOp(exp.charAt(i))) {
                // nums.push(Integer.parseInt(sb.toString()));
                // sb = new StringBuilder();
                // do opr priority
                while (oprs.size() > 0 && getPriority(oprs.peek()) >= getPriority(exp.charAt(i))) {
                    int op2 = nums.pop();
                    int op1 = nums.pop();
                    char op = oprs.pop();
                    int res = eval(op1, op, op2);
                    nums.push(res);
                }

                oprs.push(exp.charAt(i));
                // System.out.println(nums.peek()+"===="+oprs.peek());
            } else if (exp.charAt(i) == ' ') {
                if (sb.toString().length() == 0)
                    continue;
                nums.push(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            }
        }

        if (sb.toString().length() > 0)
            nums.push(Integer.parseInt(sb.toString()));

        while (oprs.size() > 0) {
            int op2 = nums.pop();
            int op1 = nums.pop();
            char op = oprs.pop();
            int res = eval(op1, op, op2);
            nums.push(res);
        }

        System.out.println(nums.peek());

    }

    public static boolean isDig(char c) {
        if (c >= 48 && c <= 57)
            return true;
        return false;
    }

    public static boolean isOp(char c) {
        if (c == '+' || c == '-' || c == '/' || c == '*')
            return true;
        return false;
    }

    public static int eval(int op1, char opr, int op2) {

        // System.out.println(op1+" "+opr+" "+op2);

        if (opr == '+') {
            return op1 + op2;
        }
        if (opr == '-') {
            return op1 - op2;
        }
        if (opr == '/') {
            return (int) (op1 / op2);
        }
        if (opr == '*') {
            return op1 * op2;
        }
        return -1;
    }

    public static int getPriority(char c) {
        if (c == '+' || c == '-')
            return 1;
        if (c == '/' || c == '*')
            return 2;
        return -1;
    }

    public static void display(Stack<Integer> st1, Stack<Character> st2) {
        System.out.println(st1.size() + " -> " + st2.size());
    }
}