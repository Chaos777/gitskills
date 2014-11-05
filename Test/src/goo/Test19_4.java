package goo;

public class Test19_4 {
	
	/**
	 * http://www.cricode.com/2447.html
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.MIN_VALUE;
		int b = 1;
		function(a, b);
	}
	
	
	/**
	 * 存在问题:溢出问题
	 * 例如: -2147483648,2147483647中的较大值是0
	 * 
	 * 
	 * */
	public static void function(int a,int b){
		int result = (a+b+Math.abs(a-b))>>1;
		
		System.out.println(a+","+b+"中的较大值是"+result);
	}

}
