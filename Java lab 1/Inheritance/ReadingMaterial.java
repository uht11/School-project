/*import java.util.Scanner;
public class apples {

    public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    tuna tunaObject = new tuna();
    System.out.println("enter input:");
    
    String temp = input.nextLine();
    tunaObject.setName(temp);
    tunaObject.saying();
    }
    
}*/

public class ReadingMaterial
{
   public String title;
   public String author;
   public int numPages;
   
   public ReadingMaterial(String t, String a, int num)
   {
   title = t;
   author = a;
   numPages = num;
   }
   
   public boolean isLong()
   {
      if(numPages > 250)
      {
      return true;
      }
      return false;
   }
   
   public void summary()
   {
      System.out.println(title+", written by "+author+".");
   }
}


