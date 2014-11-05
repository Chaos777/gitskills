package offer;

public class 面试新增旋转数组查找 {
	/**
	 * 在旋转数字组中查找			无重复元素
	 * 个排好序的数组A，长度为n，现在将数组A从位置m(m<n，m未知)分开，并将两部分互换位置，假设新数组记为B，
	 * 找到时间复杂度为O(lgn)的算法查找给定的数x是否存在数组B中？
	提示：同样采用二分查找。核心思想就是确定所查找数所在的范围。通过比较3个数（头，尾，中间）和所查找数之间的关系，可以确定下次查找的范围
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {10,11,13,15,3,5,7,8};
//		int num[] = {3,5,7,8};
		int target = 8;
		System.out.println(function(num, target));
		
	}
	
	public static int function(int num[] ,int target){
		
		int i=0;
		int j= num.length-1;
		while(i<=j){
			int mid = (i+j)/2;
			if(num[mid] == target){
				return mid;
			}
			if(num[mid]>=num[0]){					//左边有序
				if(num[mid]>target&&target>=num[0]){
					j = mid-1;
				}				
				else{
					i = mid+1;
				}
			}			
			else{									//右边有序
				if(num[mid]<target&&target<=num[j]){
					i = mid+1;
				}
				else{
					j = mid-1;
				}
			}
		}
		return -1;
		
	}

}
