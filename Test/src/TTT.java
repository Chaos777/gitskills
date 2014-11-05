
public class TTT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {2,3,5,1,9,10,7,9,8};
//		quickSort(num, 0, num.length-1);
		QS_new(num, 0, num.length-1);
		for(int i:num){
			System.out.print(i+" ");
		}
	}
	
	public static void quickSort(int [] num,int low ,int high){
		int i,j,temp;
		if(low<high){
			i = low;
			j = high;
			temp = num[i];
			
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
//			System.out.println(i);
			quickSort(num, low, i-1);
			quickSort(num, i+1, high);
		}
	}
	
	/**
	 *quicksortnew 
	 * */
	public static void QS_new(int [] num,int low ,int high){
		if(num==null){
			return;
		}
		if(low<high){
			int i = low;
			int j = high;
			int mid = low+(high-low)/2;
			int midData = num[mid];
			while(i<=j){
				while(num[j]>midData){
					j--;
				}
				while(num[i]<midData){
					i++;
				}
				if(i<=j){
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					i++;
					j--;
				}
			}
			
			if(low<j){
				QS_new(num, low, j);
			}
			if(i<high){
				QS_new(num, i, high);
			}
			
		}
	}

}
