import java.util.Scanner;
import java.lang.*;
 public class Remdubchar
{  public static void main(String args[])
  { Scanner sc=new Scanner(System.in);
    System.out.println("Enter a String");
    StringBuilder str=new StringBuilder();
    str.append(sc.nextLine());
    StringBuilder str2=new StringBuilder();
    int i,j,k;
    for(i=0;i<str.length();i++)
   {   k=0;
       for(j=i+1;j<str.length();j++)
      { if(str.charAt(i)==str.charAt(j))
       { k++;   
        }
      }
      if(k==0)
     {  str2.append(str.charAt(i)); }
    }
       


    System.out.println("Final String is "+str2);
   }
}