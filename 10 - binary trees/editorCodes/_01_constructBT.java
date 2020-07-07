import java.util.*;

public class _01_constructBT {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node(int data) {
            this.data = data;
        }
    }

    private static class Pair {
        Node node;
        int state;

        Pair(Node n, int st) {
            node = n;
            state = st;
        }
    }

    public static Node construct(Integer[] input) {
        Stack<Pair> st = new Stack<>();
        Node root = new Node(input[0]);
        st.push(new Pair(root, 1));
        int idx = 1;

        while (!st.isEmpty() && idx < input.length) {
            Pair top = st.peek();
            Integer val = input[idx];

            if (top.state == 1) {
                if (val == null) {
                    top.state++;
                } else {
                    Node n = new Node(val);
                    top.node.left = n;
                    top.state++;
                    st.push(new Pair(n, 1));
                }
                idx++;
            } else if (top.state == 2) {
                if (val == null) {
                    top.state++;
                } else {
                    Node n = new Node(val);
                    top.node.right = n;
                    top.state++;
                    st.push(new Pair(n, 1));
                }
                idx++;
            } else
                st.pop();
        }

        return root;
    }

    private static void display(Node root) {
        if (root == null)
            return;

        System.out.print((root.left == null ? "null" : root.left.data) + " < ");
        System.out.print(root.data);
        System.out.println(" > " + (root.right == null ? "null" : root.right.data));

        display(root.left);
        display(root.right);
    }

    public static void inorder(Node node){
        if(node==null)return;
        inorder(node.left);
        System.out.print(node.data+"  ");
        inorder(node.right);
    }

    public static void preorder(Node node){
        if(node==null)return;
        System.out.print(node.data+"  ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void postorder(Node node){
        if(node==null)return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+"  ");
    }

    public static void main(String[] args) {

        // write your code here.
        Integer[] input = { 10, 20, 40, null, null, 50, 60, null, null, null, 30, null, 70, 80, null, null, 90, null,
                null };
        Node root = construct(input);
        display(root);

    }
}