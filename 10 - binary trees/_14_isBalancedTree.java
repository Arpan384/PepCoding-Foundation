// Question

// 1. You are given a partially written BinaryTree class.
// 2. You are required to check if the tree is balanced. A binary tree is
// balanced if for every node the gap between height's of it's left and right
// subtree is not more than 1.
// 3. Input is managed for you.

// Note -> Please refer the question video for clarity.

import java.io.*;
import java.util.*;

public class _14_isBalancedTree {
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
        boolean bal = true;
        int ht = 0;
    }

    private static Pair_ isBalanced(Node node) {
        if (node == null)
            return new Pair_();

        Pair_ lt = isBalanced(node.left);
        Pair_ rt = isBalanced(node.right);

        Pair_ ans = new Pair_();

        ans.bal = lt.bal && rt.bal && Math.abs(lt.ht - rt.ht) <= 1;
        ans.ht = Math.max(lt.ht, rt.ht) + 1;

        return ans;
    }

    static boolean bal = true;

    private static int isBalanced2(Node node) {
        if (node == null)
            return 0;

        if (!bal)
            return 0;
        int lt = isBalanced2(node.left);
        int rt = isBalanced2(node.right);

        bal = bal && Math.abs(lt - rt) <= 1;
        return Math.max(lt, rt) + 1;
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

        // write your code here
        // System.out.println(isBalanced(root).bal);
        isBalanced2(root);
        System.out.println(bal);
    }

}