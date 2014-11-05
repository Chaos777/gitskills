import test.sta;


public class HHH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Integer integer = null;
		int i = integer;
		System.out.println(i);*/
		
		AAAQ b = new B();
//		b.function();
//		A a = (A)b;
		((B)b).function();
		
		/*b = new A();
		b.function();*/
		int i = "abs".length();
		char c = 17;
	}

}
class A{
	/*public void function(){
		System.out.println("classA");
	}*/
}

class B extends AAAQ{
	public void function(){
		System.out.println("classB");
	}
}