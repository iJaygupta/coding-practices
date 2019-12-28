 import java.util.Scanner;
 public class Maxsum
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the size of array");
   int n=sc.nextInt();
   System.out.println("Enter the elements");
   int A[]=new int[n];
   for(int i=0;i<n;i++)
 { A[i]=sc.nextInt();
  }
  int sum=0;
  System.out.print("With the numbers ( ");
  for(int i=0;i<n;i++)
{   if(A[i]>0)
   { sum=sum+A[i];
     System.out.print(A[i]+" , ");
    }
}
System.out.println(")");
System.out.println("Maximum sum will be :"+sum);
}
}

   