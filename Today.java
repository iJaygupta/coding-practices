public class Today
{ public static void main(String args[])
 { System.out.print("There are "+args.length+" input, and the inputs are ");
    for(int i=0;i<args.length-1;i++)
   { String s=args[i];
     System.out.print(s+",");
   } 
    String s=args[args.length-1];
    System.out.print("and "+s);
 }
}