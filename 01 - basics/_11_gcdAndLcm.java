// Question

//  1. You are required to print the Greatest Common Divisor (GCD) of two numbers.
//     2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.
//     3. Take input "num1" and "num2" as the two numbers.
//     4. Print their GCD and LCM.

import java.util.*;

public class _11_gcdAndLcm {

    public static void main(String[] args) {
        // write your code here  
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = 1, lcm = n1*n2;
        
        for(int i = Math.min(n1, n2); i>0; i--){
            if(n1%i == 0 && n2%i == 0){
                gcd = i;
                break;
            }
        }
        
        for(int i=Math.max(n1,n2); i<n1*n2; i+=gcd){
            if(i%n1 == 0 && i%n2 == 0){
                lcm = i;
                break;
            }
        }
        
        System.out.println(gcd +" " + lcm);
       }
}