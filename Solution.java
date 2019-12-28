import java.util.Scanner;
public class Solution {
    public static String getDay(String day, String month, String year) {
int d=Integer.parseInt(day);
    int m=Integer.parseInt(month);
      int y=Integer.parseInt(year);
        int leap_yr,ordinary_yr,odd_day;
int days[]={0,31,59,90,120,151,181,212,243,273,304,334,365};
String day_name[]={"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
if((y%4==0) && ((y%100==0||y%400==0)))
days[2]=60;
leap_yr=(y-1)/4+(y-1)/400-(y-1)/100;
ordinary_yr=(y-1-leap_yr);
odd_day=(leap_yr*2+ordinary_yr+days[m-1]+d)%7;
return(day_name[odd_day]);
    }
public static void main(String args[])
{ Scanner sc=new Scanner(System.in);
  System.out.println("Enter the date in DD MM YYYY Format");
  String day=sc.next();
  String month=sc.next();
  String year=sc.next();
  System.out.println(getDay(day,month,year));
}
}  