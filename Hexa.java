import java.util.Scanner;
public class Hexa
{  public static void main(String args[])
  {  Scanner sc=new Scanner(System.in);
     int j=1;
     int num=3;
     
     while(num<=29)
    {  if(j%3==1)
       { 
          System.out.print(" "+num);
           num=num+3;
        }
       else
       {
          System.out.print(" "+num);
           num=num+2;
         }
       j++;
    }
   
}
}