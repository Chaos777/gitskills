package duotai;

public class Test2 {
	
	public int field = 0;
	
	public int getField(){
		return field;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 test2 = new SubT();
		System.out.println(test2.field+"---"+test2.getField());
		
		SubT s = new SubT();
		System.out.println(s.field+"---"+s.getField()+"---"+s.getSuperField());
	}

}

class SubT extends Test2{
	public int field = 1;
	
	public int getField(){
		return field;
	}
	
	public int getSuperField(){
		return super.field;
	}
	
}
