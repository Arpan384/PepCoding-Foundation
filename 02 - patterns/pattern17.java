// Question

//   1. You are given a number n.
// 2. You've to write code to print the pattern given in output format below
//          *	
//          *	*	
// *	*	*	*	*	
//          *	*	
//          *	



import java.util.*;

public class pattern17 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
         // write ur code here
         int n = scn.nextInt();
         
         for(int i=1; i<=n/2; i++){
             for(int j=1; j<=n/2; j++)System.out.print("\t");
             for(int j=1; j<=i; j++)System.out.print("*\t");
             System.out.print("\n");
         }
         
         for(int j=1; j<=n; j++)System.out.print("*\t");
         System.out.println();
         
         for(int i=n/2; i>=1; i--){
             for(int j=1; j<=n/2; j++)System.out.print("\t");
             for(int j=1; j<=i; j++)System.out.print("*\t");
             System.out.print("\n");
         }
     }
}