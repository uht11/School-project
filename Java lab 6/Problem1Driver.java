//Uzzul Hussain
//CS 114 - 002


//This program only checks parenthasis

import java.util.*;
import java.io.*;
public class Problem1Driver 
{

public static void main(String[] args) throws FileNotFoundException 
   {

      int num=0,x = 0,len = 0;
      File file= new File("test.dat");
      Scanner scan = new Scanner(file);
      LQueue Q1   =  new LQueue();
      LQueue Q2   =  new LQueue();
      Random gen = new Random();
      
      while(x!=1)
      {
         num =(int)  (gen.nextInt(5) + 1); // random number between 1-5
         do
         { 
            //reading the test.dat file
             if(!scan.hasNextLine()){ x = 1; break; }     // exits on EOF
             String input = scan.nextLine();
             Q1.enqueue(input);
             num--;
         }while(num !=0 );
         Q2.enqueue(Q1.dequeue());
      }
      
      len = Q1.length();
      System.out.print("\nFirst Queue: ");
      for( int i=0; i < len; i++)
      {
         System.out.print(Q1.dequeue()+" ");
      }
      System.out.print("\nSecond Queue: ");
      len = Q2.length();
      for( int i=0; i < len; i++)
      {
         System.out.print(Q2.dequeue()+" ");
      }
      
      
      
      
      
   }//EOM
}//EOF