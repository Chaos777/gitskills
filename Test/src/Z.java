
public class Z extends X{
	
	Y y = new Y();
	
	public Z(){
		System.out.println("Z");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Z();
		
	}

}

class X{
	Y y = new Y();
	public X(){
		System.out.println("X");
	}
}
class Y{
	public Y(){
		System.out.println("Y");
	}
}