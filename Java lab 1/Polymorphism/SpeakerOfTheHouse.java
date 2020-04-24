public class SpeakerOfTheHouse implements Speaker 
{
   
   public void speak()
   {
      System.out.println("I am Speaker of the House.");
   }
   
   public void announce(String  str)
   {
      System.out.println("The "+str+" has passed!");
   }
   
}