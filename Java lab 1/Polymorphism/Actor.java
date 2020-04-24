public class Actor implements Speaker 
{
   
   public void speak()
   {
      System.out.println("I've been nominated for three Academy Awards.");
   }
   
   public void announce(String  str)
   {
      System.out.println("I'm currently staring in "+str+".");
   }
   
}