package offer;

public class 面试十四_调整奇偶数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num = {1,2,3,4,5,6,7,8,9};
//		function_01(num);
		function_02(num);
		for(int i:num){
			System.out.print(i+" ");
		}
		System.out.println();
		int []num1 = {0,3,0,2,4,0,6,0};
		functZero(num1);
		for(int i:num1){
			System.out.print(i+" ");
		}
	}
	
	/**
	 * 一般方法，无扩展性,调整奇偶数
	 * */
	public static void function_01(int [] num){
		int i = 0 ;
		int j = num.length-1;
		
		while(i<j){
			while(i<j&&(num[i]&1)==1){					//改变条件，可以解决正负数、能否被一个数整除等问题
				i++;
			}
			while(i<j&&(num[j]&1)==0){					//
				j--;
			}
			if(i<j){
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
	}
	
	/**
	 *保证偶数之间的相对顺序不变 
	 * */
	public static void function_02(int []num){
		int k = num.length-1;
		for(int i=num.length-1;i>=0;i--){
			if(num[i]%2==0){
				if(num[k]%2!=0){
					int temp = num[k];
					num[k] = num[i];
					num[i] = temp;
				}
				k--;
			}
		}
	}
	
	/**
	 *交换0与非零，例如 0,3,0,2,4,0,6，，交换之后非零元素之间位置不变，0,0,0,3,2,4,6 
	 * 
	 * */
	public static void functZero(int num[]){
		int k = num.length-1;
		for(int i=num.length-1;i>=0;i--){
			if(num[i]!=0){
				if(num[k]==0){
					num[k] = num[i];
					num[i] = 0;
				}
				k--;
			}
		}
	}

}
