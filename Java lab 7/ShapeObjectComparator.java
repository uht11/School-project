//Uzzul Hussain
//CS 114 - 002
//Problem 2
import java.util.Comparator;

public class ShapeObjectComparator  
implements Comparator<Shape>, java.io.Serializable 
{ 
  public int compare(Shape o1, Shape o2) 
   {    
   double perimeter1 = o1.computePerimeter();   
   double perimeter2 = o2.computePerimeter();   
   if (perimeter1 < perimeter2)      
         {return -1;}    
   else
   {
   if (perimeter1 == perimeter2)      
         {return 0;}    
   else      
         {return 1;} 
   }
 }
 
 }
