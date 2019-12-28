 import java.util.Scanner;
  public class Poweroftwo
{  public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter a number");
   int n=sc.nextInt();
   int num=1;
   int k=0;
  while(num<n)
 {   num=num*2;
     if(n==num)
    { System.out.println(n+" is Power of two");
      System.exit(0);
    }
 }
  if(n==1)
  { System.out.println(n+" is Power of two");
   }
  else if(k==0)
  { System.out.println(n+" is not Power of two");
  }
 }
}