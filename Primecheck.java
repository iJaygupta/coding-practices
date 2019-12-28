  import java.util.Scanner;
  public class Primecheck
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the Number");
   int n=sc.nextInt();
   int k=0;
   if(n<=1)
 {  System.out.println(n+" is not prime");
    System.exit(0);
 }  
   for(int i=2;i<=n/2;i++)
  {  if(n%i==0)
    { System.out.println(n+" is not Prime");
      System.exit(0);
     }
  }
  if(k==0)
 { System.out.println(n+" is prime");
  }
 }
}
  