// Question

//   1. You are given a number n.
// 2. You've to write code to print it's multiplication table up to 10 in format given below
// 5 * 1 = 5
// 5 * 2 = 10
// 5 * 3 = 15
// 5 * 4 = 20
// 5 * 5 = 25
// 5 * 6 = 30
// 5 * 7 = 35
// 5 * 8 = 40
// 5 * 9 = 45
// 5 * 10 = 50
	

import java.util.*;

public class pattern14 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
         // write ur code here
          int n = scn.nextInt();
          
          for(int i=1; i<=10; i++){
              System.out.println(n+" * "+i+" = "+(n*i));
          }
     }
}