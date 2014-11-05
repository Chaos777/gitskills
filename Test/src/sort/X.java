package sort;

public class X {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {5,3,7,9,6};
/*		Sort4(num,0,num.length-1);*/
		sort5(num, num.length);
		for(int i:num){
			System.out.print(i+"\t");
		}
	}
	
	/**
	 *—°‘Ò≈≈–Ú 
	 * 
	 **/
	public static void Sort(int[]num){
		for(int i=0;i<num.length;i++){			
			for(int j=i+1;j<num.length;j++){
				if(num[i]>num[j]){
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}
	
	
	/**
	 *√∞≈›≈≈–Ú 
	 * 
	 **/
	public static void Sort1(int num[]){
		for(int i=num.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(num[j+1]<num[j]){
					int temp = num[j+1];
					num[j+1] = num[j];
					num[j] = temp;
				}
			}
		}
	}
	
	
	/**
	 *≤Â»Î≈≈–Ú 
	 * 
	 **/
	public static void Sort2(int num[]){
		for(int i=0;i<num.length;i++){
			for(int j=i;j<num.length;j++){
				if(num[j]<num[i]){
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}
	
	/**
	 *∂˛∑÷≈≈–Ú 
	 **/
	public static void Sort3(int num[]){
		int low,high,mid,temp;
		for(int i=0;i<num.length;i++){
			temp = num[i];
			low = 0;
			high = i-1;
			while(low<=high){
				mid = (low+high)/2;
				if(num[mid]>temp){
					high = mid-1;
				}
				else{
					low = mid+1;
				}
			}
			for(int j=i-1;j>high;j--){
				num[j+1] = num[j];
			}
			num[high+1] = temp;
		}
	}
	
	/**
	 *øÏÀŸ≈≈–Ú 
	 * 
	 **/
	public static void Sort4(int num[],int low,int high){
		if(low<high){
			int i = low;
			int j = high;
			int temp = num[i];
			while(i<j){
				while(i<j&&num[j]>temp){
					j--;
				}
				if(i<j){
					num[i] = num[j];
					i++;
				}
				while(i<j&&num[i]<temp){
					i++;
				}
				if(i<j){
					num[j] = num[i];
					j--;
				}				
			}
			num[i] = temp;
			Sort4(num, low, i-1);
			Sort4(num, i+1, high);
		}
	}
	
	/**
	 *shell≈≈–Ú 
	 * ¥ÌŒÛ
	 **/
	
	public static void sort5(int []num,int length){
		int d = length;
		while(d>1){
			d = (d+1)/2;
			for(int i=0;i<length-d;i++){
				if(num[i+d]<num[i]){
					int temp = num[i];
					num[i] = num[i+d];
					num[i+d] = temp;
				}
			}
		}
	}

}
