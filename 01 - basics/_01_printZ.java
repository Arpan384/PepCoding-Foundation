// Question

//  1. You are required to print a 'z' of size 5 using '*'.
                               

public class _01_printZ {

    public static void main(String[] args) {
        // Write your code here
        for (int i = 0; i < 5; i++)
            System.out.print("*");
        System.out.println();
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < i; j++)
                System.out.print(" ");
            System.out.println("*");
        }
        for (int i = 0; i < 5; i++)
            System.out.print("*");
    }
}