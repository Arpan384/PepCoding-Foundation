import java.util.*;

public class _01_constructBST {

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

    public static Node construct(int si, int ei, int[] arr) {
        if (si > ei)
            return null;
        int idx = si + (ei - si) / 2;
        Node mid = new Node(arr[idx]);
        mid.left = construct(si, idx - 1, arr);
        mid.right = construct(idx + 1, ei, arr);
        return mid;
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

    public static void main(String[] args) {

        // write your code here.
        // Integer[] input =
        // {10,20,40,null,null,50,60,null,null,null,30,null,70,80,null,null,90,null,null};
        int arr[] = { 12, 25, 37, 50, 67, 75, 87 };

        Node root = construct(0, arr.length - 1, arr);
        display(root);

    }
}