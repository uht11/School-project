//********************************************************************
//  StaffMember.java       Author: Lewis/Loftus
//
//  Represents a generic staff member.
//********************************************************************

public class StaffMember
{
   protected String name;
   protected String address;
   protected String phone;
   protected String SocialSec;
   protected Double Rate;

   //-----------------------------------------------------------------
   //  Constructor: Sets up this staff member using the specified
   //  information.
   //-----------------------------------------------------------------
   public StaffMember() {
   
   }
   
      
    public void SetStaffMember (String eName, String eAddress, String ePhone, String eSocialSec, Double eRate)
   {
      name = eName;
      address = eAddress;
      phone = ePhone;
      SocialSec = eSocialSec;
      Rate = eRate;
   }

   public String getEmployeeId()
	{
		return SocialSec;
	}

   //-----------------------------------------------------------------
   //  Returns a string including the basic employee information.
   //-----------------------------------------------------------------
   public String toString()
   {
      String result = "Name: " + name + "\n";

      result += "Address: " + address + "\n";
      result += "Phone: " + phone;

      return result;
   }

   //-----------------------------------------------------------------
   //  Derived classes must define the pay method for each type of
   //  employee.
   //-----------------------------------------------------------------

}
