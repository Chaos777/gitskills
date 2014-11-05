package offer;

public class 面试四十七_不用加减乘除做加法 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 5;
		int num2 = 17;
		System.out.println(Add(num1, num2));
		
		
	}
	
	public static int Add(int num1,int num2){
		
		int sum,carry;
		do{
			sum = num1^num2;
			carry = (num1&num2)<<1;
			
			num1 = sum;
			num2 = carry;
		}while(num2!=0);
		
		return num1;
	}

}
