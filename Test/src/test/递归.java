package test;

public class 递归 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function_01(1237);
		System.out.println("第八个人的年龄是:"+function_02(8));
		int num[] = {1,2,3,4,5,6,7,8,9};
		int num1[] = function_03(num);
		for(int i:num1){
			System.out.print(i+" ");
		}
	//	quick(num1, 0, num1.length-1);
		quickSort(num1, 0, num1.length-1);
		System.out.println("\n排序后:");
		for(int i:num1){
			System.out.print(i+" ");
		}
	}
	
	
	/**
	 *输出一个指定数字的偶数倍，如果结果大于5000，则按照一定的顺序输出 
	 **/
	public static void function_01(int n){
		System.out.println(n);
		if(n<5000){
			function_01(n*2);
		}
		System.out.println(n);
	}
	/**
	 *第二个人的年龄比第一个人的年龄大两岁，以此类推，求n个人的年龄 
	 **/
	public static int function_02(int n){
		if(n==1){
			return 10;
		}
		else{
			return function_02(n-1)+2;
		}
	}
	
	/**
	 *逆序输出数组 
	 **/
	public static int[] function_03(int []num){
		for(int i=0;i<num.length/2;i++){
			int temp = num[i];
			num[i] = num[num.length-i-1];
			num[num.length-i-1] = temp;
		}
		return num;
	}
	
	/**
	 *快速排序 
	 * 
	 **/
	public static void quick(int[]num,int left,int right){
		int mid,temp;
		int i = left,j = right;
		mid = num[(i+j)/2];
		do{
			while(num[i]<mid&&i<right){
				i++;
			}
			while(num[j]>mid&&j>left){
				j--;
			}
			if(i<=j){
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				i++;
				j--;
			}
		}while(i<=j);
		
		if(i<right){
			quick(num, i, right);
		}
		if(j>left){
			quick(num, left, j);
		}
	}
	
	/**
	 *快速排序二 
	 * 
	 **/
	public static void quickSort(int [] a,int left,int right){
		if(left<right){
			int i,j,temp;
			i = left;
			j = right;
			temp = a[i];
			while(i<j){
				while(i<j&&a[j]>temp){
					j--;
				}
				if(i<j){
					a[i++] = a[j];
				}
				while(i<j&&a[i]<temp){
					i++;
				}
				if(i<j){
					a[j--] = a[i];
				}
			}
			a[i] = temp;
			quickSort(a, left, i-1);
			quickSort(a, i+1, right);
		}
	}
	
	

}
