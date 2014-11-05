
public class binarysearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int num[] = {2,3,4,5,6,8};
			int key = 6;
			System.out.println(binSe(num, key));
			System.out.println(binDe(num, key, 0, num.length-1));
			

	}
	public static int binSe(int [] num,int key){
		int l = 0;
		int r = num.length-1;
		int mid =0;
		while(l<=r){
			mid = l+((r-l)>>2);
			if(num[mid]==key){
				return mid;
			}
			else if(num[mid]>key){
				r = mid-1;
			}
			else{
				l = mid+1;
			}
		}
		
		return -1;
	}
	
	public static int binDe(int [] num ,int key ,int left,int right){
		if(left>right){
			return -1;
		}
		int mid = left+((right-left)>>2);
		if(num[mid]==key){
			return mid;
		}
		else if(num[mid]>key){
			return binDe(num, key, left, mid-1);
		}
		else{
			return binDe(num, key, mid+1, right);
		}
	}

}
