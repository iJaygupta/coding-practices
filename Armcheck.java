 import java.util.*;
  class Armcheck
{ public static void main(String args[])
{ Scanner sc=new Scanner(System.in);
  System.out.println("Enter the range for armstrong number");
  int num=sc.nextInt();
  int temp,res;
  int fin;
  for(int i=1;i<=num;i++)
{  temp=i;
   fin=0;
   while(temp>0)
 { res=temp%10;
   fin=fin+(res*res*res);
   temp=temp/10;
  }
 if(fin==i)
{  System.out.println(fin+" is armstrong");
}
}
}
}

  






 