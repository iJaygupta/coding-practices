import java.util.Scanner;
 class Secmin
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("enter the size of array");
   int n=sc.nextInt();
   int a[]=new int[40];
   int i;
  System.out.println("Enter "+n+" elements"); 
  for(i=0;i<n;i++)
 { a[i]=sc.nextInt();
  }
  int temp=32767;
  int min=a[0];
  for(i=1;i<n;i++)
{ if(a[i]<min)
 { temp=min;
   min=a[i]; 
 }
 else
{ if(a[i]<temp)
  {temp=a[i]; 
   }
  }
}
  System.out.println("Second Minimum element of list is "+temp);
}
}