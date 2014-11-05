package task;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class CX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AB123abd32HDU";
		function(str);
		System.out.println();
		int []num = {9,8,7,6,5,2,0,4,3,1};
		sort(num,0,num.length-1);
		for(int i:num){
			System.out.print(i+" ");
		}
		System.out.println();
		int [][]num1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int key = 8;
		System.out.println(function(num1, key));
		
		System.out.println(function(3));
		
		int num2[] = {3,4,3,2,1,2,3,4,3,4,5,6,5};
		int key1 = 5;
		long satrt = System.currentTimeMillis();
		System.out.println(function_Test(num2, key1));
		long mid = System.currentTimeMillis();
		System.out.println(function_test02(num2, key1));
		long end = System.currentTimeMillis();
		System.out.println((mid-satrt)+":::"+(end-mid));
		
		function("abcdabd", "ab");
		
		function(10, 11, 12);
		System.out.println();
		int [][]num3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		function(num3);
		try {
			Class c = Class.forName("task.CX");
			System.out.println(c.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CX cx = new CX();
		
	}
	
	public static void function(String str){
		int temp[] = new int[255];
		for(int i=0;i<str.length();i++){
			temp[str.charAt(i)]++;
		}
		
		for(int i=0;i<temp.length;i++){
			while(temp[i]>0){
				
				System.out.print((char)i+" ");
				temp[i]--;
			}
		}
	}
	
	
	public static void adjust(int []num ,int i,int length){
		int child = 0;
		for(int temp = num[i];i*2+1<length;i=child){
			child = i*2+1;
			while(child+1<length&&num[child+1]>num[child]){
				child++;
			}
			if(num[child]>temp){
				num[i] = num[child];
				num[child] = temp;
			}
			else{
				break;
			}
		}
	}
	
	public static void HeapSort(int []num){
		for(int i=num.length/2-1;i>=0;i--){
			adjust(num, i, num.length);
		}
		
		for(int i=num.length-1;i>0;i--){
			int temp = num[i];
			num[i] = num[0];
			num[0] = temp;
			
			adjust(num, 0, i);
		}
	}
	
	public static boolean function(int [][]num,int key){
		int i=0;
		int j=num[0].length-1;
		while(i<num.length&&j>=0){
			if(num[i][j]==key){
				return true;
			}
			else if(num[i][j]>key){
				j--;
			}
			else {
				i++;
			}
		}
		
		return false;
	}
	
	public static String function(int n){
		
		double x1 = 1.0;
		double x2 = (x1+n/x1)/2.0;
		while(Math.abs(x2-x1)>0.001){
			x1 = x2;
			x2 = (x1+n/x1)/2.0;
		}
		
		return new DecimalFormat("#.000").format(x1);
	}
	
	public static int function_Test(int []num,int key){
		for(int i=0;i<num.length;i++){
			if(num[i]==key){
				return i;
			}
		}
		
		return -1;
	}
	
	public static int function_test02(int [] num,int key){
		for(int i=0;i<num.length;){
			if(num[i]==key){
				return i;
			}
			int grap = (int)Math.abs(key-num[i]);
			i = i+grap;
		}
		return -1;
	}
	
	public static void adjust_01(int num[],int i,int length){
		int child = 0;
		for(int temp = num[i];i*2+1<length;i=child){
			child = i*2+1;
			while(child+1<length&&num[child]<num[child+1]){
				child++;
			}
			if(num[child]>temp){
				num[i] = num[child];
				num[child] = temp;
			}
			else{
				break;
			}
		}
	}
	
	public static void HeapSort_01(int num[]){
		for(int i=num.length/2-1;i>=0;i--){
			adjust_01(num, i, num.length);
		}
		for(int i=num.length-1;i>0;i--){
			int temp = num[i];
			num[i] = num[0];
			num[0] = temp;
			
			adjust_01(num, 0, i);
		}
	}
	
	public static int partition(int []num,int low ,int high){
		
		int temp = num[low];
		while(low<high){
			while(low<high&&num[high]>=temp){
				high--;
			}
			num[low] = num[high];
			while(low<high&&num[low]<=temp){
				low++;
			}
			num[high] = num[low];
			
		}
		num[low] = temp;
		return low;
	}
	
	public static void sort(int num[],int low,int high){
		if(low>high){
			return;
		}
		int mid = partition(num, low, high);
		sort(num, low, mid-1);
		sort(num, mid+1, high);
	}
	
	public static void function(int a,int b,int c){
		Set<Integer>result = new HashSet<>();
		result.add(c);
		result.add(0);
		if(c>=a||c>=b){
			if(c>=a&&c>=b){
				result.add(a);
				result.add(b);				
				result.add(c-a);
				result.add(c-b);
				result.remove(0);
			}
			else{				
				result.add((int)Math.abs(c-a));
				result.add((int)Math.abs(c-b));
			}
		}		
		
		for(Integer i:result){
			System.out.print(i+" ");
		}
	}
	
	public static void function(String str1,String str2){
		int count = 0;
		while(str1.contains(str2)){
			str1 = str1.substring(0, str1.indexOf(str2))+str1.substring(str1.indexOf(str2)+str2.length());
			System.out.println(str1);
			count++;
		}
		System.out.println(count);
	}
	
	public static void function(int [][]num){
		/*for(int i=0;i<num.length;i++){
			for(int j=0;j<num[i].length;j++){
				System.out.print(num[i][j]+" ");
			}
			System.out.println();
		}*/
		int temp = num.length;
		int n = num.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<temp;j++){
				int tempA = num[i][j];
				num[i][j] = num[n-1-j][n-1-i];
				num[n-1-j][n-1-i] = tempA;
			}
			temp--;
		}
		/*for(int i=0;i<num.length;i++){
			for(int j=0;j<num[i].length;j++){
				System.out.print(num[i][j]+" ");
			}
			System.out.println();
		}*/
		for(int i=0;i<n/2;i++){
			for(int j=0;j<n;j++){
				int tempB = num[i][j];
				num[i][j] = num[n-1-i][j];
				num[n-1-i][j] = tempB;
			}
		}
		
		for(int i=0;i<num.length;i++){
			for(int j=0;j<num[i].length;j++){
				System.out.print(num[i][j]+" ");
			}
			System.out.println();
		}
	}

}


