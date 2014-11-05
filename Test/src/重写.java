
public class 重写 {
 
 public boolean equals( 重写 other ) {
     System.out.println("重写 equals method reached" );
     return true;
   }
 
 public static void main(String[] args) {
  Object o1 = new 重写();
  Object o2 = new 重写();
 
  重写 o3 = new 重写();
  重写 o4 = new 重写();
 
  if(o1.equals(o2)){
   System.out.println("objects o1 and o2 are equal");
  }
 
  if(o3.equals(o4)){
   System.out.println("objects o3 and o4 are equal");
  }
 }
}