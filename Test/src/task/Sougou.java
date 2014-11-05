package task;

public class Sougou {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	public static void add(byte b){
		b = b++;
	}
	
	public static void test(){
		byte a = 127;
		byte b = 127;
		
		add(++a);
		System.out.println(a);
		
		add(b);
		System.out.println(b);
	}

}
