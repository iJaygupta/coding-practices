import java.util.*;
  class Palcheck
{ public static void main(String args[])
{ Scanner sc=new Scanner(System.in);
  System.out.println("Enter number to check");
  int num=sc.nextInt();
  int m=num;
  int n=0;
  while(num>0)
 {  n=num%10+n*10;
    num=num/10;
 }
 if(n==m)
 { System.out.println(m+"is pallindrome");
  }
 else
 { System.out.println(m+"is not pallindrome");
  }
 }
}
