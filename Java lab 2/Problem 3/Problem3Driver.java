import java.util.*;
public class Problem3Driver
{
   public static void main(String args[])
   {
   
    
    
    Scanner input = new Scanner(System.in);
    
    
      int number = 0;
      boolean temp = true;

      OEFactorial AA = new OEFactorial();      

          
      do  {
         //asking user for intput
          System.out.print("Please enter an integer for odd/even factorial: ");
          // try and catch statement to catch user input mismatch exceptions
            try
               {
               number = input.nextInt();
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
      
       System.out.println(number+"!! = "+AA.oddevenfact(number));
          
   }
}