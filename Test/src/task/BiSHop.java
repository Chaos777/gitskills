package task;

public class BiSHop {
	
	static String [] temp = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function_01(15, 56);
		function_02("124545sss333 S333333");
		
	}
	
	/**
	 * ����������������ת��
	 * 
	 * */
	
	public static void function_01(int j,int num){
		if(j<2||j>19){
			System.out.println("��ֻ��ת��Ϊ2��19����");
			return;
		}
		StringBuffer sb = new StringBuffer();
		while(num>0){
			int n = num%j;
			sb.insert(0, temp[n]);
			num = num/j;
		}
		System.out.println(sb.toString());
	}
	
	/**
	 * ʹ�������ж��Ƿ�ȫ��������ɵ�
	 * */
	public static void function_02(String str){
		str = str.replaceAll("\\d", "");
		System.out.println(str);
		if(str.length()==0){
			System.out.println("��");
		}
		else{
			System.out.println("��");
		}
	}
	

}
