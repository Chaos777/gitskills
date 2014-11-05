/**
 * 
 */
package offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author LCZ
 *
 */
public class 面试二十四_判断二叉树后序遍历 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] sequence = {8,6,5,7,10,9,11};
		System.out.println(VerifyIsBST(sequence, sequence.length));

		System.out.println(VerifyIsBST_Extend(sequence, 0, sequence.length-1));
		
	//	System.out.println(VerifyIsLDR(sequence, sequence.length));
		
		System.out.println(VerifyIsLDR_Extend(sequence, 0, sequence.length-1));
		
		
		
	}
	
	/**
	 * 判断输入的一个序列是否为二叉搜索树的后序遍历
	 * 
	 * */
	public static boolean VerifyIsBST(int []sequence,int length){
		if(sequence.length==0||length==0){
			return false;
		}
		
		int root = sequence[length-1];
		
		int i=0;
		for(;i<length-1;i++){
			if(sequence[i]>root){
				break;
			}
		}
		
		int j = i;
		for(;j<length-1;j++){
			if(sequence[j]<root){
				return false;
			}
		}
		
		boolean left = true;
		if(i>0){
			left = VerifyIsBST(sequence, i);
		}
		
		boolean right = true;
		if(i<length-1){
			
			right = VerifyIsBST(sequence, length-i-1);
		}
		
		return (left&&right);
	}
	
	
	/**
	 * 
	 * 改进版，更容易理解
	 * 
	 * */
	public static boolean VerifyIsBST_Extend(int [] sequence,int begin,int end){
		
		if(sequence.length==0){
			return false;
		}
		
		if(begin>=end){
			return true;
		}		
		
		int root = sequence[end];
		int i = begin;
		for(;i<end;i++){
			if(sequence[i]>root){
				break;
			}
		}
		
		int mid = i;
		for(int j=mid;j<end;j++){
			if(sequence[j]<root){
				return false;
			}
		}
		
		boolean left = VerifyIsBST_Extend(sequence, begin, mid-1);
		boolean right = VerifyIsBST_Extend(sequence, mid, end-1);
		
		return (left&&right);
	}
	
	
	
	
	/**
	 *判断一个输入序列是否为二叉搜索树的先序遍历 
	 * 
	 * */
	
	public static boolean VerifyIsLDR(int [] sequence,int length){
		if(sequence.length==0||length==0){
			return false;
		}
		
		int root = sequence[sequence.length-length];
		
		int i = sequence.length-length+1;
		for(;i<length;i++){
			if(sequence[i]>root){
				break;
			}
		}
		
		int j = i;
		
		for(;j<length;j++){
			if(sequence[j]<root){
				return false;
			}
		}
		
		
		boolean left = VerifyIsLDR(sequence, j-1);
		boolean right = VerifyIsLDR(sequence, length-i);
		return (left&&right);
	}
	
	/**
	 *判断一个输入序列是否为二叉搜索树的先序遍历 
	 * 
	 * */
	public static boolean VerifyIsLDR_Extend(int [] sequence ,int begin,int end){
		if(sequence.length==0){
			return false;
		}
		if(begin>=end){
			return true;
		}
		
		int root = sequence[begin];
		int i = begin+1;
		for(;i<=end;i++){
			if(sequence[i]>root){
				break;
			}
		}
		
		int mid = i;
		
		for(int j=mid;j<=end;j++){
			if(sequence[j]<root){
				return false;
			}
		}
		
		boolean left = VerifyIsLDR_Extend(sequence, begin+1, mid-1);
		boolean right = VerifyIsLDR_Extend(sequence, mid, end);
		
		return (left&&right);
	}
	
	

}
