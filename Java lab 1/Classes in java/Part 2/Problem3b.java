//Uzzul Hussain
//CS 114 - 002
//Lab 1  2/7/16

//Problem 3 B
import java.util.*;
public class Problem3b 
{

    public static void main(String[] args) 
    {
      Scanner s1 = new Scanner(System.in);
      
      System.out.println("Please enter a string input: ");  // promptting the user for input
      String input = s1.nextLine();
      String temp = "";  // temperory variable to hold the reverted string
      
      
      for (int x = input.length()-1; x>=0 ; x--)   // loop to start counting back in order to get the last character first
      {
         temp += input.substring(x, x+1);  // getting the substring of the input starting for the last character
      }
      
      System.out.print(temp);
    }
}
