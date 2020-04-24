
	//Uzzul Hussain
	//CS 114 - 002


	import java.util.*;

import javax.lang.model.element.Element;

import java.io.*;
	public class Part1Driver {

	public static void main(String[] args) throws ClassNotFoundException, IOException 
	   {
		
		File file = new File ("inventory.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
	
		String tempKey = ""; int x = 0;
		
		InsertionSort IS = new InsertionSort();
		MergeSort MS = new MergeSort();
		QuickSort QS = new QuickSort();
		
		String [] inputI = new String[1125];
		String [] inputM = new String[1125];
		String [] inputQ = new String[1125];
		
		while(x<1125)
		{
			tempKey = reader.readLine();
			
			inputI[x] = tempKey;
			inputM[x] = tempKey;
			inputQ[x++] = tempKey;
		}
		//calculates time taken by Insertion Sort
		print("---Insertion Sort: 1125 elements sorted---");
				x  =(int) System.nanoTime();
				IS.Sort(inputI,1125 );
				x -= (int) System.nanoTime();
				print("Time: "+(-1*x));
		
		//calculates time taken by Merge Sort
		print("---Merge Sort: 1125 elements sorted---");
				x  =(int) System.nanoTime();
				MS.Sort(inputM);
				x -= (int) System.nanoTime();
				print("Time: "+(-1*x));
				

		//calculates time taken by Quick Sort
		print("---Quick Sort: 1125 elements sorted---");
				x  =(int) System.nanoTime();
				QS.Sort(inputQ);
				x -= (int) System.nanoTime();
				print("Time: "+(-1*x));
		
		
		
		
	   }
	
	
	
	
	
	public static void print(String s){
		System.out.println(s);
	}
	public static void print(int s){
		System.out.println(s);
	}
	}