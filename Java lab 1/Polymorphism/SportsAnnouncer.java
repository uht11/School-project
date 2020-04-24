public class SportsAnnouncer implements Speaker 
{
   
   public void speak()
   {
      System.out.println("Goal!");
   }
   
   public void announce(String  str)
   {
      System.out.println("The "+str+" have scored a goal!");
   }
   
}