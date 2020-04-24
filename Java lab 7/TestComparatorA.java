//Uzzul Hussain
//CS 114 - 002
//Problem 2
import java.util.Comparator;

public class TestComparatorA 
{  public static void main(String[] args) 
{     Shape g1 = new Rectangle(20, 5); 
      Shape g2 = new Circle(6);    
      Shape g = max(g1, g2, new ShapeObjectComparator());  

      System.out.println("The perimeter of the object is " + g.computePerimeter());
      
}   

 public static Shape max(Shape g1, Shape g2, Comparator<Shape> c)
 {    if (c.compare(g1, g2) > 0) 
          {   
           if (g1 instanceof Rectangle )
           System.out.println("Object Rectangle is larger ");
           else
           System.out.println("Object Circle is larger ");
             
           return g1;    
          }
        else 
        { 
          if (g2 instanceof Rectangle )
           System.out.println("Object Rectangle is larger ");
           else
           System.out.println("Object Circle is larger ");
    
          return g2;  
          
        }
   }
          

}
