// Question

//  1. You are given a partially written GenericTree class.
// 2. You are require to complete the body of function IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space.
// 3. Input and Output is managed for you. 

import java.io.*;
import java.util.*;

public class _22_iterativePreorderAndPostorderOfGT {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static class Pair {
        Node node = null;
        int pointer = 0;

        Pair(Node x) {
            node = x;
        }
    }

    public static void IterativePreandPostOrder(Node node) {
        // write your code here
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node));

        while (!st.isEmpty()) {
            Pair curr = st.peek();
            if (curr.pointer == 0) {
                System.out.print(curr.node.data + " ");
            }
            if (curr.pointer == curr.node.children.size()) {
                st.pop();
            } else {
                st.push(new Pair(curr.node.children.get(curr.pointer++)));
            }
        }
        System.out.println();
        st.push(new Pair(node));

        while (!st.isEmpty()) {
            Pair curr = st.peek();
            if (curr.pointer == curr.node.children.size()) {
                System.out.print(curr.node.data + " ");
                st.pop();
            } else {
                st.push(new Pair(curr.node.children.get(curr.pointer++)));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        IterativePreandPostOrder(root);
    }

}