 import java.util.Scanner;
 public class Hard
{ public static void main(String str[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter size of array");
   int n=sc.nextInt();
   System.out.println("Enter elements of array");
   int a[]=new int[n];
   for(int i=0;i<n;i++)
  { a[i]=sc.nextInt();
   }
  int x1,y1;
  int num,bum,key,temp;
  for(int i=0;i<n-1;i++)
{  
  for(int j=i+1;j<n;j++)
 { key=i;
   num=a[i]; 
   while(num>0)
 { x1=num%10;
   num=num/10;
   bum=a[j];
   while(bum>0)
  { y1=bum%10;
    bum=bum/10;
    if(x1>y1)
   {  key=i;
    }
   else if(y1>x1)
   {  key=j;
    }
   else
  {  if(key==i)
   {  key=i;
    }
   else if(key==j)
   {  key=j;
    }
  }
  } 
 }
 if(key==j)
 { temp=a[j];
   a[j]=a[i];
   a[i]=temp;
 }
}
}
System.out.println("The Largest no formed from Array is");
System.out.print("      ");
   for(int i=0;i<n;i++)
  {  System.out.print(a[i]); }
}
}
