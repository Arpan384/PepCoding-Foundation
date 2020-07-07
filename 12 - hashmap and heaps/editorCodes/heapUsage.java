import java.util.*;

public class heapUsage{

public static void main(String[] args) {

// write your code here.
    //default -> min PQ
    PriorityQueue<Integer> minPQ = new PriorityQueue<>();
    for(int i=1; i<=15; i++){
        minPQ.add(i);
    }
    
    System.out.println("Size-> "+minPQ.size());
    
    while(!minPQ.isEmpty()){
        //top -> peek
        System.out.println(minPQ.remove());  // or poll
    }
    
    System.out.println();
    
    //maxPQ
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    for(int i=1; i<=15; i++){
        maxPQ.add(i);
    }
    
    System.out.println("Size-> "+maxPQ.size());
    
    while(!maxPQ.isEmpty()){
        //top -> peek
        System.out.println(maxPQ.remove());  // or poll
    }
    

 }
}