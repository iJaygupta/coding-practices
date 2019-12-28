  import java.util.Scanner;
  public class Code
{ public static void main(String args[])
 { int k=0;int n=3;
   int j=3;
   for(int i=2;i<=n;i++)
  {  if(n%i==0)
    { k++; i=1; j=n; n++;
     }
   if((k==0)&&(i==(j-1)))
   { System.out.println(n+" is prime");
     i=1; j=n; n++; 
   }
   else if((k!=0)&& (j==(n-1)))
    {  k=0;
     }
   if(n==101)
  { System.exit(0);
   }
  }
 
}
} 