import java.util.Scanner;
 public class Zigzag
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the size of array");
   int n=sc.nextInt(); 
   System.out.println("Enter the elements of array");
   int a[]=new int[n]; int temp;
   for(int i=0;i<n;i++)
  {   a[i]=sc.nextInt(); }
   for(int i=0;i<n-1;i++)
  {  for(int j=i+1;j<n;j++)
    {  if(a[j]<a[i])
      {  temp =a[j];
         a[j]=a[i];
         a[i]=temp;
       }
    }
   }
   for(int i=1;i<n;i=i+2)
  {  temp=a[i];
     a[i]=a[i+1];
     a[i+1]=temp;
   }
System.out.println("The Zig Zag Pattern of Array is");
   for(int i=0;i<n;i++)
  {  System.out.print(a[i]+" "); }
 }
}  
   
   
   