// Question

//  1. You are given a positive number n. 
// 2. You are required to print the counting from n to 1 and back to n again.
// 3. You are required to not use any loops. Complete the body of pdi function to achieve it. Don't change the signature of the function.
// Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

import java.util.*;

public class _03_printIncreasingDecreasing {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        print(n);
    }

    public static void print(int n){
        if(n<1)return;
        System.out.println(n);
        print(n-1);
        System.out.println(n);
    }
}