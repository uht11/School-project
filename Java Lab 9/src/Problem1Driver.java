//Uzzul Hussain
//CS 114 - 002


import java.lang.Comparable;
import java.util.*;
import java.io.*;
public class Problem1Driver
{

public static void main(String[] args) throws FileNotFoundException 
   {
	
	File file = new File ("inventory.txt");
	Scanner scan = new Scanner(file);
	Scanner userIN = new Scanner(System.in);
	String tempKey;   int x=0;
	String [] array = new String[20];
	MaxHeap heap = new MaxHeap(array, 0, 20);
	PriorityQueue<String> queue1 = new PriorityQueue<>(9, Collections.reverseOrder()); // reverseOrder changes the queue into Max-Min order
	
	System.out.println("Below is the heap after each insertion.");
	while( scan.hasNextLine() ) 
	{
		tempKey = scan.nextLine();
		heap.insert(tempKey);
		queue1.offer(tempKey);
		x=0;
		for(;x<heap.heapsize();x++)
		{
			System.out.print(array[x]+",");
		}
		System.out.print("\n");
	}//EOW
	System.out.println("------------------\nBelow is the heap after root has been removed");
	heap.removemax();
	for(x=0;x<heap.heapsize();x++)
	{
		System.out.print(array[x]+",");
	}
	System.out.println("\n-------------------");
	System.out.println("-------------------");
	System.out.println("\n****Part 2: MaxHeap Using Priority Queue****\n");
	
	Iterator itor = queue1.iterator(); //moves through each vales in the queue like a loop
	while (itor.hasNext())
	      System.out.print(itor.next() + " ");
	
	System.out.println("\n----After removing the Max or the head of the queue----");
	queue1.remove();
	itor = queue1.iterator();
	while (itor.hasNext())
	      System.out.print(itor.next() + " ");
	
	
	
   }
   }
