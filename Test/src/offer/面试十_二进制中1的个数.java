package offer;

public class ����ʮ_��������1�ĸ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;				//������ 1010��
		System.out.println(n<<1);
		System.out.println(n+"�Ķ�������1�ĸ�����:"+function_01(n));
		System.out.println(n+"�Ķ�������1�ĸ�����:"+function_02(n));
		System.out.println(n+"�Ķ�������1�ĸ�����:"+function_03(n));
		
		int m = 256;
		System.out.println((function_Is(m)==true)?m+"��2����������":m+"����2����������");
		
		int y = 13;
		System.out.println(n+","+y+"�����������ֵĶ�����λ���"+function_Ex(n, y)+"λ");
	}
	
	/**
	 * ��һ����1&����Ϊ1�ǣ�����
	 * ������ѭ����������ʱ��
	 * */
	public static int function_01(int n){
		int count = 0;
		while(n>0){
			if((n&1)>0){
				count++;
			}
			n = n>>1;
		}
		return count;
	}
	
	/**
	 * ��������1����&����Ϊ1
	 * 
	 * */
	public static int function_02(int n){
		int count = 0;
		int flag =1;
		while(flag>0){
			if((n&flag)>0){
				count++;
			}
			flag = flag<<1;
		}
		return count;
	}
	
	/**
	 * ��������Ч���㷨
	 * 
	 * */
	public static int function_03(int n){
		int count = 0;
		while(n>0){
			count++;
			n = (n-1)&n;
		}
		return count;
	}
	
	/**
	 * ��չ����һ�����Ƿ�Ϊ2����������
	 * 
	 * */
	public static boolean function_Is(int n){
		return (n&(n-1))==0?true:false;
	}
	
	/**
	 * ��չ:���������Ķ��������ı伸λ�������
	 * */
	
	public static int function_Ex(int x,int y){
		return function_03((x^y));
	}
	

}
