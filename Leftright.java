import java.util.Scanner;
 public class Leftright
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter size of array");
   int n=sc.nextInt();
   int s=0;
   int ar[]=new int[n];
   System.out.println("Enter Elements of array");
   for(int i=0;i<n;i++)
  { ar[i]=sc.nextInt();
   }
   int c=0;
  for(int i=1;i<n-1;i++)
 { 
   for(int k=0;k<i;k++)
  { if(ar[k]>=ar[i])
    { c++;
      break;
     }
   }
     for(int j=i+1;j<n;j++)
    {  if(ar[i]>=ar[j])
     { c++;
       break;
      }
     }
    if(c==0)
   { s++; 
    System.out.println("Element is "+ar[i]);
     
   }
   else
  {  c=0;
     
  }
}
 if(s==0)
  {  
     System.out.println("No Element found");
  }
}
}
