// Question

//   1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
// 2. Input and Output is managed for you.

import java.io.*;
import java.util.*;

public class _10_wrtieHashMap {

    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        double loadFactor;
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            loadFactor = 2.0;
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        private void rehashing() throws Exception {
            LinkedList<HMNode>[] oldBuckets = buckets;
            size = 0;
            initbuckets(2 * buckets.length);

            for (LinkedList<HMNode> x : oldBuckets) {
                for (HMNode y : x) {
                    put(y.key, y.value);
                }
            }
        }

        private int findInBucket(int bi, K key) {
            int i = 0;
            for (HMNode n : buckets[bi]) {
                if (n.key.equals(key))
                    return i;
                i++;
            }
            return -1;
        }

        private int findBucket(K key) {
            int hashCode = key.hashCode();
            int inRange = Math.abs(hashCode) % buckets.length;
            return inRange;
        }

        public void put(K key, V value) throws Exception {
            // write your code here
            int bi = findBucket(key);
            int idx = findInBucket(bi, key);
            if (idx == -1) {
                buckets[bi].add(new HMNode(key, value));
                size++;
            } else {
                buckets[bi].get(idx).value = value;
            }

            double lambda = (size * 1.0) / buckets.length;
            if (lambda > loadFactor) {
                rehashing();
            }

        }

        public V get(K key) throws Exception {
            // write your code here
            int bi = findBucket(key);
            int idx = findInBucket(bi, key);
            if (idx == -1) {
                return null;
            } else {
                return buckets[bi].get(idx).value;
            }
        }

        public boolean containsKey(K key) {
            // write your code here
            int bi = findBucket(key);
            int idx = findInBucket(bi, key);
            return idx != -1;
        }

        public V remove(K key) throws Exception {
            // write your code here
            int bi = findBucket(key);
            int idx = findInBucket(bi, key);
            if (idx == -1) {
                return null;
            } else {
                size--;
                // HMNode temp = buckets[bi].get(0);
                // buckets[bi].set(0, buckets[bi].get(idx));
                // buckets[bi].set(idx, temp);
                // buckets[bi].remove(0);
                // return temp.value;
                return buckets[bi].remove(idx).value;
            }
        }

        public ArrayList<K> keyset() throws Exception {
            // write your code here
            ArrayList<K> arr = new ArrayList<>();
            for (LinkedList<HMNode> x : buckets) {
                for (HMNode y : x) {
                    arr.add(y.key);
                }
            }

            return arr;

        }

        public int size() {
            // write your code here
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print(node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}