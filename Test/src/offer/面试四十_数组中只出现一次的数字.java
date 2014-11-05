package offer;

public class 面试四十_数组中只出现一次的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {2,4,3,6,3,2,5,5};
		FindNUmberAppearOnce(num);
	}
	
	/**
	 * 主要思想使用异或，
	 * 按照全部异或的结果的1的出现位置，把数组分为两组，
	 * 然后分别异或，得到的两个最终结果就是要求的数组中只出现一次的两个数
	 * 
	 * */
	public static void FindNUmberAppearOnce(int[] num){
		if(num.length<2){
			System.out.println(num.toString());
		}
		
		int resultOR = 0;
		for(int i:num){
			resultOR ^= i;
		}
		int indexOf1 = findFirstBit1(resultOR);
		
		int num1 = 0;
		int num2 = 0;
		
		for(int i:num){
			if(isBit1(i, indexOf1)){
				num1 ^= i;
			}
			else{
				num2 ^= i;
			}
		}
		
		System.out.println("出现一次的两个数是:"+num1+","+num2);
	}
	
	
	
	/**
	 * 
	 * 找出1出现的最右边的位置
	 * 
	 * */
	public static int findFirstBit1(int num){
		int indexBit = 0;
		while((num&1)==0){
			num = num>>1;
			indexBit++;
		}
		
		return indexBit;
	}
	
	/**
	 *判断某位数字是否为1 
	 * 
	 * */
	static boolean isBit1(int num,int indexBit){
		num = num>>indexBit;
		return (num&1)==1;
	}
	
	

}
