// Question

//    1. You are given a number n, representing the number of time-intervals.
// 2. In the next n lines, you are given a pair of space separated numbers.
// 3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
// 4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

// E.g. Let us say there are 6 meetings
// 1 8
// 5 12
// 14 19
// 22 28
// 25 27
// 27 30

// Then the output of merged meetings will belongs
// 1 12
// 14 19
// 22 30

// Note -> The given input maynot be sorted by start-time
                               

import java.io.*;
import java.util.*;

public class _13_mergeOverlappingInterval {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time

        int n = arr.length;

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        // for(int i=0; i<n; i++){
        // System.out.println(arr[i][0]+" "+arr[i][1]);
        // }

        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                st.push(new int[] { arr[i][0], arr[i][1] });
                continue;
            }

            if (st.peek()[1] >= arr[i][0]) {
                int[] top = st.pop();
                top[1] = Math.max(arr[i][1], top[1]);
                st.push(top);
            } else {
                st.push(new int[] { arr[i][0], arr[i][1] });
            }
        }

        Stack<int[]> st1 = new Stack<>();
        while (st.size() > 0) {
            st1.push(st.pop());
        }

        while (st1.size() > 0) {
            int[] top = st1.pop();
            System.out.println(top[0] + " " + top[1]);
        }
    }

}