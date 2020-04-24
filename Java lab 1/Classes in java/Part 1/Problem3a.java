//Uzzul Hussain
//CS 114 - 002
//Lab 1  2/7/16

//Problem 3 A

import java.util.*;
public class Problem3a {

    public static void main(String[] args) 
    {
      int [][] a1 = new int[2][10]; // 2x10 array created
      
      // assigning values into the array
      for(int r = 0; r < 2; r++)
      {
       for(int c = 0; c < 10; c++)
         {
         
            
            int x = (int)(901 * Math.random())+100;
            /*  
            using math.random to get an number between [0,1) 
            and multplying by 901 and adding 100 to make that 
            random number between 100 to 1000 */
      
            a1[r][c] = x;
            
         }
      }
      System.out.println("original version of the array being printed");
      for(int r = 0; r < 2; r++)
      {
       for(int c = 0; c < 10; c++)
         {
            System.out.print(a1[r][c]+" ");
            
         }
            System.out.println();
      } 
      
      int temp;
      int r1=0;
      for(int rr = a1.length-1; rr >=0; rr--)
      {
      
       for(int c = 0; c < 10; c++)
         {
            temp = a1[rr][c];       // using a temp variable to store values in order to swicth the values in rows
            a1[rr][c] = a1[r1][c];
            a1[r1][c] = temp;
            
         }
      }
      r1++;
     
      System.out.println("\nNow the switched row values of the array");
      for(int r = 0; r < 2; r++)
      {
       for(int c = 0; c < 10; c++)
         {
            System.out.print(a1[r][c]+" ");
            
         }
            System.out.println();
      }
      
      
      
   }
}
