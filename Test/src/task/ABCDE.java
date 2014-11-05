package task;

public class ABCDE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=10000;i<100000;i++){
			if(function(i)){
				System.out.println(i);
				break;
			}
		}
		
		function("Abcdefffff", "CDE");
		
	}
	
	public static boolean function(int n){
		String temp = String.valueOf(n);
		String t1 = new StringBuffer(temp).reverse().toString();
		long num = n*4;
		if(t1.equals(String.valueOf(num))){
			return true;
		}
		
		return false;
	}
	
	public static void function(String str1,String str2){
		System.out.println(str1.toLowerCase().indexOf(str2.toLowerCase()));
	}

}
