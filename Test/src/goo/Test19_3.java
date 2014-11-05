package goo;

public class Test19_3 {
	
	
	/**
	 * http://www.cricode.com/2446.html
	 * 求一个数的阶层中末尾0的个数
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		function(n);
	}
	
	public static void function(int n){
		int count = 0;
		while((n/=5)>0){
			count += n;
		}
		System.out.println("末尾有"+count+"个零");
	}

}
abstract class s{
	
}
abstract class l extends s implements Runnable {
	
}
