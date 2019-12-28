import java.util.Scanner;
 public class Removedublicates
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the size of array");
   int n=sc.nextInt();
   System.out.println("Enter the elements");
   int A[]=new int[n];
   for(int i=0;i<n;i++)
  { A[i]=sc.nextInt();
   }
   int c=0;
  for(int i=0;i<n-1;i++)
 { for(int j=i+1;j<n;)
  { if(A[i]==A[j])
   { for(int k=j;k<n-1;k++)
     { A[k]=A[k+1];
     }
    n--;
   }
   else
  {  j++;
   }
  }
 }
 System.out.println("After Deleting Dublicates");
 System.out.println("Final array is");
 for(int i=0;i<n;i++) 
 { System.out.print(A[i]+" ");
  }
}
} 
  






