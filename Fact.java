 import java.util.Scanner;
 public class Fact
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the number");
   int n=sc.nextInt();
   System.out.println(fact(n));
  }
    public static int fact(int a)
  {  if(a==0)
    { return 1;
     }
     return(a*fact(a-1));
   }
 
}