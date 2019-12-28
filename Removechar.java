  import java.util.Scanner;
  class Removechar
 {  public static void main(String args[])
  { Scanner sc=new Scanner(System.in);
    System.out.println("Enter the String");
    StringBuilder str=new StringBuilder(); 
    str.append(sc.nextLine());
    StringBuffer str2=new StringBuffer();
    System.out.println("enter character to remove");
    char c=sc.next().charAt(0);
    for(int i=0;i<str.length();i++)
  { if(c!=str.charAt(i))
   {   str2.append(str.charAt(i)); }
   }
 
   System.out.println("Final String is "+str2);
  }
}
