public class ProwerFunction

{


double method1(double x, int n)  // x is the base and n is the exponent
   {
    if (n == 0)                          // n = 0 is base part of recursive
         return 1.0;
    if (n % 2 == 1) // n is odd
         {
            double y = method1(x, (n - 1) / 2);
            return x * y * y;
         } 
    else 
         {
                  double y = method1(x, n / 2);
              return y * y;
          }
   }
 
double method2(double x, int n)  // x is the base and n is the exponent
   {
      double ans = 1;   
   
      for(int i = n; i > 0; i--)
      {
         ans = ans * x;
      }
   
      return ans;    
   }

}