package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class �����ѯ {
	
	/**
	 * ����һ��һ����������A[M] ,���ֿ����ظ������� 1 2 2 3 4 5 6 7 8 8 8 9 ��
	 * ����һ�����䣬[2,8],������з����������������������ظ���2��8.
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num = {1,2,2,3,4,5,6,7,8,8,8,9};
		int min = 2;
		int max = 8;
		function(num, min, max);
		
		function("che");
		
		String str1 = "���ݶԱ�";
		char [] temp = {'��','��','��','��'};
		System.out.println(str1.equals(temp));
	
	}
	
	public static void function(int []num,int min,int max){
		String temp = Arrays.toString(num);
		System.out.println(temp.substring(temp.indexOf(min+""),temp.lastIndexOf(max+"")+1));
	}
	
	public static void function(String str){
		Map<String, List<String>> resultMap  = new HashMap<>();
		List<String> temp1 = new ArrayList<>();
		temp1.add("��");
		temp1.add("��");
		temp1.add("��");
		resultMap.put("a", temp1);
		
		List<String> temp2 = new ArrayList<>();
		temp2.add("��");
		temp2.add("��");
		temp2.add("��");
		resultMap.put("ai", temp2);
		
		List<String> temp3 = new ArrayList<>();
		temp3.add("��");
		temp3.add("��");
		temp3.add("��");
		resultMap.put("che", temp3);
		
		List<String> rList = resultMap.get(str);
		if(rList.size()==0){
			System.out.println("������Ϣ");
		}
		else{
			System.out.println(rList.get(0));
		}
	}
	
	

}
