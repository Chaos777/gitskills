package task;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num = {9,8,4,2,0,1,7,6,3,5};
		mergeSort(num);
		
		for(int i:num){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(binarySearch(num, 12));
		
	}
	
	
	/**
	 * 选择，稳定，O(n^2)
	 * */
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
	
	/**
	 * 插入，O(n^2)
	 * */
	public static void insertSort(int []num){
		for(int i=1;i<num.length;i++){
			int j = i;
			while(j>0&&num[j-1]>num[j]){
				int temp = num[j-1];
				num[j-1] = num[j];
				num[j] = temp;
				j--;
			}
		}
	}
	
	/**
	 * 冒泡，O(n^2)
	 * 
	 * */
	public static void bubbleSort(int num[]){
		for(int i=num.length;i>=0;i--){
			for(int j=1;j<i;j++){
				if(num[j]<num[j-1]){
					int temp = num[j];
					num[j] = num[j-1];
					num[j-1] = temp;
				}
			}
		}
	}
	
	
	/**
	 * 希尔，O(N^2)
	 * 
	 * */
	public static void shellSort(int []num){
		int d = num.length/2;
		while(d>0){
			for(int i=d;i<num.length;i++){
				int temp = num[i];
				int j = i-d;
				while(j>=0&&num[j]>temp){
					num[j+d] = num[j];
					j = j-d;
				}
				num[j+d] = temp;
			}
			
			d= d/2;
		}
	}
	
	/**
	 * 快速，O(nlogn)
	 * */
	public static int partition(int num[],int low,int high){
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
	
	public static void quickSort(int num[],int low,int high){
		if(low>high){
			return;
		}
		int mid = partition(num, low, high);
		quickSort(num, low, mid-1);
		quickSort(num, mid+1, high);
	}
	
	/**
	 * 快速
	 * */
	public static void quick(int num[],int low,int high){
		if(low<high){
			int i=low;
			int j = high;
			int temp = num[low];
			while(i<j){
				while(i<j&&num[j]>=temp){
					j--;
				}
				if(i<j){
					num[i] = num[j];
				}
				while(i<j&&num[i]<=temp){
					i++;
				}
				if(i<j){
					num[j] = num[i];
				}
				
			}
			num[i] = temp;
			quick(num, low, i-1);
			quick(num, i+1, high);
		}
	}
	
	/**
	 * 堆，O(nlogn)
	 * */
	public static void adjust(int num[],int i,int length){
		int child = 0;
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
			adjust(num, i, num.length);
		}
		for(int i=num.length-1;i>0;i--){
			int temp = num[i];
			num[i] = num[0];
			num[0] = temp;
			
			adjust(num, 0, i);
		}
	}
	
	/**
	 * 归并,O(nlogn)
	 * 
	 * */
	public static void merge(int num[],int begin,int mid ,int end){
		int temp[] = new int[end-begin+1];
		int i=begin;
		int j=mid+1;
		int k=0;
		while(i<=mid&&j<=end){
			if(num[i]<=num[j]){
				temp[k++] = num[i++];
			}
			else{
				temp[k++] = num[j++];
			}
		}
		while(i<=mid){
			temp[k++] = num[i++];
		}
		while(j<=end){
			temp[k++] = num[j++];
		}
		for(int m=0;m<temp.length;m++){
			num[begin+m] = temp[m];
		}
	}
	
	public static void mergeDc(int num[],int begin,int end){
		int mid;
		if(begin<end){
			mid = (begin+end)/2;
			mergeDc(num, begin, mid);
			mergeDc(num, mid+1, end);
			merge(num, begin, mid, end);
		}
	}
	
	public static void mergeSort(int num[]){
		mergeDc(num, 0, num.length-1);
	}
	
	
	/**
	 * 二分查找
	 * */
	public static int binarySearch(int num[],int key){
		int low = 0;
		int high = num.length-1;
		int mid;
		while(low<=high){
			mid = (low+high)/2;
			if(num[mid]==key){
				return mid;
			}
			else if(num[mid]>key){
				high = mid-1;
			}
			else{
				low = mid+1;
			}
		}
		
		return -1;
	}

}
