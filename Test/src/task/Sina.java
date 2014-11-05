package task;

public class Sina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		function01(n);
		
		int num[] = {1,3,5,7,9,10,12,13};
		int key = 7;
		function02(num, key);
		
		int num1[] = new int[101];
		for(int i=1;i<101;i++){
			num1[i-1] = i;
		}
		num1[100] = 100;
		
		function(num1);
	}
	
	public static void function01(int n){
		if(n<0){
			System.out.println("输入的数字为负数！");
			return;
		}
		if(n==0){
			System.out.println(1);
			return;
		}
		
		int result =1;
		for(int i=2;i<=n;i++){
			result = result*i;
		}
		System.out.println(result);
	}
	
	public static void function02(int [] num,int key){
		int low = 0;
		int high = num.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(num[mid] == key){
				System.out.println(mid);
				return;
			}
			else if(num[mid]>key){
				high = mid-1;
			}
			else{
				low = mid+1;
			}
		}
	}
	
	public static void function(int num[]){
		int result = 0;
		for(int i:num){
			result += i;
		}
		for(int i=1;i<101;i++){
			result -= i;
		}
		
		System.out.println(result);
	}

}
