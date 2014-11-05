package goo;

public class Test20_4 {
	
	
	/**
	 * 写一个函数，计算0到n之间2的个数
	 * 引申为计算 0到n之间i（1-9）的个数
	 * http://www.cricode.com/2520.html
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 123456789;
		function_01(n);
		function_02(n);
		
		fun(n,1);
	}
	
	/**
	 *遍历法
	 * 
	 * 
	 * */
	public static void function_01(int n){
		int count=0;
		for(int i=0;i<=n;i++){
			int temp = i;
			while(temp>0){
				if(temp%10==2){
					count++;
				}
				temp =temp/10;
			}
		}
		System.out.println("0到"+n+"之间2的个数w为:"+count);
	}
	
	/**
	 * 规律
	 * 
	 * */
	public static void function_02(int n){
		int count = 0;
		int low =0,cur=0,high=0;
		int factor =1;
		while(n/factor!=0){
			low = n - (n/factor)*factor;
			cur = ((n/factor)%10);
			high = n/(factor*10);
			
			switch (cur) {
			case 0:
			case 1:
				count += high*factor;
				break;
			case 2:
				count += high*factor+low+1;
				break;
			default:
				count += (high+1)*factor;
				break;
			}
			factor =factor*10;
		}
		System.out.println("0到"+n+"之间2的个数w为:"+count);
	}
	
	/**
	 * 通用型
	 * 
	 * */
	public static void fun(int n,int i){
		if(i<1||i>9||n<0){
			System.out.println("输入有问题");
			return;
		}
		int count = 0;
		int low =0,cur=0,high=0;
		int factor =1;
		while(n/factor!=0){
			low = n - (n/factor)*factor;
			cur = ((n/factor)%10);
			high = n/(factor*10);
			
			if(cur<i){									//当某一位的数字小于i时，那么该位出现i的次数为：更高位数字x当前位数
				count += high*factor;
			}
			else if(cur==i){							//当某一位的数字等于i时，那么该位出现i的次数为：更高位数字x当前位数+低位数字+1
				count += high*factor+low+1;
			}
			else{										//当某一位的数字大于i时，那么该位出现i的次数为：(更高位数字+1)x当前位数
				count += (high+1)*factor;
			}
			factor =factor*10;
		}
		System.out.println("0到"+n+"之间"+i+"的个数w为:"+count);
	}

}
