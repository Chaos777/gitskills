package offer;

public class 面试新增从有序数组含正负数中找到绝对值最小的数 {
	
	/**
	 * 给定一个有序整数序列（非递减序），可能包含负数，找出其中绝对值最小的元素，比如给定序列 -5, -3, -1, 2, 8 则返回－1。
	 * 
	 * 
	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1[] = {0,1,1,5,78,98};
		int num2[] = {-7,-4,-3,-2,0};
		int num3[] = {-7,-5,-4,-3,-2};
		int num4[] = {1,2,3,4,5,7,8};
		int num5[] = {-7,-5,-3,0,1,4};
		int num6[] = {-7,-5,-1,2,3,4};
		
		
		
		System.out.println(function_01(num1));
		System.out.println(function_01(num2));
		System.out.println(function_01(num3));
		System.out.println(function_01(num4));
		System.out.println(function_01(num5));
		System.out.println(function_01(num6));
		
		System.out.println(function_02(num1));
		System.out.println(function_02(num2));
		System.out.println(function_02(num3));
		System.out.println(function_02(num4));
		System.out.println(function_02(num5));
		System.out.println(function_02(num6));
		
	}
	
	/**
	 *法一:直接遍历数组，用两个变量分别保存最大的负数与最小的正数
	 * 非递减
	 * */
	public static int function_01(int [] num){
		/*if(num[0]==0){						//第一个元素为零
			return num[0];
		}
		else if(num[num.length-1]==0){		//最后一个元素为零
			return num[num.length-1];
		}*/
		 if(num[0]*num[num.length-1]>0){	//首尾元素同号
			if(num[0]<0){						//负数
				return num[num.length-1];		
			}
			else {
				return num[0];					//正数
			}
		}		
		else{									//同时含有正负数
			int PosN = Integer.MAX_VALUE-1;
			int NegN = Integer.MIN_VALUE+1;
			
			for(int i=0;i<num.length;i++){
				if(num[i]>=0){
					if(num[i]<PosN){
						PosN = num[i];
					}
				}
				else{
					if(num[i]>NegN){
						NegN = num[i];
					}
				}
			}
			
			return Math.abs(PosN)>Math.abs(NegN)?NegN:PosN;
		}
	}
	
	/**
	 * 法二：利用二分查找
	 * 
	 * */
	public static int function_02(int [] num){
		/*if(num[0]==0){						//第一个元素为零
			return num[0];
		}
		else if(num[num.length-1]==0){		//最后一个元素为零
			return num[num.length-1];
		}*/
		
		 if(num[0]*num[num.length-1]>0){
			if(num[0]<0){						//负数
				return num[num.length-1];		
			}
			else {
				return num[0];					//正数
			}
		}
		else{
			int left = 0;
			int right = num.length-1;
			while(left<right){
				if(left + 1 == right){
					return Math.abs(num[left])<Math.abs(num[right])?num[left]:num[right];
				}
				
				int mid = (left+right)/2;
				if(num[mid]*num[right]>0){
					right = mid;
				}
				else{
					left = mid;
				}
			}
			
			return -1;
		}
	}

}
