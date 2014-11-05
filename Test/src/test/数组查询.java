package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 数组查询 {
	
	/**
	 * 问题一、一个升序数组A[M] ,数字可以重复，比如 1 2 2 3 4 5 6 7 8 8 8 9 ，
	 * 给定一个区间，[2,8],输出所有符合这个区间的数，即包括重复的2和8.
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num = {1,2,2,3,4,5,6,7,8,8,8,9};
		int min = 2;
		int max = 8;
		function(num, min, max);
		
		function("che");
		
		String str1 = "数据对比";
		char [] temp = {'数','据','对','比'};
		System.out.println(str1.equals(temp));
	
	}
	
	public static void function(int []num,int min,int max){
		String temp = Arrays.toString(num);
		System.out.println(temp.substring(temp.indexOf(min+""),temp.lastIndexOf(max+"")+1));
	}
	
	public static void function(String str){
		Map<String, List<String>> resultMap  = new HashMap<>();
		List<String> temp1 = new ArrayList<>();
		temp1.add("啊");
		temp1.add("阿");
		temp1.add("嗄");
		resultMap.put("a", temp1);
		
		List<String> temp2 = new ArrayList<>();
		temp2.add("爱");
		temp2.add("艾");
		temp2.add("哎");
		resultMap.put("ai", temp2);
		
		List<String> temp3 = new ArrayList<>();
		temp3.add("车");
		temp3.add("扯");
		temp3.add("撤");
		resultMap.put("che", temp3);
		
		List<String> rList = resultMap.get(str);
		if(rList.size()==0){
			System.out.println("暂无信息");
		}
		else{
			System.out.println(rList.get(0));
		}
	}
	
	

}
