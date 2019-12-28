    import java.util.Scanner;
    public class Sumpairarray
{   public static void main(String args[])
 {  Scanner sc=new Scanner(System.in);
    System.out.println("Enter the size of array");
    int n=sc.nextInt();
    int A[]=new int[n];
    System.out.println("Enter the elements");
    for(int i=0;i<n;i++)
  { A[i]=sc.nextInt();
   }
    System.out.println("Enter the value of sum");
    int sum=sc.nextInt();
    System.out.println("All Pairs are");
    for(int i=0;i<n-1;i++)
   { for(int j=i+1;j<n;j++)
    { if(sum==A[i]+A[j])
     { System.out.println("("+A[i]+","+A[j]+")");
      }
    }
   }
}
}
