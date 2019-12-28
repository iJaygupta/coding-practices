import java.util.Scanner;
 public class SelectionSort
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   int ar[]=new int[100];
   System.out.println("Enter size of array");
   int n=sc.nextInt(); int temp;
   System.out.println("Enter array elements");
   for(int i=0;i<n;i++)
 {  ar[i]=sc.nextInt();
   }
   for(int i=0;i<n;i++)
  { for(int j=i+1;j<n;j++)
    { if(ar[i]<ar[j])
      { temp=ar[i];
        ar[i]=ar[j];
        ar[j]=temp;
       }
   }
}
  for(int i=0;i<n;i++)
 {  System.out.print(ar[i]+" ");
   }
}
}  