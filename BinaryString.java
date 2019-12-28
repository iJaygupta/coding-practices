import java.util.Scanner;
 public class BinaryString
{  public static void main(String args[])
 { Scanner sc=new Scanner(System.in);  
   System.out.println("Enter a Decimal String");
   StringBuffer sb=new StringBuffer();
   sb.append(sc.nextInt());
   StringBuffer str=new StringBuffer();
   String st=""; int n;
   for(int i=0;i<sb.length();i++)
  { n=sb.charAt(i); System.out.println(n);
     while(n>0)
    {  str.append(n%2);
       n=n/2;
      System.out.println(n);
    }
     str.reverse();
     st+=str+" ";
     str=null;
  }
   System.out.println(st);
  }
}
   
    
    
      
   