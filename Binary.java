  import java.util.*;
   class Binary
{  public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   int num,j=15;
   int a[]=new int[20];
   System.out.println("Enter number to convert into binary");
   num=sc.nextInt();
    int n=num;
   while(num>1)
  { a[j]=num%2;
    num=num/2;
    j--;
  }
   a[j]=1;
   System.out.println("Binary of "+n+" is");
   for(;j<=15;j++)
  { System.out.print(" "+a[j]);
  }
 }
}
   
  