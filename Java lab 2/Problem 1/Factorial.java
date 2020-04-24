public class Factorial 
{

public int myMethod( int integer)
{
if( integer == 1 || integer == 0)    // end statement
     return 1;
else
       { 
       return(integer*(myMethod(integer-1)));  //calls the method itself; where recursion happens 
       }
}




}
