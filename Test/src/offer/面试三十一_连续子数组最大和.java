package offer;

public class 面试三十一_连续子数组最大和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {1,-2,3,10,-4,7,2,-5};
		System.out.println("连续子数组最大和是:"+MaxOfSubArray(num));
	}
	
	public static int MaxOfSubArray(int [] num){
		if(num.length==0){
			return 0;
		}
		int max  = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0;i<num.length;i++){
			sum = sum+num[i];
			if(sum>max){
				max = sum;
			}
			if(sum<0){
				sum = 0;
			}
		}
		
		return max;
	}

}
