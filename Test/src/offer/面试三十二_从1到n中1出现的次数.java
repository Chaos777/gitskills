package offer;

public class 面试三十二_从1到n中1出现的次数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 11111110;
		System.out.println(totalOne(n));
		System.out.println(NUmberOfOne(n));
		/*String c = "1024";
		
		System.out.println(c.substring(1));*/
		
	}
	
	/**
	 * 笨方法
	 * 
	 * */
	public static int totalOne(int n){
		int total = 0;
		for(int i=1;i<=n;i++){
			total += NumberOfOneIn(i);
		}
		
		return total;
	}
	public static int NumberOfOneIn(int n){
		int count = 0;
		while(n>0){
			if(n%10==1){
				count++;
			}
			n = n/10;
		}
		
		return count;
	}
	
	/**
	 *找规律 
	 * 
	 * */
	
	public static int NUmberOfOne(int n){
		if(n<=0){
			return 0;
		}
		return NumberOf1(String.valueOf(n));
	}
	
	public static int NumberOf1(String str){
		if(str.length()==0||str==null){
			return 0;
		}
		int first = Integer.valueOf(String.valueOf(str.charAt(0)));
		int length = str.length();
		
		if(length==1&&first==0){
			return 0;
		}
		if(length==1&&first>0){
			return 1;
		}
		
		int numFirstDigit = 0;
		if(first>1){
			numFirstDigit = PowerBase10(length-1);
		}
		else if(first==1){
			numFirstDigit = Integer.valueOf(str.substring(1))+1;
		}
		
		int numOtherDigits = first*(length-1)*PowerBase10(length-2);
		int numRecursive = NumberOf1(str.substring(1));
		
		return numFirstDigit+numOtherDigits+numRecursive;
	}
	
	public static int PowerBase10(int n){
		int result = 1;
		for(int i=0;i<n;i++){
			result *= 10;
		}
		return result;
	}

}
