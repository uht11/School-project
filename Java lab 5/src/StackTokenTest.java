//Uzzul Hussain
//CS 114 - 002


import java.util.*;
import java.io.*;
public class StackTokenTest
{

   LStack st = new LStack();
   
   private String str;
   public StackTokenTest()
   {
   }

    //checks if parenthisis are correct 
   public String isValid(String text) 
   {
      st.clear();
      String str = "";
      int sLen = text.length();
      
      //if empty it returns empty 
      if(sLen == 0){
         return " ";}
      
      //chopping the string to only "(" ")"
      for( int x=0; x<sLen; x++)
      {
         if(text.charAt(x) == '(' || text.charAt(x) == ')') 
         {  str+=text.charAt(x); }
      }
   
      sLen = str.length();
      
      //if starts with ) or ends wiht ( invalid
      if(str.charAt(0)==')' || str.charAt(sLen-1)=='(' )
      {
         return "Invalid";
      } 
      
            
      for( int x=0; x<sLen; x++)
      {
         String tStr = ""+ str.charAt(x);
         
         if(tStr.equals("("))
         {st.push(tStr);}
         else if (tStr.equals(")"))
         { 
            if( !(st.topValue().toString().equals("(")) )
            {
               return "Invalid";}
            else
            {st.pop();}
         }
      
      }//checks over
      
      if(st.length() > 0)
      {
         return "Invalid"; }
      
      
      
      return "Valid";    
   }//EOM










   public String isValidAll(String text) 
   {
      
      
      st.clear();
      String str = "";
      int sLen = text.length();
      
      //if empty it returns empty 
      if(sLen == 0){return " ";}
      
      //chopping the string to only "(" ")"
      for( int x=0; x<sLen; x++)
      {
         if(text.charAt(x) == '(' || text.charAt(x) == ')' || text.charAt(x) == '[' || text.charAt(x) == ']' || text.charAt(x) == '{' || text.charAt(x) == '}') 
         {  str+=text.charAt(x); }
      }
   
      sLen = str.length();
      
      //if starts with ) or ends wiht ( invalid
      if(str.charAt(0)==')' || str.charAt(sLen-1)=='(' )
      {
         return "Invalid";
      } 
      
            
      for( int x=0; x<sLen; x++)
      {
         String tStr = ""+ str.charAt(x);
         
         if(tStr.equals("("))
            {st.push(tStr);}
         else if (tStr.equals(")"))
            { if( !(st.topValue().toString().equals("(")) )
                  {return "Invalid";}
               else
                  {st.pop();}
             }
             
         if (tStr.equals("{"))
            {st.push(tStr);}
         else if (tStr.equals("}"))
            { if( !(st.topValue().toString().equals("{")) )
                  {return "Invalid";}
               else
                  {st.pop();}
             }
             
         if (tStr.equals("["))
            {st.push(tStr);}
         else if (tStr.equals("]"))
            { if( !(st.topValue().toString().equals("[")) )
                  {return "Invalid";}
               else
                  {st.pop();}
             }
   
      }//checks over
      
      if(st.length() > 0)
      {return "Invalid"; }
      
      
      
   return "Valid";   
   }//EOM








}//end of class