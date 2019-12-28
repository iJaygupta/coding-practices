 import java.util.Scanner;
 class Stringpal
{  public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter the String");
   String str1=sc.next();
   String str2="";
   for(int i=str1.length()-1;i>=0;i--)
  { str2=str2+str1.charAt(i);
   }
  System.out.println("Reverse String is "+str2);
  if(str1.equals(str2))
 { System.out.println("Pallindrome");
 }
 else
 { System.out.println("Not Pallindrome");
  } 
}
}  
   