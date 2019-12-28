 class Above
{  void show()
  { System.out.println("Show Method of Above class");
   }
}
 class DownCast extends Above
{ void show()
  { System.out.println("Show Method of Down Class");
  }
  public static void main(String args[])
 {  
    
    Down d=new Above();
    d.show(); 
  }
}
  