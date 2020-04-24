//Uzzul Hussain
//CS 114 - 002


//This program only checks parenthasis

import java.util.*;
import java.io.*;
public class Problem1Driver 
{

public static void main(String[] args) throws FileNotFoundException 
{    
    int templen = 0;
    File file= new File("test.dat");
    Scanner scan = new Scanner(file);
    LStack stk = new LStack();
    LStack backup = new LStack();
    StackTokenTest st = new StackTokenTest();
    
    //reading the test.dat file
    do{
      String input = scan.nextLine();
      stk.push(input);
      
     
    }while(scan.hasNextLine());
    
    //Part A
    //first in last out printing
    while(0 != stk.length())
    {
      backup.push(stk.topValue());        //backup stack to save the values 
      
      System.out.println(stk.pop());

    }
    System.out.println("Size of the Stack is: "+backup.length());
    System.out.println("\nChecking parenthesis in the Lines!\n");
    
    
    
    //Part B
    templen = backup.length();
    while(stk.length() < templen)
    {
    System.out.println(st.isValid(backup.topValue().toString()));
    stk.push(backup.pop());
   
    }
    
    
    
       

}//end of main
}//end pf class