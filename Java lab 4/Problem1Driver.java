//Uzzul Hussain
//CS 114 - 002


import java.util.*;
import java.io.*;
public class Problem1Driver 
{

public static void main(String[] args) throws FileNotFoundException 
{    
   
    File file= new File("test.dat");
    //System.out.println(file.exists());
    Scanner scan = new Scanner(file);
    LList ll = new LList();

   //reading the test.dat file
    do{
      int input = scan.nextInt();
      ll.append(input); //filling list with file values 
      
    }while(scan.hasNextInt());
    
    ll.moveToStart();
    DLink dl = new DLink(ll.getValue(), null,null);
    DLink head = dl;   // keeps hold of the first node
    
    int size = 0;
      
     //fillinf values in side DLink
     while(ll.curr.next() != null){
      ll.next();
      size++;
      dl.setNext(new DLink(ll.getValue(), dl, null)); //sets next node
      dl.next().setPrev(dl);                          //sets previous for next node
      dl = dl.next();                                
      }
      
      
      dl = head;
      // printing values from dlink
      System.out.print("values inside DLink: ");
      for(int x = 0; x < ll.cnt; x++)
      {
         System.out.print(dl.element()+" ");
         dl= dl.next();
      }
      System.out.println("\nsize of the list: "+size);
      
      
      System.out.print("Fifth values on the list is: ");
      dl = head;
      for(int x=1;x<5;x++)
      {
         dl=dl.next();      //using next methjod to go to the fifth node
      }
      System.out.println(dl.element());


         //allowes the user to remove the elements from the dlist
         Scanner s1 = new Scanner(System.in);
         System.out.println("If no records remain program will exit!\nEnter -1 to stop.");
     do
     {   
         System.out.print("Enter a interger to be removed from the record: ");
         
         int num = s1.nextInt();
         boolean ifFound = false;
         if(num == -1)
         {
         System.out.println("User stopped removing records");
         break;
         }
         
         
         
         dl = head;
         while(dl.next() != null)
       {
         if (dl.element().equals(num)) // checks if user input and records are same
         {  
            if(head.element().equals(num))  //checks if its the first node
            { 
              head = dl.next();
              System.out.println("The record "+ num +" has been removed.");
              ifFound = true;
              size--;
              break;
            }
            
            
            DLink temp = dl.next();
            dl.prev().setNext(temp);
            System.out.println("The record "+ num +" has been removed.");
            ifFound = true;
            size = size-1;
             dl = dl.next(); 
            break;
         }
          dl = dl.next(); 
              
        
        }//end of for loop
        
        
        if(!ifFound)  // if the element not fount tells the user its not there
        {
         System.out.println((num)+" is not in the record.");
        }
        
        s1.reset(); //resets scanner to get new values
                
        
      }while(head.next()!=null) ;
      if(head.next()==null){System.out.println("No records left!!");System.out.println("\nsize of the list: "+size);}
      else{
      dl = head;
      // printing values from dlink
/*
for checking values
      
      while(dl.element() != null)
      {
         System.out.print(dl.element()+" ");
         dl= dl.next();
      }
      System.out.println("\nsize of the list: "+size);
      
*/
      }
      
      
      System.out.println("Max number of records allowed are 10!\nEnter -1 to stop");
     while(size != 10)
     {   
         System.out.print("Enter a interger to be added to the record: ");
         
         int num = s1.nextInt();
         boolean ifFound = false;
         if(num == -1)
         {
         System.out.println("User stopped removing records");
         break;
         }
         
         
         
         dl = head;
         while(dl.next() != null)
       {
         if (dl.element().equals(num)) // checks if user input and records are same
         {  
            System.out.println("The record "+ num +" already exists.");
            ifFound = true;
            
            dl = dl.next(); 
            break;
         
         }
          dl = dl.next(); 
              
        
        }//end of for loop
        
        
        if(!ifFound)  // if the element not fount tells the user its not there
        {
         dl = head;
         System.out.println((num)+" has been added to the record.");
         head = new DLink(num,null,dl);
         size++;
        }
        
        s1.reset(); //resets scanner to get new values
                
        
      }
      if(size == 10){System.out.println("List is full!!");System.out.println("size of the list: "+size);}
      else{
      
      // printing values from dlink
/*
for checking values
      dl = head;
      while(dl.element() != null)
      {
         System.out.print(dl.element()+" ");
         dl= dl.next();
      }
      System.out.println("\nsize of the list: "+size);
      
*/

         }




 //part 2
 
      System.out.print("Now printing DLink in reverse order: ");
    dl = head;
    
    int z = 1;       
    while(z < size)
    { 
     dl = dl.next();
      
      z++;
    }
    

    LList Ll = new LList();
     // starting from the last node and filling in th LList to reverse the order
    Ll.moveToStart();
     z=1;
     while(z<=size)
    {
      
      Ll.append(dl.element());
      dl = dl.prev();
      z++;
      
    }
      dl=head;
     //filling values in reverse order to DLink
    //Ll.moveToStart();
     z=1;
     
     while(z<=size){                //inputting values in reverse order from LList
     
      dl.setElement(Ll.getValue());     
      dl = dl.next(); 
      Ll.next();
      z++;                               
      }

      dl = head;
      z=1;
      while(z<=size)             //prints the values
      {
         System.out.print(dl.element()+" ");
         dl= dl.next();
         z++;
      }
      System.out.println("\nsize of the list: "+size);


    
}//end of main

}//end of program 

