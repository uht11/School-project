//Uzzul Hussain
//CS 114 - 002


import java.util.*;
public class Problem1Driver 
{

    public static void main(String[] args) 
    {
      
      Scanner s1 = new Scanner(System.in);
    
      AList ArrList = new AList();

      int [] a = {11,4,15,20};
      int [] b = {9,3,7,22,13};
      
      for (int i : a)
      {
         ArrList.append(i); // adding the array elements to ArrayList
         
      }
      
                  
      ArrList.moveToPos(2);
      for (int i : b)
      {
         ArrList.insert(i); // adding the array elements to ArrayList
         ArrList.next();
      }
                  
                  //prints the arraylist
                  ArrList.moveToStart();
                  for(int x=0; x < ArrList.length(); x++)
                  {
         
                  System.out.print(ArrList.getValue()+" ");
                  ArrList.next();
                  }
                  System.out.println();
                  System.out.println("Length of the ArrayList: "+ArrList.length());
                  
        
        
         
         String num = "";
     
     System.out.println("Enter \"Exit\" to stop removing values; The program will also stop when no element is left in the list.");

     
     
     
     
     
     //allowes the user to remove the elements from the list
     do
     {   
         System.out.print("Enter a interger to be removed from the list: ");

         ArrList.moveToStart();
                
         num = s1.next();
         
         if(num.equals("exit") || num.equals("Exit"))
         {
         System.out.println("User stopped removing elements");
         break;
         }
         
         
         
         boolean ifFound = false;
         for(int x=0; x < ArrList.length(); x++)
       {
                      
         ArrList.moveToPos(x); // goes throught every element
         
         String value = (ArrList.getValue()).toString();

         if (value.equals( num)) // checks if user input and element are same
         {
            
            System.out.println("The element "+ ((ArrList.remove()).toString()) +" has been removed.");
            ifFound = true;

         }       
        
        }//end of for loop
        
        
        if(!ifFound)  // if the element not fount tells the user its not there
        {
         System.out.println("The element " +(num)+" is not in the ArrayList.");
        }
        
        s1.reset(); //resets scanner to get new values
                
        
      }while(ArrList.length() != 0) ;
      
      
      if(ArrList.length() == 0){System.out.println("\nThe Arraylist is empty");} //prompts the user if list is empty
      
      
      
      
      
      //loop allows the user to addd values
      while(ArrList.length() < ArrList.getMaxsize())
      {
         System.out.print("Enter a interger to be added to the beginning of the list: ");
         num = s1.next();
         
         if(num.equals("exit") || num.equals("Exit"))
         {
         System.out.print("User stopped adding elements");
         break;
         }
         
         ArrList.moveToStart();
         ArrList.insert(num);
         
         
         
        s1.reset(); //resets scanner to get new values
      }
      if(ArrList.length() == ArrList.getMaxsize()){System.out.println("ArrayList is Full, cannot add any more values");}
      
      
                  //prints the arraylist
                  ArrList.moveToStart();
                  for(int x=0; x < ArrList.length(); x++)
                  {
         
                  System.out.print(ArrList.getValue()+" ");
                  ArrList.next();
                  }
                  System.out.println();
                  System.out.println("Length of the ArrayList: "+ArrList.length());
      
                    
    }
}