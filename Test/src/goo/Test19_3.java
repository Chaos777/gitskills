package goo;

public class Test19_3 {
	
	
	/**
	 * http://www.cricode.com/2446.html
	 * ��һ�����Ľײ���ĩβ0�ĸ���
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
		System.out.println("ĩβ��"+count+"����");
	}

}
abstract class s{
	
}
abstract class l extends s implements Runnable {
	
}
