package offer;

public class 面试二十九_数组中出现次数超过一半 {
	
	public static void main(String [] args){
		
		int [] num = {1,2,3,2,2,2,5,4,2};
		System.out.println("出现次数超过一半的数字是："+MoreThanHalf(num));
		
		System.out.println(Morehalf(num));
		
	}
	
	
	
	/**
	 * 
	 * 
	 * */
	public static int MoreThanHalf(int []num){
		if(num.length==0){
			return 0;
		}
		
		int result = num[0];
		int items = 1;
		for(int i=1;i<num.length;i++){
			if(items ==0){
				result = num[i];
				items = 1;
			}
			else if(num[i]==result){
				items++;
			}
			else{
				items--;
			}
		}
		
		if(!CheckMoreThanHalf(num, result)){
			return 0;
		}
		return result;
	}
	
	/**
	 * 检测是否超过一半
	 * 
	 * */
	public static boolean CheckMoreThanHalf(int [] num,int number){
		int items = 0;
		for(int i=0;i<num.length;i++){
			if(num[i]==number){
				items++;
			}
		}
		if(items*2<=num.length){
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * 数据
	 * */
	public static int Morehalf(int num[]){
		int result = num[0];
		int count = 1 ;
		for(int i=1;i<num.length;i++){
			if(num[i] == result){
				count++;
			}
			else{
				count--;
			}
			
			if(count==0){
				result = num[i];
				count=1;
			}
		}
		return result;
	}

}
