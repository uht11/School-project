//********************************************************************
//  Staff.java      
//
//  Represents the personnel staff of a particular business.
//********************************************************************

public class Staff
{
   public StaffMember[] staffList = null;

   //-----------------------------------------------------------------
   //  Constructor: Sets up the list of staff members.
   //-----------------------------------------------------------------
   public Staff ()
   {
      staffList = new StaffMember[6];
      staffList[0] = new StaffMember();
      staffList[0].SetStaffMember("Sam", "123 Main Line","555-0469", "123-45-6789", 2423.07);
      staffList[1] = new StaffMember();
      staffList[1].SetStaffMember ("Carla", "456 Off Line", "555-0101", "987-65-4321", 1246.15);
      staffList[2] = new StaffMember();
      staffList[2].SetStaffMember ("Woody", "789 Off Rocker","555-0000", "010-20-3040", 1169.23);
      staffList[3] = new StaffMember();
      staffList[3].SetStaffMember("Diane", "678 Fifth Ave.","555-0690", "958-47-3625", 1001.55);
      staffList[4] = new StaffMember();
      staffList[4].SetStaffMember ("Norm", "987 Suds Blvd.","555-8374","456-78-9000", 1100.2);
      staffList[5] = new StaffMember();  
      staffList[5].SetStaffMember("Cliff", "321 Duds Lane","555-7282","110-222-1111",2221.0);
         
      
   }

     
   public StaffMember getStaff(int i)
   {
	 StaffMember st =  staffList[i];
	 return st;
   }
   
   public int getSize()
   {
	  int sz = staffList.length;
	  return sz;
   
   }
  
 }

