package test;

public class �ݹ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function_01(1237);
		System.out.println("�ڰ˸��˵�������:"+function_02(8));
		int num[] = {1,2,3,4,5,6,7,8,9};
		int num1[] = function_03(num);
		for(int i:num1){
			System.out.print(i+" ");
		}
	//	quick(num1, 0, num1.length-1);
		quickSort(num1, 0, num1.length-1);
		System.out.println("\n�����:");
		for(int i:num1){
			System.out.print(i+" ");
		}
	}
	
	
	/**
	 *���һ��ָ�����ֵ�ż����������������5000������һ����˳����� 
	 **/
	public static void function_01(int n){
		System.out.println(n);
		if(n<5000){
			function_01(n*2);
		}
		System.out.println(n);
	}
	/**
	 *�ڶ����˵�����ȵ�һ���˵���������꣬�Դ����ƣ���n���˵����� 
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
	 *����������� 
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
	 *�������� 
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
	 *��������� 
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
