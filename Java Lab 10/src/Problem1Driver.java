//Uzzul Hussain
//CS 114 - 002


import java.util.*;
import java.io.*;
public class Problem1Driver
{

public static void main(String[] args) throws FileNotFoundException 
   {
	
	File file = new File ("inventory.txt");
	Scanner scan = new Scanner(file);
	Scanner userIN = new Scanner(System.in);
	String tempKey = "";
	HashMap hashmap = new HashMap();
	
	//Part 1
	while( scan.hasNextLine() ) 
	{
		tempKey = scan.nextLine();
		hashmap.put(tempKey,tempKey);
		
	}//EOW
	
	System.out.println("Hash Table filled, size is "+hashmap.size());
	System.out.println("------------------------------");
	System.out.print("Enter a key to remove from the Hash Table: ");
	tempKey = userIN.nextLine();
	
	if(hashmap.remove(tempKey) != null)
		System.out.println(tempKey + " removed from the table");
		
	else
		System.out.println("**Sorry the value is not found");

	System.out.println("Hash Table size: "+hashmap.size());
	
	
	
	
	
	
   }
}