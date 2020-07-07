// Question

//   1. You are given a partially written BinaryTree class.
// 2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
// 3. Input is managed for you. 

// Note -> Please refer the question video for clarity.

import java.io.*;
import java.util.*;

public class _16_largestBstSubtree {
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

    private static class bstPair {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean bst = true;
        Node node = null;
        int size = 0;
    }

    private static bstPair largestBst(Node node) {
        bstPair ans = new bstPair();
        if (node == null)
            return ans;

        bstPair lft = largestBst(node.left);
        bstPair rht = largestBst(node.right);

        ans.max = Math.max(Math.max(rht.max, lft.max), node.data);
        ans.min = Math.min(Math.min(rht.min, lft.min), node.data);

        ans.bst = lft.bst && rht.bst && (node.data > lft.max && node.data < rht.min);

        if (ans.bst) {
            ans.size = lft.size + rht.size + 1;
            ans.node = node;
        } else {
            if (lft.size >= rht.size) {
                ans.size = lft.size;
                ans.node = lft.node;
            } else {
                ans.size = rht.size;
                ans.node = rht.node;
            }
        }

        return ans;
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
        bstPair ans = largestBst(root);
        System.out.println(ans.node.data + "@" + ans.size);
    }

}