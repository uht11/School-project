//*******************************************************************
//  MagazineRack.java  
//
//  Driver to exercise the MagazineList collection.
//*******************************************************************

public class MagazineRack
{
   //----------------------------------------------------------------
   //  Creates a MagazineList object, adds several magazines to the
   //  list, then prints it.
   //----------------------------------------------------------------
   public static void main (String[] args)
   {    
      MagazineList rack = new MagazineList();
      
      rack.add (new Magazine("Time"));
      System.out.println (rack.toString());
      rack.add (new Magazine("Woodworking Today"));
      System.out.println (rack.toString());
      rack.add (new Magazine("Communications of the ACM"));
       System.out.println (rack.toString());
      rack.add (new Magazine("House and Garden"));
       System.out.println (rack.toString());
      rack.add (new Magazine("GQ"));
      
      System.out.println (rack.toString()); 
   }
}
