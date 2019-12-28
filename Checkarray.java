import java.util.Scanner;
 public class Checkarray
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter Size of array A");
   int n1=sc.nextInt();
   int A[]=new int[n1];
   System.out.println("Enter elements of array A");
   for(int i=0;i<n1;i++)
  {  A[i]=sc.nextInt();
   }
   System.out.println("Enter Size of array B");
   int n2=sc.nextInt();
   int B[]=new int[n2];
   System.out.println("Enter elements of array A");
   for(int i=0;i<n2;i++)
  {  B[i]=sc.nextInt();
   }
   int k=0;
    for(int i=0;i<n1;i++)
  {  
     for(int j=0;j<n2;j++)
    {  if(A[i]==B[j])
       { k++;
        }
     }
      if(k==0)
   { System.out.println(A[i]+" is not present in second array");
    }
    else
   {  k=0;
     }
   }  
}
}




