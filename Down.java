 class Above
{  void show()
  { System.out.println("Show Method of Above class");
   }
}
 class Down extends Above
{ void show()
  { System.out.println("Show Method of Down Class");
  }
  public static void main(String args[])
 {  Down d=new Down();
    d.show();
    Above a=new Above();
    a.show();
    a=(Down)d;
    a.show(); 
  }
}
  