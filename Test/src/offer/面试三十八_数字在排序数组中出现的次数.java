package offer;

public class 面试三十八_数字在排序数组中出现的次数 {
	
	/**
	 * 
	 * 利用二分查找
	 * */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num[] = {1,2,3,3,3,3,4,5};
		int k= 3;
		
		System.out.println(getNumberOfK(num, k));
	}
	
	/**
	 * 根据第一次出现的位置与最后一次出现的位置得到出现的次数
	 * */
	public static int getNumberOfK(int []num,int k){
		int number = 0;
		if(num.length>0){
			int first = Get_firstK(num, k, 0, num.length-1);
			int end = Get_endK(num, k, 0, num.length-1);
			
			if((first>-1)&&(end>-1)){
				return end - first+1;
			}
		}
		
		return number;
	}
	
	/**
	 *得到第一次出现的位置 
	 * */
	public static int Get_firstK(int num[],int k,int start,int end){
		if(start>end){
			return -1;
		}
		
		int midIndex = (start+end)/2;
		int midData = num[midIndex];
		
		if(midData==k){
			if((midIndex==0)||((midIndex>0)&&(num[midIndex-1]!=k))){		//就是第一个出现的位置
				return midIndex;
			}
			
			else{														//不是第一次出现的位置，再往前找
				end = midIndex-1;
			}
		}
		else if(midData>k){												//比中间值小，往前找
			end = midIndex-1;
		}
		else{															//比中间值大，往后找
			start = midIndex+1;
		}
		
		return Get_firstK(num, k, start, end);
	}
	
	
	/**
	 * 找到最后一次出现的位置
	 * 
	 * */
	public static int Get_endK(int num[],int k,int start,int end){
		if(start>end){
			return -1;
		}
		
		int midIndex = (start+end)/2;
		int midData = num[midIndex];
		if(midData==k){
			if((midIndex==num.length-1)||((num[midIndex+1]!=k)&&(midIndex<num.length-1))){
				return midIndex;
			}
			
			else{
				start = midIndex+1;
			}
		}
		else if(midData>k){
			end = midIndex-1;
		}
		else{
			start = midIndex+1;
		}
		
		return Get_endK(num, k, start, end);
	}
	

}
