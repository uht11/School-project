//Uzzul Hussain
//CS 114 - 002
//Lab 1  2/7/16

//Problem 2 Polymorphism
import java.util.*;
public class Problem2Driver 
{

    public static void main(String[] args) 
    {
    
      Scanner s1 = new Scanner(System.in);
      System.out.println("Please enter the name of a bill: ");
      String bill = s1.nextLine();
      
      System.out.println("Please enter the name of a sport team: ");
      String team = s1.nextLine();
      
      System.out.println("Please enter the name of a movie: ");
      String movie = s1.nextLine();
      
      
      //object of Speakerofthehouse class and calling tis methods
      SpeakerOfTheHouse sh = new SpeakerOfTheHouse();
      sh.speak();
      sh.announce(bill);
      
      //object of SportAnnouncer class and calling tis methods         
      SportsAnnouncer st = new SportsAnnouncer();
      st.speak();
      st.announce(team);
      
      // object of Actor class and calling tis methods
      Actor sa = new Actor();
      sa.speak();
      sa.announce(movie);
    
    }
    
}