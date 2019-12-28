 import java.util.*;
 class Secmax 
{  public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   int a[]=new int [20];
   System.out.println("Enter Size");
   int n=sc.nextInt();
   System.out.println("Enter Numbers");
   for(int i=0;i<n;i++)
 { a[i]=sc.nextInt();
  }
   int temp=0;
  int max=a[0];
  for(int i=1;i<n;i++)
 { if(a[i]>max)
   { temp=max;
     max=a[i];
   }
   else
  { if(a[i]>temp)
   { temp=a[i];
   }
  }
 }
  System.out.println("Second maximum value is:"+temp);
}  
}