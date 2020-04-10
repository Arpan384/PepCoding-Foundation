// Question

//  1. You are required to check if a given set of numbers is a valid pythagorean triplet.
//   2. Take as input three numbers a, b and c.
//   3. Print true if they can form a pythagorean triplet and false otherwise

import java.util.*;

public class _13_pythagoreanTriplet {

    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        boolean flag = (a * a + b * b == c * c);
        flag = flag || (c * c + b * b == a * a);
        flag = flag || (c * c + a * a == b * b);

        System.out.println(flag);
    }
}