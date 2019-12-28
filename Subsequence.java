import java.util.Scanner;
 public class Subsequence
{  public static void main(String args[])
  { Scanner sc=new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n=sc.nextInt();
    int a[]=new int[n];
    System.out.println("Enter the Elements of array");
    for(int i=0;i<n;i++)
  { a[i]=sc.nextInt();
   } int sum;
    System.out.println("Enter the desire sum");
    int given=sc.nextInt();
   for(int i=0;i<n-1;i++)
  { sum=a[i];
    for(int j=i+1;j<n;j++)
    { sum=sum+a[j];
      if(sum==given)
     { System.out.print("{ ");
       for(int q=i;q<=j;q++)
      { System.out.print(a[q]+" "); 
       }
      System.out.print("} ");
     }
    }
   }
}
}