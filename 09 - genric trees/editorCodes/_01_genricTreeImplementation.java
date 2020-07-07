import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class _01_genricTreeImplementation{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static ArrayList<Node> constructTree(int[] arr) {  // createForest
        Stack<Node> st = new Stack<>();
        ArrayList<Node> roots = new ArrayList();

        for(int i=0; i< arr.length; i++){
            if(arr[i]==-1){
                if(!st.isEmpty())st.pop();
                continue;
            }

            Node n = new Node();
            n.data = arr[i];

            if(st.isEmpty()){
                st.push(n);
                roots.add(n);
                continue;
            }

            st.peek().children.add(n);
            st.push(n);
        }

        // while(st.size()>1){
        //     st.pop();
        // }

        // if(!st.isEmpty())root.add(st.pop());

        return roots;
    }

    public static void display(Node root) {
        System.out.print(root.data+" => ");
        for(Node n:root.children){
            System.out.print(n.data+", ");
        }
        System.out.println();

        for(Node n:root.children){
            display(n);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,-1,40,-1,-1, 100,200,-1,300,400};
        ArrayList<Node> roots = constructTree(arr);

        // for(Node root: roots){
        //     display(root);
        //     System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        // }

        Node root = roots.get(0);
        display(root);
    }
}