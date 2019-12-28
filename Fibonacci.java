 import java.util.Scanner;
 public class Fibonacci
{ public static void main(String args[])
 {  Scanner sc=new Scanner(System.in);
    System.out.println("Enter the limit");
    int n=sc.nextInt();
    int temp=1,num=1;
    int temp1;
    System.out.print(1+" "+1+" ");
    while(num<=n)
   {  temp1=temp;
      temp=num;
      num=temp1+num;
      System.out.print(num+" ");           
   }
 }
}