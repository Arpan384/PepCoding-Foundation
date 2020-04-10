// Question

//    1. You are given a number n.
//   2. You are given a base b1. n is a number on base b.
//   3. You are given another base b2.
//   4. You are required to convert the number n of base b1 to a number in base b2.

import java.util.*;

public class _04_anyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();
    
        int d = getValue(n, b1, b2);
        System.out.println(d);
     }
    
     public static int getValue(int n, int b1, int b2){
         // write your code here
         int ans = 0, p=0;
         String s = "";
         
        while(n!=0){
            ans += (n%10)*Math.pow(b1,p++);
            n/=10;
        }
        
        while(ans!=0){
            s = ans%b2 + s;
            ans/=b2;
        }
        return Integer.parseInt(s);
     }
}