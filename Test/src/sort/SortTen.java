package sort;

import java.util.ArrayList;
import java.util.List;

public class SortTen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		System.out.println(10%3*2);
		int num1[] = {9,6,8,7,4,5,3,1,2,0};
		
		selectSort(num1);
		for(int i:num1){
			System.out.print(i+" ");
		}
		System.out.println();
		
		int num2[] = {9,6,8,7,4,5,3,1,2,0};
		
		insertSort(num2);
		for(int i:num2){
			System.out.print(i+" ");
		}
		System.out.println();
		
		
		int num3[] = {9,6,8,7,4,5,3,1,2,0};
		
		bubbleSort(num3);
		for(int i:num3){
			System.out.print(i+" ");
		}
		System.out.println();
		
		int num4[] = {9,6,8,7,4,5,3,1,2,0};
		
		shellSort(num4);
		for(int i:num4){
			System.out.print(i+" ");
		}
		System.out.println();
		
		int num5[] = {9,6,8,7,4,5,3,1,2,0};
		
		quickSort(num5,0,num5.length-1);
		for(int i:num5){
			System.out.print(i+" ");
		}
		System.out.println();
		
		int num6[] = {9,6,8,7,4,5,3,1,2,0};
		
		heapSort(num6);
		for(int i:num6){
			System.out.print(i+" ");
		}
		System.out.println();
		
		int num7[] = {9,6,8,7,4,5,3,1,2,0};
		
		mergeSort(num7);
		for(int i:num7){
			System.out.print(i+" ");
		}
		System.out.println();
		
		int num8[] = num7;
		int key = 3;
		System.out.println(binarySearch(num8,key));
	}
	
	public static void selectSort(int num[]){
		for(int i=0;i<num.length;i++){
			for(int j=i+1;j<num.length;j++){
				if(num[j]<num[i]){
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}
	
	
	public static void insertSort(int num[]){
		for(int i=0;i<num.length;i++){
			for(int j=i+1;j<num.length;j++){
				while(j>0&&num[j]<num[j-1]){
					int temp = num[j];
					num[j] = num[j-1];
					num[j-1] = temp;
					j--;
				}
			}
		}
	}
	
	public static void bubbleSort(int num[]){
		for(int i=num.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(num[j]>num[j+1]){
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
	}
	
	public static void shellSort(int num[]){
		int d = num.length/2;
		while(d>0){
			for(int i=d;i<num.length;i++){
				int temp = num[i];
				int j = i - d;
				while (j >= 0 && temp < num[j]) {
					num[j + d] = num[j];
					j = j - d;
				}
				num[j + d] = temp;
			}
			d=d/2;
		}
	}
	
	public static int partation(int num[],int low,int high){
		int temp = num[low];
		while(low<high){
			while(low<high&&temp<=num[high]){
				high--;
			}
			num[low] = num[high];
			while(low<high&&temp>=num[low]){
				low++;
			}
			num[high] = num[low];
		}
		num[low] = temp;
		
		return low;
	}
	
	public static void quickSort(int num[],int low,int high){
		if(low>high){
			return;
		}
		
		int mid = partation(num, low, high);
		quickSort(num, low, mid-1);
		quickSort(num, mid+1, high);
		
	}
	
	public static void adjust(int num[],int i,int length){
		int child =0;
		for(int temp = num[i];i*2+1<length;i=child){
			child = i*2+1;
			while(child<length-1&&num[child]<num[child+1]){
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
	
	public static void heapSort(int num[]){
		for(int i=num.length/2-1;i>=0;i--){
			adjust(num, i, num.length-1);
		}
		
		for(int i=num.length-1;i>0;i--){
			int temp = num[i];
			num[i] = num[0];
			num[0] = temp;
			
			adjust(num, 0, i);
		}
	}
	
	public static void Merge(int num[],int low,int mid,int high){
		int temp[] = new int[high-low+1];
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid&&j<=high){
			if(num[i]<num[j]){
				temp[k++] = num[i++];
			}
			else{
				temp[k++] = num[j++];
			}
		}
		
		while(i<=mid){
			temp[k++] = num[i++];
		}
		while(j<=high){
			temp[k++] = num[j++];
		}
		
		for(int n=0;n<temp.length;n++){
			num[n+low] = temp[n];
		}
	}
	
	public static void MergeDC(int num[],int low,int high){
		int mid;
		if(low<high){
			mid = (high+low)/2;
			MergeDC(num, low, mid);
			MergeDC(num, mid+1, high);
			Merge(num, low, mid, high);
		}
	}
	
	public static void mergeSort(int num[]){
		MergeDC(num, 0, num.length-1);
	}
	
	public static int binarySearch(int num[],int key){
		int mid;
		int low=0;
		int high = num.length-1;
		while(low<=high){
			mid = (low+high)/2;
			if(num[mid]==key){
				return mid;
			}
			else if(num[mid]>key){
				high=mid-1;
			}
			else{
				low = mid+1;
			}
		}
		return -1;
	}
	
	/*public static int fun(){
		try {
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 2;
		}finally{
			return 3;
		}
	}*/

}
