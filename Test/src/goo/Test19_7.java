package goo;

public class Test19_7 {
	
	/**
	 * ����һ����������(���������͸���)���ҵ��������������������У������غ͡�
	 * ���ӣ�http://www.cricode.com/2452.html
	 * ����: {2, -8, 3, -2, 4, -10}
	 * ���: 5 (��, {3, -2, 4} ) 
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]= {-2, -8, -3, -2, -4, -10};
		function(num);
		function_02(num);
	}
	
	
	/**
	 * ���Ǹ����Ļ������0������ʾ��
	 * */
	public static void function(int num[]){
		int max = Integer.MIN_VALUE;
		int curmax = num[0];
		for(int i=1;i<num.length;i++){
			curmax = curmax+num[i];
			if(curmax<0){
				curmax = num[i];
			}
			else{
				if(curmax>max){
					max = curmax;
				}
			}
		}
		System.out.println(max==Integer.MIN_VALUE?0+" ȫ��������Ϊ����":max);
	}
	
	
	/**
	 * ���Ǹ����Ļ���������ĸ���
	 * 
	 * */
	public static void function_02(int num[]){
		int max = Integer.MIN_VALUE;
		int curmax = 0;
		for(int i=0;i<num.length;i++){
			if(curmax<=0){
				curmax = num[i];
			}
			else{
				curmax += num[i];
			}
			
			if(curmax>max){
				max = curmax;
			}
		}
		System.out.println(max);
	}
	
	

}
