
public class ��д {
 
 public boolean equals( ��д other ) {
     System.out.println("��д equals method reached" );
     return true;
   }
 
 public static void main(String[] args) {
  Object o1 = new ��д();
  Object o2 = new ��д();
 
  ��д o3 = new ��д();
  ��д o4 = new ��д();
 
  if(o1.equals(o2)){
   System.out.println("objects o1 and o2 are equal");
  }
 
  if(o3.equals(o4)){
   System.out.println("objects o3 and o4 are equal");
  }
 }
}