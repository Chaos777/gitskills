package duotai;

public class Test1 {
	
	private void write(){
		System.out.println("Main");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test1 test1 = new sub();
		test1.write();
	}

}

class sub extends Test1{
	private void write(){
		System.out.println("Sub");
	}
}