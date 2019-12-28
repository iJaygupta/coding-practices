  import java.util.Scanner;
  public class Minstrpal
{ public static void main(String args[])
 { System.out.println("Enter a String");
   Scanner sc=new Scanner(System.in);
   StringBuffer str=new StringBuffer();
   str.append(sc.next());
   int j=str.length()-1;
   int k=0;
    for(int i=0;i<j;i++)
  {  if(str.charAt(i)==str.charAt(j))
     {  j--; }
     else
     { k++;
     }
  }
     if(k==0) 
      { System.out.println("0 letter to be inserted");
      }
      else
     { System.out.println(k+"letter to be inserted");
     }
}
}
  