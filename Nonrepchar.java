import java.util.Scanner;
 public class Nonrepchar
{ public static void main(String args[])
 { Scanner sc=new Scanner(System.in);
   System.out.println("Enter a String");
   String str=sc.next();
   int c=0;char ch='c';
   for(int i=0;i<str.length();i++)
  { c=0;
    for(int j=i+1;j<str.length();j++)
   {  if(str.charAt(i)==str.charAt(j))
      { c++;ch=str.charAt(i);
       }
   }
   if(c==0)
  {  char cd=str.charAt(i);
     if(ch!=cd)
    {   System.out.println(cd+" is Not repeated");}
  }
}
}
}