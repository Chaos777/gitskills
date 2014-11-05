package task;

public class Bake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function(2014);
	}
	
	public static void function(int n){
		if(n<0){
			System.out.println("ÊäÈëÓÐÎó");
			return;
		}
		if(n%400==0||(n%4==0&&n%100!=0)){
			System.out.println("ÊÇ");
		}
		else{
			System.out.println("·ñ");
		}
	}

}

