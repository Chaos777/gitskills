package offer;

public class ���Ծ�_쳲����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 500;
		
		System.out.println(function_02(n));
		System.out.println(function_01(n));
	}
	
	/**
	 *��һ���ݹ� 
	 **/
	public static long function_01(int n){
		if(n<=0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		return function_01(n-1)+function_01(n-2);
	}
	
	/**
	 *������ѭ�� 
	 * */
	public static long function_02(int n){
		int result[] = {0,1};
		if(n<2){
			return result[n];
		}
		long One = 0;
		long Two = 1;
		long re = 0;
		for(int i=2;i<=n;i++){
			re = One+Two;
			One = Two;
			Two = re;
		}
		
		return re;
	}

}
