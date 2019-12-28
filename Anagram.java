   import java.util.Scanner;
   public class Anagram
{  public static void main(String args[])
{  Scanner sc=new Scanner(System.in);
   System.out.println("Enter the first String");
   String str1=sc.next();
   System.out.println("Enter the second String");
   String str2=sc.next();
   int k=0;
  for(int i=0;i<str1.length();i++)
  { k=0;
    for(int j=0;j<str2.length();j++)
   { if(str1.charAt(i)==str2.charAt(j))
    { k++;
     }
   }
   if(k==0)
  { System.out.println("String is not Anagram");
    System.exit(0);
  }
 }
  if(k!=0)
 { System.out.println("String is Anagram");
  }
}
}
