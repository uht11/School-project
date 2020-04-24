
public class Test11{
public static void main (String [] args) throws Exception {
File file = new File("in.txt");
Scanner sc = new Scanner(file);
String input = sc.next();
Stack<Integer> calc = new Stack<Integer>();
while(sc.hasNext()){
for(int i = 0; i < input.length(); i++){
    char c = input.charAt(i);
    int x = 0;
    int y = 0;
    int r = 0;
    if(Character.isDigit(c)){
       int t = Character.getNumericValue(c);
        calc.push(t);
    }
    else if(c == '+'){
        x = calc.pop();
        y = calc.pop();
        r = x+y;
        calc.push(r);
    }
     else if(c == '-'){
        x = calc.pop();
        y = calc.pop();
        r = x-y;
        calc.push(r);
    }
     else if(c == '*'){
        x = calc.pop();
        y = calc.pop();
        r = x*y;
        calc.push(r);
    }
     else if(c == '/'){
        x = calc.pop();
        y = calc.pop();
        r = x/y;
        calc.push(r);
    }
}
 }
 int a = calc.pop();
System.out.println(a);
 }
 } 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 //Uzzul Hussain
//CS 114 - 002


//This program only checks parenthasis
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;
public class Problem3Driver 
{

public static void main(String[] args) throws FileNotFoundException 
{    
   Stack<Integer> ostk = new Stack<Integer>();
   Stack<Integer> ostk2 = new Stack<Integer>();
   Stack<Integer> ostk3 = new Stack<Integer>();
   Stack<String> astk = new Stack<String>();
   Stack<String> astk2 = new Stack<String>();
   StringTokenizer st;
   Scanner s1 = new Scanner(System.in);
   
   
   



   System.out.print("Enter a postFix expression: ");
   String input = s1.nextLine();
   


   st = new StringTokenizer(input);
   
   while(st.hasMoreTokens())
   {  
   String temp = st.nextToken(" ");
      
      
      
      if (temp.equals("+") || temp.equals("-") ||temp.equals("/") ||temp.equals("*"))
         {
            astk.push(temp);
         }
       else
       {
          ostk.push(Integer.valueOf(temp));
       }
   }
   
   while(!ostk.empty())
    {
      ostk2.push(ostk.pop());
      
    }
       while(!astk.empty())
    {
      astk2.push(astk.pop());

    }
  int ans = 0; 
while(true)
{//sts
   
   String opa = astk2.pop();

   if (opa.equals("+"))
   {
   ans = ostk2.pop() + ostk2.pop();
   }
   if (opa.equals("-"))
   {
   ans = (ostk2.pop() - ostk2.pop());
   }
   if (opa.equals("*"))
   {
   ans = ostk2.pop() * ostk2.pop();
   }
   if (opa.equals("/"))
   {
   ans = ostk2.pop() / ostk2.pop();
   }
   
   ostk2.push(ans);
   
   
   while(!ostk2.empty()){ostk.push(ostk2.pop());}
   
   while(!ostk.empty()){ostk3.push(ostk.pop());}
   
   while(!ostk3.empty()){ostk2.push(ostk3.pop());}

 
   astk.clear();
   
      while(!astk2.empty())
    {
      astk.push(astk2.pop());
    }
    astk2 = astk;
  
   System.out.println(ans+"xxx");
}//end of expression
   
  //s1.reset();
  

}//end of main



}//end pf class