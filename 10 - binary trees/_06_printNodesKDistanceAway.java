// Question

//  1. You are given a partially written BinaryTree class.
// 2. You are given a value data and a value k.
// 3. You are required to complete the body of printKNodesFar function. The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
// 4. Input is managed for you. 

import java.io.*;
import java.util.*;

public class _06_printNodesKDistanceAway {
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

    private static void printKNodeDown(Node node, int k) {
        if (node == null)
            return;
        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKNodeDown(node.left, k - 1);
        printKNodeDown(node.right, k - 1);
    }

    public static int printKNodesFar(Node node, int data, int k) {
        // write your code here
        if (node == null)
            return -1;
        if (node.data == data) {
            printKNodeDown(node, k);
            return 1;
        }

        int left = printKNodesFar(node.left, data, k);
        if (left != -1) {
            if (left == k) {
                System.out.println(node.data);
            } else if (left < k) {
                printKNodeDown(node.right, k - left - 1);
            }
            return left + 1;
        }
        int right = printKNodesFar(node.right, data, k);
        if (right != -1) {
            if (right == k) {
                System.out.println(node.data);
            } else if (right < k) {
                printKNodeDown(node.left, k - right - 1);
            }
            return right + 1;
        }

        return -1;
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

        int data = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        printKNodesFar(root, data, k);
    }

}