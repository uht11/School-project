//Uzzul Hussain
//CS 114 - 002


import java.util.*;
import java.io.*;
public class StaffManagement
{

public static void main(String[] args) throws FileNotFoundException 
   {
	
	Scanner userIN = new Scanner(System.in);
	String tempKey = "";
	HashMap hashmap = new HashMap();
	Staff st = new Staff();
	for(int i=0; i<6; i++){
		StaffMember staffM = st.getStaff(i);
		hashmap.put(staffM.getEmployeeId(), staffM);
		
	}
	
	
	//interactive searches
	do{
	System.out.print("Enter a SSN (include \"-\" ) to view employee information (DONE to quit): ");
	tempKey = userIN.nextLine();
	if(tempKey.equalsIgnoreCase("DONE")){break;}
	if(hashmap.get(tempKey) == null)
		System.out.println("----Sorry employee with this SSN not found----");
	else
	{
		System.out.println(hashmap.get(tempKey).toString());
	}
	} while (true);
	
   }
}