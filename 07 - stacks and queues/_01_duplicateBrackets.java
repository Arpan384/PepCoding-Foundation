// Question

//  1. You are given a string exp representing an expression.
// 2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise.

// e.g.'
// ((a + b) + (c + d)) -> false
// (a + b) + ((c + d)) -> true


import java.io.*;
import java.util.*;

public class _01_duplicateBrackets {
    public static void main(String[] args) throws Exception {
        Scanner scn =  new Scanner(new InputStreamReader(System.in));
        
        String str = scn.nextLine();
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=')'){
                st.push(i);
                continue;
            }
            
            if(str.charAt(st.peek())=='('){
                System.out.println("true");
                return;
            }
            
            while(st.size()>0 && str.charAt(st.peek())!='('){
                st.pop();
            }
            
            if(st.size()>0){
                st.pop();
            }
        }
        
        System.out.println("false");
    }
}