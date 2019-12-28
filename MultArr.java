import java.util.Scanner;
 public class MultArr
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the row and col of array1");
   int r1=sc.nextInt();
   int c1=sc.nextInt();
   System.out.println("Enter the row and col of array2");
   int r2=sc.nextInt();int sum=0;
   int c2=sc.nextInt();
   if(c1!=r2)
  {  System.out.println("Multiplication not possible");
     System.exit(0);
   }
   int a1[][]=new int[r1][c1];
   System.out.println("enter elements of arr1");
   for(int i=0;i<r1;i++)
 { for(int j=0;j<c1;j++)
  { a1[i][j]=sc.nextInt();
   }
 }
     System.out.println("enter elements of arr2");
    int a2[][]=new int[r1][c1];
   for(int i=0;i<r2;i++)
 { for(int j=0;j<c2;j++)
  { a2[i][j]=sc.nextInt();
   }
 }
   int c[][]=new int[r1][c2];
   for(int i=0;i<r1;i++)
 { for(int j=0;j<c2;j++)
  { 
    for(int k=0;k<c1;k++)
    {
    sum+=(a2[i][k]*a2[k][j]);
    }
     c[i][j]=sum;
     sum=0;
   }
 }
for(int i=0;i<r1;i++)
 { for(int j=0;j<c2;j++)
  { System.out.print("  "+c[i][j]);
   }
    System.out.println();
 }
}
}

