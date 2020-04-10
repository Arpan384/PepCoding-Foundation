// Question

//    1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. The two arrays represent digits of two numbers.
// 6. You are required to find the difference of two numbers represented by two arrays and print the
// arrays. a2 - a1

// Assumption - number represented by a2 is greater

import java.util.*;

public class _12_differenceOfTwoArrays {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int[] num1 = new int[n1];
        for (int i = 0; i < n1; i++)
            num1[i] = scn.nextInt();

        int n2 = scn.nextInt();
        int[] num2 = new int[n2];
        for (int i = 0; i < n2; i++)
            num2[i] = scn.nextInt();

        int[] ans = new int[n2];

        int i = n1 - 1, j = n2 - 1;
        int borrow = 0;

        while (i >= 0) {
            ans[j] = num2[j] - borrow - num1[i];
            borrow = 0;
            if (ans[j] < 0) {
                ans[j] += 10;
                borrow = 1;
            }
            // System.out.print
            j--;
            i--;
        }

        while (j >= 0) {
            ans[j] = num2[j] - borrow;
            j--;
            borrow = 0;
        }

        int k = 0;

        while (k < ans.length)
            System.out.println(ans[k++]);

    }
}