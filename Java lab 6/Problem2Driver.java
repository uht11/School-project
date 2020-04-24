//Uzzul Hussain
//CS 114 - 002


//This program only checks parenthasis

import java.util.*;
import java.util.LinkedList;
import java.io.*;
public class Problem2Driver 
{

public static void main(String[] args) throws FileNotFoundException 
   {


      Random gen = new Random();
      LQueue Tellers  = new LQueue();
      Line   Customers  = new Line();       //service line Linked queue
      boolean isTrue = false;

for (int z =1; z<=10;z++){
     System.out.println("**********Loop "+(z)+":**********");

      int Cnum =(gen.nextInt(5) + 1); //Customer random number between 1-5
      int Tnum =(gen.nextInt(4) + 1); //Teller Service random number between 1-4
      System.out.println("Customers came in:");
      for( int i=0; i<Cnum; i++)
      {  
         int rann = gen.nextInt(49)+1;
         Customers.addCustomer(new Customer(rann));
         System.out.println("Customer "+rann);
      }
      
      System.out.println("\nTellers available:");
      for( int i=0; i<Tnum; i++)
      {
            System.out.println("Teller "+(i+1));
      }
      for(int x = 1; x <= Tnum; x++)
         {
            
            System.out.println(Customers.nextCustomer() + " is being served");
            if(Customers.size() == 0 && (Cnum != Tnum))
            {
            
            for(int i=x; i<Tnum; i++)
            {
               System.out.println("Teller "+(++x)+" is waiting............");
             }
               break;
            }
         }
        
         if(Customers.size() !=0)
         {  
            int lenn = Customers.size();
            for(int y = 0; y <lenn ; y++)
            {
               System.out.println(Customers.nextCustomer() + " is still waiting.....");
            }
         }
      
      
     
      
  }//end of loop
      
   }//EOM
}//EOF