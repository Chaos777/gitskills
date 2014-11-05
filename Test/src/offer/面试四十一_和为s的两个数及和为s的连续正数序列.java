package offer;

public class 面试四十一_和为s的两个数及和为s的连续正数序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]  = {1,2,4,7,11,15};
		int sum = 15;
		FindNumberWithSum(num, sum);
		FindContinuousSequence(100);
	}
	
	/**
	 * 和为s的两个数
	 * 两个指针前后
	 * */
	public static void FindNumberWithSum(int num[],int sum){
		if(num.length<1){
			System.out.println("无解，输入数组有误");
		}
		
		int ahead = 0;
		int behind = num.length-1;
		
		while(ahead<behind){
			int tempsum = num[ahead]+num[behind];
			if(tempsum==sum){
				System.out.println("和为"+sum+"的两个数是"+num[ahead]+","+num[behind]);
				break;
			}
			
			else if(tempsum>sum){
				behind--;
			}
			else{
				ahead++;
			}
		}
	}
	
	/**
	 * 和为s的连续正数序列
	 * 同两个指针
	 * */
	static void FindContinuousSequence(int sum){
		if(sum<3){
			System.out.println("输入和有问题");
		}
		int small = 1;
		int big =2;
		int maxNum = (sum+1)/2;
		int tempSum = small+big;
		
		while(small<maxNum){
			if(tempSum==sum){
				Print(small, big);
				System.out.println(sum);
			}
			while((tempSum>sum)&&(small<maxNum)){
				tempSum -= small;
				small++;
				if(tempSum==sum){
					Print(small, big);
					System.out.println(sum);
				}
			}
			
			big++;
			tempSum += big;
		}
	}
	
	
	/**
	 *打印连续序列 
	 * */
	static void Print(int begin,int end){
		for(int i=begin;i<end;i++){			
			System.out.print(i+"+");
		}
		System.out.print(end+"=");
		
	}

}
