package task;

public class 返回两个有序数组合并后的第K个的数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,3,5,7,9};
		int b[] = {0,2,4,6,8};
		int k = 7;
		function(a, b, k);
		functionModify(a, b, k);
		
		System.out.println(function_02(a, 0, a.length-1, b, 0, b.length-1, k));
	}
	
	/**
	 * 方法一，遍历
	 * */
	public static void function(int []a,int []b,int k){
		if(k>a.length+b.length){
			System.out.println("输入有误");
			return;
		}
		int i=0;
		int j=0;
		int index=0;
		boolean flag = true;
		
		while(k>0&&i<a.length&&j<b.length){
			if(a[i]<=b[j]){
				index = i;
				i++;				
				flag = true;
				
			}
			else{
				index = j;
				j++;				
				flag = false;
			}
			k--;
		}
		while(k>0&&i<a.length){
			index = i;
			i++;
			k--;
			flag = true;
		}
		while(k>0&&i<b.length){
			index= j;
			j++;
			k--;
			flag = false;
		}
		
		if(flag){
			System.out.println(a[index]);
		}
		else{
			System.out.println(b[index]);
		}
		
	}
	
	public static void functionModify(int[]a,int[]b,int k){
		if(k>a.length+b.length){
			System.out.println("输入有误");
			return;
		}
		int temp[] = new int[a.length+b.length];
		int i=0;
		int j=0;
		int m=0;
		while(k>0&&i<a.length&&j<b.length){
			if(a[i]<=b[j]){
				temp[m++] = a[i++];
			}
			else{
				temp[m++] = b[j++];
			}
			k--;
		}
		
		while(k>0&&i<a.length){
			temp[m++] = a[i++];
			k--;
		}
		while(k>0&&j<b.length){
			temp[m++] = b[j++];
			k--;
		}
		System.out.println(temp[--m]);
		
		
	}
	
	/**
	 * 法二
	 * */
	public static int function_02(int a[],int abegin,int aend,int b[],int bbegin,int bend,int k){
		if(abegin>aend){
			return b[bbegin+k-1];
		}
		if(bbegin>bend){
			return a[abegin+k-1];
		}
		//取中间位置 
		int amid = abegin+(aend-abegin)/2;
		int bmid = bbegin+(bend-bbegin)/2;
		
		//从A和B的开始位置到两个数组中间位置的元素个数
		int halfLen = amid-abegin+bmid-bbegin+2;
		if(a[amid]<b[bmid]){
			if(halfLen>k){
				 // 此时在合并的数组中A[aBeg...aMid]和元素一定在B[bMid]的左侧，   
	            // 即此时第k大的元素一定比B[bMid]这个元素小（严格来说不大于）   
	            // 故以后没有必要搜索 B[bMid...bEnd]这些元素
				return function_02(a, abegin, aend, b, bbegin, bmid-1, k);
			}else{
				// 此时在合并的数组中A[aBeg...aMid]元素一定在B[bMid]的左侧，   
	            // 所以前K个元素中一定包含A[aBeg...aMid]（可以使用反证法来证明这点）。   
	            // 但是无法判断A[amid+1...aEnd]与B[bBeg...bEnd]之间的关系，帮需要对他们进行判断   
	            // 此时K就剩下除去A[aBeg...aMid]这些元素，个数为k - (aMid - aBeg + 1)   
	   
				return function_02(a, amid+1, aend, b, bbegin, bend, k-(amid-abegin+1));
			}
		}
		else{
			 //注释与上面相似 
			if(halfLen>k){
				return function_02(a, abegin, amid-1, b, bbegin, bend, k);
			}else{
				return function_02(a, abegin, aend, b, bmid+1, bend, k-(bmid-bbegin+1));
			}
		}
		
	}

}
