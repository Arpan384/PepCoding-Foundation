// Question

//   1. You are given a number n.
// 2. You've to write code to print the pattern given in output format below
//          1	
//      2	3	2	
//  3	4	5	4	3	
//      2	3	2	
//          1	


import java.util.*;

public class pattern15 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
         // write ur code here
         
         int n = scn.nextInt();
         for(int i=1; i<=n/2+1; i++){
             int val = i;
             for(int j=i; j<=n/2; j++){
                 System.out.print("	");
             }
             
             for(int j=1; j<=i; j++){
                 System.out.print(val++ + "	");
             }
             
             val-=2;
             
             for(int j=1; j<i; j++){
                 System.out.print(val-- + "	");
             }
             
             System.out.println();
         }
         
         for(int i=n/2; i>0; i--){
             int val = i;
             for(int j=i; j<=n/2; j++){
                 System.out.print("	");
             }
             
             for(int j=1; j<=i; j++){
                 System.out.print(val++ + "	");
             }
             
             val-=2;
             
             for(int j=1; j<i; j++){
                 System.out.print(val-- + "	");
             }
             
             System.out.println();
         }
         
    
     }
}