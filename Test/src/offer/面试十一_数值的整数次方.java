package offer;

public class ����ʮһ_��ֵ�������η� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double base = 2;
		int exponent = 1024;
		System.out.println((int)power_01(base, exponent));
		System.out.println((int)power_02(base, exponent));
		
	}
	
	/**
	 * ֱ�۽ⷨ
	 * ��©���������Ϊ�㣬ָ��Ϊ��������
	 * */
	public static double power_01(double base,int exponent){
		double result  = 1.0;
		for(int i=1;i<=exponent;i++){
			result *= base;
		}
		return result;
	}
	
	
	/**
	 * һ��ⷨ
	 * 
	 * */
	public static double power_02(double base,int exponent){
		if(Isequre(base,0.0)&&exponent<0){
			
			return 0.0;
			
		}
		
		int temp = exponent<0?-exponent:exponent;
	//	double result = function(base, temp);
		double result = function_Extend(base, temp);
		if(exponent<0){
			result = 1.0/result;
		}
		return result;
	}
	
	/**
	 * �����ķ���
	 * */
	public static double function(double base,int exp){
		double result = 1.0;
		for(int i=1;i<=exp;i++){
			result *= base;
		}
		return result;
	}
	
	/**
	 *�Ľ��ķ��� 
	 * 
	 * */
	public static double function_Extend(double base,int exp){
		if(exp==0){
			return 1;
		}
		if(exp==1){
			return base;
		}
		
		double result = function_Extend(base, exp>>1);
		result *= result;
		if((exp&1)==1){				//����
			result *= base;
		}
		return result;
		
	}
	
	public static boolean Isequre(double a,double b){
		double um = 0.000000001;
		if((a-b)<um&&(b-a)>-um){
			return true;
		}
		return false;
	}

}
