package test;

public class Jicheng extends B implements A {
	/**
	 * 
	 *�̳�ʹ��super���ø���
	 *ʵ�ֽӿ�ʹ��A.��Ա�� 
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