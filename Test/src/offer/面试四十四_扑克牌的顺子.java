package offer;

import java.util.Arrays;

public class 面试四十四_扑克牌的顺子 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num = {0,0,3,4,7};
		System.out.println(IsContinous(num));
	}
	
	/**
	 *排序，统计0的个数，统计非零数字之间的差，比较
	 * 
	 * */
	public static boolean IsContinous(int []num){
		if(num==null||num.length<1){
			return false;
		}
		
		Arrays.sort(num);
		
		int numberOfZero = 0;
		int numberOfGrap = 0;
		for(int i:num){
			if(i==0){
				numberOfZero++;
			}
		}
		
		int begin = numberOfZero;
		int end = begin +1;
		while(end<num.length){
			if(num[begin] == num[end]){			//有对子出现，一定非顺子
				return false;
			}
			numberOfGrap += num[end]-num[begin]-1;
			end++;
			begin++;
		}
		
		return numberOfGrap-numberOfZero>0?false:true;
	}

}
