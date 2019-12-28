 import java.util.Scanner;
 public class Reversestring
{  public static void main(String args[])
  { Scanner sc=new Scanner(System.in);
    StringBuffer word[]=new StringBuffer[50];
    StringBuilder str2=new StringBuilder();
    System.out.println("Enter a sentence");
    StringBuilder str=new StringBuilder();
    str.append(sc.nextLine());
    int j=0;
    word[0]=new StringBuffer();
    for(int i=0;i<str.length();i++)
  { if(str.charAt(i)!=' ')
   {   word[j].append(str.charAt(i));
    }
   else
   {  str2.append(word[j].reverse());															 
      j++; str2.append(' ');
      word[j]=new StringBuffer();
    }
  } str2.append(word[j].reverse());
  System.out.println(str2);
 
}
}  