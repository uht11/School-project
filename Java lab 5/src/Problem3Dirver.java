import java.util.Stack;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class Problem3Dirver {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    for (;;) {
   
     System.out.print("Enter \"Exit\" to stop; Enter a postFix expression: ");
      String s = in.readLine();
     if(s.equals("exit") || s.equals("Exit"))
         {
         System.out.println("User stopped!");
         break;
         }
      
      if (s==null) break;
      Stack<String> tks = new Stack<String>();
      tks.addAll(Arrays.asList(s.trim().split("[ \t]+")));
      if (tks.peek().equals("")) continue;
      try {
        double r = evalrpn(tks);
        if (!tks.empty()) throw new Exception();
        System.out.println(r);
      }
      catch (Exception e) {System.out.println("error");}
    }
  }

  private static double evalrpn(Stack<String> tks) throws Exception {
    String tk = tks.pop();
    double x,y;
    try {x = Double.parseDouble(tk);}
    catch (Exception e) {
      y = evalrpn(tks);  x = evalrpn(tks);
      if      (tk.equals("+"))  x += y;
      else if (tk.equals("-"))  x -= y;
      else if (tk.equals("*"))  x *= y;
      else if (tk.equals("/"))  x /= y;
      else throw new Exception();
    }
    return x;
  }
}