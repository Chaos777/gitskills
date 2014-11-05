
public class ºÍ×î´ó {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {-9,-2,-3,-5,-3};
		System.out.println(max(num));
	}
	
	public static int max(int []num){
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i=0;i<num.length;i++){
			if(sum<0){
				sum = num[i];
			}
			else{
				sum += num[i];
			}
			
			if(sum>max){
				max = sum;
			}
		}
		
		return max;
	}

}
