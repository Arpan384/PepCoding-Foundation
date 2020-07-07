// Question

//  1. You are required to complete the code of our PriorityQueue class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
// 2. Here is the list of functions that you are supposed to complete
// 2.1. add -> Should accept new data.
// 2.2. remove -> Should remove and return smallest value, if available or print "Underflow" otherwise and return -1
// 2.3. peek -> Should return smallest value, if available or print "Underflow" otherwise and return -1
// 2.4. size -> Should return the number of elements available
// 3. Input and Output is managed for you.

import java.io.*;
import java.util.*;

public class _09_writePriorityQueueUsingHeap {

    public static class PriorityQueue {
        ArrayList<Integer> data;
        boolean isMin = true;

        private int compare(int i, int j) {
            int min = data.get(i) < data.get(j) ? i : j;
            int max = min == i ? j : i;
            if (isMin)
                return min;
            else
                return max;

        }

        public PriorityQueue() {
            // isMin = false;
            data = new ArrayList<>();
        }

        private void swap(int i, int j) {
            int temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }

        private void upHeapify(int ci) {
            int pi = (ci - 1) / 2;
            // while(data.get(pi) > data.get(ci)){
            // swap(ci,pi);
            // ci = pi;
            // pi = (ci-1)/2;
            // }
            while (compare(pi, ci) != pi) {
                swap(ci, pi);
                ci = pi;
                pi = (ci - 1) / 2;
            }
        }

        public void add(int val) {
            // write your code here
            data.add(val);
            upHeapify(data.size() - 1);
        }

        private void downHeapify(int idx) {
            // int idx = 0;
            int c1 = 2 * idx + 1;
            int c2 = 2 * idx + 2;
            int minIdx = idx;

            if (c1 < data.size())
                minIdx = compare(c1, minIdx);
            if (c2 < data.size())
                minIdx = compare(c2, minIdx);

            if (minIdx != idx) {
                swap(minIdx, idx);
                downHeapify(minIdx);
            }

            // if(c1<data.size() && c2>=data.size()){
            // if(data.get(c1) < data.get(idx)){
            // swap(c1,idx);
            // downHeapify(c1);
            // }
            // }
            // else{
            // int minIdx = data.get(c1)<data.get(c2)? c1:c2;
            // if(data.get(minIdx)<data.get(idx)){
            // swap(minIdx, idx);
            // downHeapify(minIdx);
            // }
            // }

        }

        public int remove() {
            // write your code here
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            int rv = data.get(0);
            swap(0, data.size() - 1);
            data.remove(data.size() - 1);
            downHeapify(0);
            return rv;
        }

        public int peek() {
            // write your code here
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            // write your code here
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}