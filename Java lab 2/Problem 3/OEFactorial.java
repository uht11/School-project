public class OEFactorial

{


public long oddevenfact(int integer)  // x is the base and n is the exponent
   {
      if( integer < 1 )    // end statement
      return 1;
      else
      { 
      return(integer*(oddevenfact(integer-2)));  //calls the method itself; where recursion happens... -2 because it will only multiply via odd or even
      }  
      
   }
 


}