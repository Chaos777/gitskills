package art;

public class ��1_1��ת�ַ��� {
	
	
	/**
	 * ����һ���ַ�����Ҫ����ַ���ǰ������ɸ��ַ��ƶ����ַ�����β��������ַ�����abcdef��ǰ���2���ַ�'a'��'b'�ƶ����ַ�����β����
	 * ʹ��ԭ�ַ�������ַ�����cdefab������дһ��������ɴ˹��ܣ�Ҫ��Գ���Ϊn���ַ���������ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1)��
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] str = {'a','b','c','d','e','f'};
	//	function_01(str, 2);
	//	str = function_02(str, 2);
		function_03(str, 2);
		for(char c:str){
			System.out.print(c);
		}
	}
	
	/**
	 * ��һ�������ƽⷨ
	 * 
	 * */
	public static void function_01(char[] str,int m){
		for(int i=0;i<m;i++){
			char temp = str[0];
			for(int j=1;j<str.length;j++){
				str[j-1] = str[j];
			}
			str[str.length-1] = temp;
		}
	}
	
	/**
	 *�������η�ת 
	 * 
	 * */
	public static void function_03(char[]str,int m){
		m = m%str.length;			//m���ڳ���ʱ��ȡ��ķ���
		func(str, 0, m-1);
		func(str, m, str.length-1);
		func(str, 0, str.length-1);
	}
	/**
	 * 
	 *��ת���� 
	 * */
	public static void func(char[] str,int begin,int end){
		while(begin<end){
			char temp = str[begin];
			str[begin++] = str[end];
			str[end--] = temp;
		}
	}
	
	/**
	 * ������java substring
	 *  
	 * */
	public static char[] function_02(char [] str,int m){
		String temp = String.valueOf(str);
		temp = temp.substring(m)+temp.substring(0, m);
		return temp.toCharArray();
	}
	
	/***
	 * 1������ת������һ�������һ����k�����磬����Ϊ1��2��3��4��5��6��k=2��
	 * ��ת��2��1��6��5��4��3����k=3����ת��3��2��1��6��5��4����k=4����ת��4��3��2��1��6��5���ó���ʵ�֡�
	 * �������ֱ�ת��ƴ��
	 * 
	 * 2����д������ԭ�ַ����а��ַ���β����m���ַ��ƶ����ַ�����ͷ����Ҫ�󣺳���Ϊn���ַ�������ʱ�临�Ӷ�ΪO(n)��
	 * �ռ临�Ӷ�ΪO(1)�� ���磬ԭ�ַ���Ϊ��Ilovebaofeng����m=7��������Ϊ����baofengIlove����
	 * 
	 * ��������ת�ٷֱ�ת
	 * 
	 * 3�����ʷ�ת������һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䣬�����е����Կո��������
	 * Ϊ������������ź���ͨ��ĸһ���������磬���롰I am a student.�����������student. a am I����
	 * 
	 * ��������ת�ٵ����ڲ���ת* 
	 * 
	 * 
	 * */

}
