import java.util.*;
import java.io.*;

public class _02_multiSolver {
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

    static int height;
    static int size;
    static int maximum;
    static int minimum;
    static int total;

    public static void multiSolver(Node node, int ht) {
        height = Math.max(height, ht);
        size++;
        maximum = Math.max(maximum, node.data);
        minimum = Math.min(minimum, node.data);
        total += node.data;

        for (Node x : node.children) {
            multiSolver(x, ht + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        height = 0;
        size = 0;
        maximum = Integer.MIN_VALUE;
        minimum = Integer.MAX_VALUE;
        total = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        multiSolver(root, 0);

        System.out.println("height: "+height);
        System.out.println("size: "+size);
        System.out.println("maximum: "+maximum);
        System.out.println("minimum: "+minimum);
        System.out.println("total: "+total);
        // display(root);
    }
}