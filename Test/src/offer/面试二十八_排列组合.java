package offer;

import java.util.HashSet;
import java.util.Set;

public class 面试二十八_排列组合  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {1,2,3};
		function01(num, 0);
		
		System.out.println("-------");
		Set<String> result = new HashSet<>();
		
		int num1[] = {1,1,2};
		function_02(num1, 0, result);
		
		for(String s:result){
			System.out.println(s);
		}
		
		System.out.println("-------");
		String str = "abcd";
		function_03(str);
		
		System.out.println("-------");
		String str1 = "abacd";
		function_04(str1);
	}
	
	/**
	 * 无重复排列问题
	 * 
	 * */
	public static void function01(int num[],int start){
		if(start>=num.length){
			StringBuffer sb = new StringBuffer();
			for(int i:num){
				sb.append(i);
			}
			System.out.println(sb);
		}
		
		for(int i=start;i<num.length;i++){
			int temp = num[i];
			num[i] = num[start];
			num[start] = temp;
			
			function01(num, start+1);
			
			temp = num[i];
			num[i] = num[start];
			num[start] = temp;
		}
	}
	
	/**有重复元素的排列问题*/
	public static void function_02(int [] num,int start,Set<String> result){
		if(start>=num.length){
			StringBuffer sb = new StringBuffer();
			for(int i:num){
				sb.append(i);
			}
			result.add(sb.toString());
		}
		
		for(int i=start;i<num.length;i++){
			int temp = num[i];
			num[i] = num[start];
			num[start] = temp;
			function_02(num, start+1, result);
			temp = num[i];
			num[i] = num[start];
			num[start] = temp;
			
		}	
		
	}
	
	/**
	 * 
	 * 无重复组合问题
	 * 
	 * */
	public static void function_03(String str){
		for(int i=0;i<str.length();i++){
			StringBuffer sb = new StringBuffer();
			for(int j=i;j<str.length();j++){
				sb.append(str.charAt(j));
				System.out.println(sb);
			}
		}
	}
	
	/**
	 * 有重复组合问题
	 * 
	 * */
	public static void function_04(String str){
		Set<String> result = new HashSet<>();
		for(int i=0;i<str.length();i++){
			StringBuffer sb = new StringBuffer();
			for(int j=i;j<str.length();j++){
				sb.append(str.charAt(j));
				result.add(sb.toString());
			}
		}
		for(String s:result){
			System.out.println(s);
		}
	}

}
