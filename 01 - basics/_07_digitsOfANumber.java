// Question

//   1. You've to display the digits of a number.
//     2. Take as input "n", the number for which digits have to be displayed.
//     3. Print the digits of the number line-wise

import java.util.*;

public class _07_digitsOfANumber {
    public static void main(String[] args) {
        // write your code here

        Scanner s = new Scanner(System.in);

        // int n = s.nextInt();
        String st = s.nextLine();
        for (int i = 0; i < st.length(); i++) {
            System.out.println(st.charAt(i));
        }

        // int rev = 0, c = 0;
        // boolean flag = true;
        // if(n==0){
        // System.out.println(0);
        // return;
        // }

        // while(n!=0){
        // rev = rev*10 + n%10;
        // if(flag && n%10==0)c++;
        // else flag = false;
        // n/=10;
        // }

        // while(rev!=0){
        // System.out.println(rev%10);
        // rev/=10;
        // }

        // for(int i=0; i<c; i++){
        // System.out.println(0);
        // }
    }
}