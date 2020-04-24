//Uzzul Hussain
//CS 114 - 002
//Lab 1  2/7/16

//Problem 1 Inheritance

import java.util.*;
public class Problem1Driver {

    public static void main(String[] args) 
    {
    
      String[] aN = {"Harry Potter", "Hermione Granger", "Ronald Weasley", "Voldemort"};
      String[] aG = {"Iron Man", "Captain America", "Black Widow", "The Hulk", "Thor"};
      
      Novel harryPotter = new Novel("Harry Potter", "JK Rowling", 303, aN);
      Novel avengers = new GraphicNovel("GraphicNovel", "Stan Lee", 50, aG, "Jack Kirby");
      Article pc = new Article("The Social Meaning of the Personal Computer", "Bryan Pfaffenberger", 10, "Anthropological Quarterly");
      
      
      
      harryPotter.summary();                          //print out the summary of harryPotter
      System.out.println(harryPotter.isLong());       //the result of harryPotter's isLong function
      avengers.listCaracters();                       //characters  in avengers
      avengers.summary();                             //summary of avengers
      System.out.println(pc.isLong());                //result of pc's isLong function
      pc.summary();                                   //the summary of pc
         
      
    
    
    }

}
