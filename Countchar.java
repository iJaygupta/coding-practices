  import java.util.Scanner;
  public class Countchar 
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the string");
   StringBuffer str=new StringBuffer();
   str.append(sc.nextLine());
   System.out.println("Enter a character to Count");
   char c=sc.next().charAt(0);
   int count=0;
   for(int i=0;i<str.length();i++)
 { if(c==str.charAt(i))
   { count++;
    }
 }
 System.out.println("The occurence of character "+c+" is "+count);
}
} 