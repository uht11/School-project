//********************************************************************
//  SelectionSortDriver.java       Author: Lewis/Loftus
//
//  Solution to Programming Project 13.3 
//********************************************************************

import java.util.Random;

public class SelectionSortDriver
{
   public static final int MIN_NUMBERS = 10;  // min number of generated values
   public static final int RANGE = 20;        // range for number of generated values
   public static final int MAX_INT_VALUE = 100;

   //----------------------------------------------------------------
   //  Sorts a linked list of integers.
   //----------------------------------------------------------------
   public static void main (String args[]) 
   {
      Random gen = new Random();
      SelectionSortS sorter = new SelectionSortS();
        
      int numInts = gen.nextInt(RANGE) + MIN_NUMBERS;
        
      System.out.println("Generated " + numInts + " integers:");
        
      for (int i=0; i < numInts; i++)
         sorter.add(""+gen.nextInt(MAX_INT_VALUE));

      System.out.println(sorter);  // unsorted

      sorter.sort();

      System.out.println("Sorted:");
      System.out.println(sorter);
   }
}
