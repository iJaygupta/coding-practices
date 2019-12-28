 import java.util.Scanner;
 public class Palsubstring 
{  public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter a new String");
   StringBuffer str=new StringBuffer();
   str.append(sc.next());
   StringBuffer str1[]=new StringBuffer[50];
   int k=0;
   for(int i=0;i<str.length()-1;i++)
  { str1[i]=new StringBuffer();
    str1[i].append(str.charAt(i));
    for(int j=i+1;j<str.length();j++)
   {  str1[i].reverse();
      str1[i].append(str.charAt(j));
      str1[i].reverse();
      if(str1[i].toString().equals(str.substring(i,j+1)))
     { System.out.println(str1[i]+" is Pallindrome Sub String");
       k++;
     }
   }
   }
   if(k==0)
  {  System.out.println("No Pallindrome Substring Found");
   }
 }
}