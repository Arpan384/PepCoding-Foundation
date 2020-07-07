// Question

//   1. You are given a partially written BinaryTree class.
// 2. You are required to complete the body of iterativePrePostInTraversal function. The function is expected to print pre order, in order and post order of the tree in separate lines (first pre, then in and finally post order). All elements in an order must be separated by a space.
// 3. Input is managed for you. 

import java.io.*;
import java.util.*;

public class _10_iterativePreInPostOrderTraversalsBT {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    private static class Pair_ {
        Node node;
        boolean leftDone, rightDone, selfDone;

        Pair_(Node n) {
            node = n;
            leftDone = rightDone = selfDone = false;
        }
    }

    public static void iterativePrePostInTraversal(Node node) {
        // write your code here

        Stack<Pair_> st = new Stack<>();
        st.push(new Pair_(node));

        StringBuilder pre = new StringBuilder("");
        StringBuilder in = new StringBuilder("");
        StringBuilder post = new StringBuilder("");

        while (!st.isEmpty()) {
            Pair_ curr = st.peek();
            if (!curr.selfDone) {
                curr.selfDone = true;
                // System.out.print(curr.node.data+" ");
                pre.append(curr.node.data + " ");
            } else if (!curr.leftDone) {
                curr.leftDone = true;
                if (curr.node.left == null)
                    continue;
                st.push(new Pair_(curr.node.left));
            } else if (!curr.rightDone) {
                in.append(curr.node.data + " ");
                curr.rightDone = true;
                if (curr.node.right == null)
                    continue;
                st.push(new Pair_(curr.node.right));
            } else {
                post.append(curr.node.data + " ");
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    public static void iterativePrePostInTraversal1(Node node) {
        // write your code here

        Stack<Pair_> st = new Stack<>();
        st.push(new Pair_(node));

        while (!st.isEmpty()) {
            Pair_ curr = st.peek();
            if (!curr.selfDone) {
                curr.selfDone = true;
                System.out.print(curr.node.data + " ");
            } else if (!curr.leftDone) {
                curr.leftDone = true;
                if (curr.node.left == null)
                    continue;
                st.push(new Pair_(curr.node.left));
            } else if (!curr.rightDone) {
                curr.rightDone = true;
                if (curr.node.right == null)
                    continue;
                st.push(new Pair_(curr.node.right));
            } else
                st.pop();
        }
        System.out.println();

        st.push(new Pair_(node));

        while (!st.isEmpty()) {
            Pair_ curr = st.peek();
            if (!curr.leftDone) {
                curr.leftDone = true;
                if (curr.node.left == null)
                    continue;
                st.push(new Pair_(curr.node.left));
            } else if (!curr.selfDone) {
                curr.selfDone = true;
                System.out.print(curr.node.data + " ");
            } else if (!curr.rightDone) {
                curr.rightDone = true;
                if (curr.node.right == null)
                    continue;
                st.push(new Pair_(curr.node.right));
            } else
                st.pop();
        }
        System.out.println();

        st.push(new Pair_(node));

        while (!st.isEmpty()) {
            Pair_ curr = st.peek();
            if (!curr.leftDone) {
                curr.leftDone = true;
                if (curr.node.left == null)
                    continue;
                st.push(new Pair_(curr.node.left));
            } else if (!curr.rightDone) {
                curr.rightDone = true;
                if (curr.node.right == null)
                    continue;
                st.push(new Pair_(curr.node.right));
            } else if (!curr.selfDone) {
                curr.selfDone = true;
                System.out.print(curr.node.data + " ");
            } else
                st.pop();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        iterativePrePostInTraversal(root);
    }

}