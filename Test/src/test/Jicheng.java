package test;

public class Jicheng extends B implements A {
	/**
	 * 
	 *继承使用super调用父类
	 *实现接口使用A.成员名 
	 **/
	
	public void doing(){
		System.out.println(super.x+"---"+A.x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Jicheng().doing();
	}

}

interface A{
	int x = 9;
}

class B{
	int x = 10;
}