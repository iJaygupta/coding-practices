import java.util.Scanner;
  public class Agami
{ public static void main(String args[])
 { int ar[]=new int[100];
   for(int i=0;i<98;i++)
   {  ar[i]=i+1;
    }
    ar[98]=99;
    ar[99]=99;
    for(int i=0;i<99;i++)
  {  for(int j=i+1;j<100;j++)
     { if(ar[i]==ar[j])
      {
        System.out.println(ar[i]+"is twice in the array");
      } 
     }
  }

}
}