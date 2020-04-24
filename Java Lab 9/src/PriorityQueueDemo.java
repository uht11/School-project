import java.util.PriorityQueue;
import java.util.*;


public class PriorityQueueDemo {
  public static void main(String[] args) {
    PriorityQueue<String> queue1 = new PriorityQueue<>();
    queue1.offer("Oklahoma");
    queue1.offer("Indiana");
    queue1.offer("Georgia");
    queue1.offer("Texas");
    Iterator itor = queue1.iterator();
    
    System.out.println("Priority queue using Comparable:"); //Minimun Heap
     
    while (itor.hasNext())
      System.out.print(itor.next() + " ");
      
    System.out.println("\nqueue1 size "+queue1.size());
    System.out.println("\nReverse order ");
    PriorityQueue<String> queue2 = new PriorityQueue<>(     //Max Heap
      4, Collections.reverseOrder());
 
    queue2.offer("Oklahoma");
    queue2.offer("Indiana");
    queue2.offer("Georgia");
    queue2.offer("Texas");
    
    itor = queue2.iterator();
    
    System.out.println("\nPriority queue using Comparator:");
    while (itor.hasNext()) {
      System.out.print(itor.next() + " ");
    }
  }
 }