package goo;

public class Test19_7 {
	
	/**
	 * 给出一个整数数组(包含正数和负数)，找到数组中最大的连续子序列，并返回和。
	 * 例子：http://www.cricode.com/2452.html
	 * 输入: {2, -8, 3, -2, 4, -10}
	 * 输出: 5 (即, {3, -2, 4} ) 
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]= {-2, -8, -3, -2, -4, -10};
		function(num);
		function_02(num);
	}
	
	
	/**
	 * 都是负数的话就输出0，并提示。
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
		System.out.println(max==Integer.MIN_VALUE?0+" 全部的数都为负数":max);
	}
	
	
	/**
	 * 都是负数的话就输出最大的负数
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
