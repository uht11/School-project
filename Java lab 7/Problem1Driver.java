//Uzzul Hussain
//CS 114 - 002



import java.util.*;
import java.util.LinkedList;
import java.io.*;
public class Problem1Driver 
{

public static void main(String[] args) throws FileNotFoundException 
   {
   
   //StaffMember staff = new StaffMember();
   UALdictionary dic = new UALdictionary();
   File file = new File ("test.txt");
   Scanner scan = new Scanner(file);
   Scanner userIN = new Scanner(System.in);
   String tName, tAddress, tPhone, tSSN, find = "";
   double tBank;
   
   //sets dictonary with tSSN as the key
   while(scan.hasNextLine())
   {
   String input = scan.nextLine();
   StaffMember staff = new StaffMember();
   
   String[] parts = input.split(",");        // String array helps us seperate each string into parts
   tName    = parts[0]; 
   tAddress = parts[1];
   tPhone   = parts[2];
   tSSN     = parts[3];
   tBank    = Double.parseDouble(parts[4]);  //Double.parseDouble() helps conver string to double
   
   staff.SetStaffMember(tName, tAddress, tPhone, tSSN, tBank); //setting staffmember
   dic.insert(tSSN, staff);
   }
   
   //askes user to enter SSN to remove them from dictonary
   System.out.println("****Enter exit anytime to stop removing members****"); 
   System.out.print("Enter a Social Security Number including '-' to remove from the dictonary: ");   
   find = userIN.next();
   while(!(find.toLowerCase()).equals("exit"))
   {
   
   
   
   if(null != dic.find(find))
      {
        System.out.println(dic.remove(find)+"\n!!!!!Staff has been removed!!!!!\n\n");
        if( dic.size() == 0 )
            {
            System.out.println("There are no Staff left!");
            break;
            }
      }
   else
      {
         System.out.println("Sorry such staff does not exist");
      }
   System.out.print("Enter a Social Security Number including '-' to remove from the dictonary: ");   
   find = userIN.next();
   }//EOL
   
   
   
   if((find.toLowerCase()).equals("exit"))
   {
      System.out.println("User stopped removing staff");
   }
   
   }//EOM
}//EOC