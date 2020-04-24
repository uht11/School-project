//Uzzul Hussain
//CS 114 - 002


import java.util.*;
public class Problem2Driver 
{

    public static void main(String[] args) 
    {
      String nameR;
      Scanner s1 = new Scanner(System.in);
      Staff     sObj = new Staff();
      
      
      ArrayList <StaffMember> employeeList = new ArrayList<StaffMember>();
      for(int x =0; x < sObj.getSize(); x++)
      {
         employeeList.add(sObj.getStaff(x));
         
      }
      
do{      
      for(int x =0; x < employeeList.size(); x++)
      {
         System.out.println(employeeList.get(x));
         if(employeeList.get(x) instanceof Executive)
         {System.out.println("Executive\n");}
         else if(employeeList.get(x) instanceof Employee)
         {System.out.println("Employee\n");}
         else if(employeeList.get(x) instanceof Hourly)
         {System.out.println("Hourly\n");}
         else if(employeeList.get(x) instanceof Volunteer)
         {System.out.println("Volunteer\n");}
         
      } 
          

     System.out.println("Enter \"Exit\" to stop removing values; The program will also stop when no element is left in the list."); 
     do
     {   
         boolean ifremoved = false;
         System.out.print("Enter a Emplyee Name to be removed from the list: ");
         nameR = s1.nextLine(); 
         
         
         

         if(nameR.equals("exit") || nameR.equals("Exit"))
         {
         
         System.out.println("User stopped removing employees");
         break;
         }
        
         for(int x =0; x < employeeList.size(); x++)
      {  
               
         if((employeeList.get(x).name).equals(nameR))
         {
          if(employeeList.get(x) instanceof Executive)
         {
         System.out.println("Executive Employee can't remove!");
         ifremoved = true;
         break;
         }
         else
         {
            ifremoved = true;
            employeeList.remove(x);
            System.out.println("Employee "+nameR+" has been removed."); break;
         }
         }
      }//end of for loop
       
       

        
        if(!ifremoved)  // if the element not fount tells the user its not there
        {
         System.out.println("Employee "+nameR+" is not in the List.");
         
        }
        
        s1.reset(); //resets scanner to get new values
                
        
      }while(employeeList.size() != 0);
      if(employeeList.size() == 0){System.out.println("List is empty");}
      
      System.out.println("Enter \"Exit\" to stop removing values; The program will also stop when no element is left in the list.");
      do{
      boolean found = false;
      System.out.print("Enter a Emplyee Name to edit their address: ");
      nameR = s1.nextLine();
      
      if(nameR.equals("exit") || nameR.equals("Exit"))
         {
         
         System.out.println("User stopped editing\n");
         break;
         }


      
      for(int x =0; x < employeeList.size(); x++)
      {  
      if((employeeList.get(x).name).equals(nameR))
         {s1.reset();
         System.out.print("Enter new address: ");
         String add = s1.nextLine();
         
         employeeList.get(x).address = add;
         System.out.println(employeeList.get(x));
         found = true;
         break;
         }
         
      }//end of loop
        
        if(!found) {
        System.out.println("Employee not found!");
        }
      
      }while(true);
      
      // ASK THE USER TO EXIT OR REPEAT THE PROGRAM 
      System.out.println("YOU CAN EXIT THE PROGRAM BY TYPNG EXIT NOW: ");
      String end = s1.nextLine();
      if(end.equals("exit") || end.equals("Exit"))
         {
         System.out.println("User stopped the program, Good Bye!");
         break;
         }  
         
//KEEPS THE PROGRAM REPEATING
}while(true); 
      

      for(int x =0; x < employeeList.size(); x++)
      {
         System.out.println(sObj.getStaff(x));
         if(employeeList.get(x) instanceof Executive)
         {System.out.println("Executive\n");}
         else if(employeeList.get(x) instanceof Employee)
         {System.out.println("Employee\n");}
         else if(employeeList.get(x) instanceof Hourly)
         {System.out.println("Hourly\n");}
         else if(employeeList.get(x) instanceof Volunteer)
         {System.out.println("Volunteer\n");}
         
      } 
  
      
      
    }
}