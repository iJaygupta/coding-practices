  import java.util.Scanner;
 public class BinarySearch
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the size of array"); 
   int n=sc.nextInt();
   int a[]=new int[n]; 
   System.out.println("Enter the elements of array");
   for(int i=0;i<n;i++)
  {  a[i]=sc.nextInt();
   }
  System.out.println("Enter Elemnet to Search");
  int key=sc.nextInt();
  int i=0;
  int j=n-1;
  int mid=0;
  while(i<=j)
 {  mid=(i+j)/2; 
     if(key<a[mid])
    {    j=mid-1;
      }
      else if(key>a[mid])
     {  i=mid+1;
        
     }
     if(a[mid]==key)
      { System.out.println(a[mid]+" found at "+mid+"th index");
        System.exit(0); 
      }
 }
 System.out.println("Element Not Present");
}
}   