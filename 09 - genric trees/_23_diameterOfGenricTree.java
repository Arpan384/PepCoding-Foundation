// Question

//  1. You are given a partially written GenericTree class.
// 2. You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges between any two nodes in the tree. Check the question video for clarity.
// 3. Input is managed for you.

import java.io.*;
import java.util.*;

public class _23_diameterOfGenricTree {
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


    // diameter b/w leaf nodes
    static int finalDiameter;
    public static int diameter(Node node) {

        int h = -1;
        int lh = -1, slh = -1;
        for (Node child : node.children) {
            int ch = diameter(child);
            h = Math.max(h, ch);

            if (ch > lh) {
                // largest & second largest height update
                slh = lh;
                lh = ch;
            } else if (ch > slh) {
                // second largest height update
                slh = ch;
            }
        }
        if (lh != -1 && slh != -1) {
            // diameter cam be calculated for the node
            int diameter = lh + slh + 2;
            if (diameter > finalDiameter) {
                finalDiameter = diameter;
            }
        }

        h += 1;

        return h;
    }

    // diameter : max dist b/w any two leaf nodex
    static int dia = 0;

    public static int getDiameter(Node root) {
        // if(root.children.size()==0)return 1;
        // if(root.children.size()==1)return getDiameter(root.children.get(0)) + 1;

        int h1 = 0;
        int h2 = 0;

        for (Node x : root.children) {
            int h = getDiameter(x);
            if (h >= h1) {
                h2 = h1;
                h1 = h;
            } else if (h > h2) {
                h2 = h;
            }
        }

        // if(h1!=0)h1++;
        // if(h2!=0)h2++;

        dia = Math.max(dia, h1 + h2);

        return Math.max(h1, h2) + 1;
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
        getDiameter(root);
        System.out.println(dia);
        // write your code here
    }

}