package pac;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {9,8,7,6,5,4,3,2,1};
		function(num);
		
		function_02(num);
		
		int num1[] = {1,3,4,5,0,0,7,6,5};
		function_03(num1);
		
		int num2[] = {-5,-3,-1,0,8};
		function_04(num2);
		
		function_05(1,5);
	}
	
	
	/**
	 * 求最大与第二大的值
	 * */
	public static void function(int num[]){
		int max = num[0];
		int semax = Integer.MIN_VALUE;
		for(int i=1;i<num.length;i++){
			if(num[i]>max){
				semax = max;
				max = num[i];				 
			}
			else if(num[i]<max&&num[i]>semax){
				semax = num[i];
			}
		}
		
		System.out.println("最大值:"+max+" 第二大值:"+semax);
	}
	
	/**
	 * 比较次数更少,求最大最小值
	 * */
	public static void function_02(int num[]){
		int max ,min;
		int i=0;
		if((num.length&1)==1){	//奇数
			max = min = num[i++];
		}
		else{
			if(num[0]>num[1]){
				max = num[0];
				min = num[1];
			}
			else{
				max = num[1];
				min = num[0];
			}
		}
		for(;i<num.length;i=i+2){
			if(num[i]>num[i+1]){
				if(num[i]>max){
					max = num[i];
				}
				if(num[i+1]<min){
					min = num[i+1];
				}
			}
			else{
				if(num[i]<min){
					min = num[i];
				}
				if(num[i+1]>max){
					max = num[i+1];
				}
			}
		}
		
		System.out.println("最大值："+max+" 最小值:"+min);
	}
	
	
	/**给定含有n个元素的整型数组a，其中包括0元素和非0元素，对数组进行排序，要求：
	 * 1、排序后所有0元素在前，所有非零元素在后，且非零元素排序前后相对位置不变
	 * 2、无额外空间
	 * 
	 * */
	public static void function_03(int num[]){
		int k = num.length-1;
		for(int i=num.length-1;i>=0;i--){
			if(num[i]!=0){
				if(num[k]==0){
					num[k] = num[i];
					num[i] = 0;
				}
				k--;
			}
		}
		
		for(int i:num){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	/**给定一个有序整数序列（非递减序），可能包含负数，
	 * 找出其中绝对值最小的元素，比如给定序列 -5、-3、-1、2、8 则返回-1。 
	 * 
	 * 
	 * */
	public static void function_04(int num[]){
		if(num.length==1){
			System.out.println(num[0]);
			return;
		}
		if(num[0]*num[num.length-1]>=0){
			System.out.println((Math.abs(num[0])>Math.abs(num[num.length-1]))?num[num.length-1]:num[0]);
			return;
		}
		int low = 0;
		int high = num.length-1;
		while(low<high){
			if(low+1==high){
				System.out.println((Math.abs(num[low])>Math.abs(num[high]))?num[high]:num[low]);
				return;
			}
			int mid = (low+high)>>1;
			if(num[mid]==0){
				System.out.println(0);
				return;
			}
			if(num[low]*num[mid]>0){
				low = mid;
				continue;
			}
			if(num[mid]*num[high]>0){
				high = mid;
				continue;
			}
		}
		
	}
	
	/**
	 * 函数 int func(int i ,int N);
	 * 其中i <= N，功能输出i递增到N再递减到i的整数，每行输出一个数
	 * 
	 * */
	
	public static void function_05(int i,int n){
		
		System.out.println(i);
		if(i<n){
			function_05(i+1, n);
		}
		System.out.println(i);
	}

}
