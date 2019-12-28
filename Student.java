 import java.io.*;
 class Student 
{ static int rno;
  static String name;
  public static void getdata(int r,String n)
 { rno=r;
   name=n;
 }
  public static void show()
 { System.out.println("Rollno = "+rno);
   System.out.println("Name = "+name);
 }
  public static void main(String args[])throws IOException
 { Student st[]=new Student[3];
   BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
   System.out.println("Enter Name and Rollno of Student1"); 
   String s1=bf.readLine();
   int r1=Integer.parseInt(bf.readLine());
   System.out.println("Enter Name and Rollno of Student2");
   String s2=bf.readLine();
   int r2=Integer.parseInt(bf.readLine());
   System.out.println("Enter name and Rollno of Student3");
   String s3=bf.readLine();
   int r3=Integer.parseInt(bf.readLine());
   for(int i=0;i<3;i++)
  { st[i]=new Student();
    if(i==0)
   { st[i].getdata(r1,s1);
     st[i].show();
   }
    if(i==1)
  { st[i].getdata(r2,s2);
    st[i].show();
  }
   if(i==2)
  { st[i].getdata(r3,s3);
    st[i].show();
  }
}
}
}
   
   


