//Uzzul Hussain
//CS 114 - 002


import java.lang.Comparable;
import java.util.*;
import java.io.*;
public class Problem1Driver
{

public static void main(String[] args) throws FileNotFoundException 
   {
   
   BST bst = new BST(); //original BST
   File file = new File ("inventory.txt");
   Scanner scan = new Scanner(file);
   Scanner userIN = new Scanner(System.in);
   StringTree st = new StringTree();
   String tempKey;   int x=0;


   while( scan.hasNextLine() ) {
   
      tempKey = scan.nextLine();
      bst.insert(tempKey, tempKey);
      st.addString(tempKey);
      
      }//EOW
      System.out.println("----Tree loaded----");
   
      //binary search
      System.out.print("Enter a part number to find in the tree: ");
      tempKey = userIN.nextLine();
      if(bst.find(tempKey) == null){System.out.println("Part not found!");}
      else System.out.println("Search result: "+bst.find(tempKey));
      
      //Display inorder, postorder and preorder of the tree.
      System.out.println("In order print:");
      System.out.println(bst.toString(0));
      System.out.println("Post order print:");
      System.out.println(bst.toString(1));
      System.out.println("Pre order print:");
      System.out.println(bst.toString(5));
      
      
      //deleting a node
      System.out.print("Enter a part number to delet from tree: ");
      tempKey = userIN.nextLine();
      if(bst.remove(tempKey) == null){System.out.println("Part not found!");}
      else System.out.println("Part "+tempKey+" deleted");
      
      //Display inorder
      System.out.println("In order print after deletion:");
      System.out.println(bst.toString(0));
      
      //inserting new part
      System.out.print("Enter a part number to add to the tree: ");
      tempKey = userIN.nextLine();
      bst.insert(tempKey, tempKey);
      
      //Display inorder
      System.out.println("In order print after adding:");
      System.out.println(bst.toString(0));
     
      //Calling printRang method
      System.out.print("Enter first parts for range print: ");
      tempKey = userIN.nextLine();
      System.out.print("Enter second parts number: ");
      bst.printRang(bst.getRoot(),tempKey, userIN.nextLine());
      
      //part 3
      System.out.println("\n****Part 3: Traverse with Stack.****");
      System.out.println("----Traversed inorder result----");
      st.traverseWithStack(); //traverse with stack


      
}}//end



     