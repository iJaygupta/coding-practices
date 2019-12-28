  import java.util.Scanner;
  public class Sumsubarray
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter size of Array");
   int n=sc.nextInt();
   int temp;
   int A[]=new int[n];
   System.out.println("Enter the element");
   for(int i=0;i<n;i++)
  { A[i]=sc.nextInt();
   }
    System.out.println("Enter the Value of Sum");
    int sum=sc.nextInt();
   System.out.println("Sub Array with Given Sum is");
   for(int i=0;i<n-1;i++)
  {  temp=A[i];
     if(temp==sum)
     {   System.out.println("Sum found at "+i);
      }
    for(int j=i+1;j<n;j++)
   { if(temp<sum)
   {  temp=temp+A[j];
      if(temp==sum)
     { System.out.print("Sum found between "+i+"and"+j);
       }
     else if(temp>sum)
   { temp=temp-A[j];
   }
   }
  }
  }
    
}
}     
   
   
        
      