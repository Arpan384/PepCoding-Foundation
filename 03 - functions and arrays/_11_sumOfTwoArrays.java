// Question

//   1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. The two arrays represent digits of two numbers.
// 6. You are required to add the numbers represented by two arrays and print the
// arrays

import java.util.*;

public class _11_sumOfTwoArrays {

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

        int[] ans = new int[Math.max(n1, n2) + 1];

        int i = n1 - 1, j = n2 - 1, k = ans.length - 1;
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int s = num1[i--] + num2[j--] + carry;
            ans[k--] = s % 10;
            // sum+= (s%10)*Math.pow(10,p++);
            carry = s / 10;
        }

        while (i >= 0) {
            int s = num1[i--] + carry;
            ans[k--] = s % 10;
            // sum+= (num1[i--]+carry)*Math.pow(10,p++);
            carry = 0;
        }
        while (j >= 0) {
            int s = num2[j--] + carry;
            ans[k--] = s % 10;
            // sum+= (num2[j--]+carry)*Math.pow(10,p++);
            carry = 0;
        }

        k = 0;
        k = ans[k] == 0 ? 1 : 0;

        while (k < ans.length)
            System.out.println(ans[k++]);

    }
}