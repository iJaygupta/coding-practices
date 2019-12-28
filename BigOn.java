import java.util.Scanner;
 public class BigOn
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the size of array");
   int n=sc.nextInt(); 
   System.out.println("Enter the elements of array");
   int a[]=new int[n]; int temp;
   for(int i=0;i<n;i++)
  {   a[i]=sc.nextInt(); }
   
   for(int i=0;i<n-1;i++)
  {  if(i%2==0)
    { if(a[i]>a[i+1]) 
      {temp=a[i];
       a[i]=a[i+1];
       a[i+1]=temp;
      }
    }
    else
    {  if(a[i]<a[i+1]) 
      {temp=a[i];
       a[i]=a[i+1];
       a[i+1]=temp;
      }
    }
}
System.out.println("The Zig Zag Pattern of Array is");
   for(int i=0;i<n;i++)
  {  System.out.print(a[i]+" "); }
 }
}  
   
   
   