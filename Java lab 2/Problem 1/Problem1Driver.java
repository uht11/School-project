import java.util.*;
public class Problem1Driver
{
   public static void main(String args[])
   {
   
    System.out.println("***Enter 0 at anytime to exit the program***");

    
      Scanner s1 = new Scanner(System.in);
      Factorial  AA = new Factorial();
      
      int input1 = 0;
      boolean temp = true;
      

    
      do {
          
      do  {
         //asking user for intput
          System.out.print("Please enter an integer value: ");
          // try and catch statement to catch user input mismatch exceptions
            try
               {
               input1 = s1.nextInt();
               temp = true;  //if the user enters a valid input then the loop stops and moves to the next statement 
               }
            catch(InputMismatchException e)    
               {
               System.out.println("Your input is invalid, please try again");  // tells user input is wrong
               temp = false;     //makes the condition false so the loop keeps running
               s1.next();        //clears the scanner values
               }

         }
    while(!temp);
         
         System.out.println(input1+" factorial is "+AA.myMethod(input1));  //calls the Mymethod from factrioal class to do the math
         
         }
   while(input1 > 0);         
         
         System.out.println("User entered 0 , program ended! Good Bye!");
         
         
         

          
   }
}