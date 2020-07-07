// Question

// 1. You are given a partially written LinkedList class.
// 2. You are required to complete the body of addLast function. This function
// is supposed to add an element to the end of LinkedList. You are required to
// update head, tail and size as required.
// 3. Input and Output is managed for you. Just update the code in addLast
// function.

import java.io.*;
import java.util.*;

public class _01_addLastInLinkedList {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            // Write your code here
            if (size == 0) {
                head = new Node();
                head.data = val;
                tail = head;
                size++;
                return;
            }

            tail.next = new Node();
            tail = tail.next;
            tail.data = val;
            size++;
        }
    }

    public static void testList(LinkedList list) {
        for (Node temp = list.head; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
        System.out.println(list.size);

        if (list.size > 0) {
            System.out.println(list.tail.data);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("addLast")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }
            str = br.readLine();
        }

        testList(list);
    }
}