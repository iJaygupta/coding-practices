 class A 
{ A()
 { System.out.println("Constructor of class A");
 }
  void show()
 { System.out.println("Show method of class A");
  }
}
 class B extends A
{ B()
 { System.out.println("Constructor of class B");
  }
  void show()
 { System.out.println("Show method of class B");
  }
  public static void main(String args[])
 { A a=new B();
   a.show();
   a=new A();
   a.show();
 }
} 

