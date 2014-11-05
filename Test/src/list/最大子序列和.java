package list;

public class 最大子序列和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {0,-2,3,5,-1,2};
		System.out.println(function(num));
	}
	
	public static int function(int num[]){
		int max_sum = Integer.MIN_VALUE;
		int tempsum = 0;
		
		for(int i=0;i<num.length;i++){
			if(tempsum<0){
				tempsum = num[i];
			}
			else{
				tempsum+= num[i];
			}
			
			if(tempsum>max_sum){
				max_sum = tempsum;
			}
		}
		
		return max_sum;
	}

}
