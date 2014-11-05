
public class try_catch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new try_catch().test());
	}
	
	int test(){
		try {
			return fun1();
		} 
		finally{
			return fun2();
		}
	}
	
	int fun1(){
		System.out.println("11");
		return 1;
	}
	int fun2(){
		System.out.println("22");
		return 2;
	}

}
