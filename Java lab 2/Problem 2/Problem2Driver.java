import java.util.*;
public class Problem2Driver
{
   public static void main(String args[])
   {
   
    boolean temp = true;
    int base = 0;
    int exp  = 0;
    
    Scanner input = new Scanner(System.in);
    
    do  {
    
         try
               {
               System.out.print("Please enter an integer base: ");
               base = input.nextInt();
               temp = true;  //if the user enters a valid input then the loop stops and moves to the next statement 
               }
         catch(InputMismatchException e)    
               {
               System.out.println("Your input is invalid, please try again");  // tells user input is wrong
               temp = false;     //makes the condition false so the loop keeps running
               input.next();        //clears the scanner values
               }
         }
    while(!temp);
    
    do  {
    
         try
               {
               System.out.print("Plase enter an integer exponent: ");
               exp  = input.nextInt();
               temp = true;  //if the user enters a valid input then the loop stops and moves to the next statement 
               }
         catch(InputMismatchException e)    
               {
               System.out.println("Your input is invalid, please try again");  // tells user input is wrong
               temp = false;     //makes the condition false so the loop keeps running
               input.next();        //clears the scanner values
               }
         }
    while(!temp);
    
    
      ProwerFunction AA = new ProwerFunction();      
      
      
      long start1 = System.nanoTime();
         System.out.println("Method 1: "+base+" to the power of "+exp+" = "+AA.method1(base, exp) );     // Recursion Method
      long end1 = System.nanoTime() - start1;
      
      long start2 = System.nanoTime();
         System.out.println("Method 2: "+base+" to the power of "+exp+" = "+AA.method2(base, exp) );      // Loop method
      long end2 = System.nanoTime() - start2;
      
      System.out.println("Method 1 time: "+end1+" nanoseconds\nMethod 2 time:"+end2+" nanoseconds");
          
   }
}