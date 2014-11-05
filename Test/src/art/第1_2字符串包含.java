package art;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 第1_2字符串包含 {
	
	
	/***
	 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
	 * 为了简单起见，我们规定输入的字符串只包含大写英文字母，请实现函数bool StringContains(string &A, string &B)
	 * 比如，如果是下面两个字符串：
	 * String 1：ABCD
	 * String 2：BAD
	 * 答案是true，即String2里的字母在String1里也都有，或者说String2是String1的真子集。
	 * 如果是下面两个字符串：
	 * String 1：ABCD
	 * String 2：BCE
	 * 答案是false，因为字符串String2里的E字母不在字符串String1里。
	 * 同时，如果string1：ABCD，string 2：AA，同样返回true。 
	 * 
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char str1[] = {'S','A','D'};
		char str2[] = {'A','B','C','D'};
		System.out.println(function_01(str1, str2));
		System.out.println(function_02(str1, str2));
		System.out.println(function_03(str1, str2));
	}
	
	/***
	 * 法一：暴力破解发
	 * str1的字符是否是出现在str2中
	 * */
	public static boolean function_01(char [] str1,char [] str2){
		for(int i=0;i<str1.length;i++){
			int j;
			for(j=0;j<str2.length&&str1[i]!=str2[j];j++){				
			}
			if(j>=str2.length){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * hash
	 * 
	 * */
	public static boolean function_02(char []str1,char []str2){
		
		List<Character> temp = new ArrayList<>();
		for(char s:str2){
			temp.add(s);
		}
		for(int i=0;i<str1.length;i++){
			if(!temp.contains(str1[i])){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 先排序
	 * 
	 * */
	public static boolean function_03(char [] str1,char []str2){
		Arrays.sort(str1);
		Arrays.sort(str2);
		for(int i=0,j=0;i<str1.length;i++){
			while(j<str2.length&&(str2[j]<str1[i])){
				j++;
			}
			if(j>=str2.length||(str2[j]>str1[i])){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 如果两个字符串的字符一样，但是顺序不一样，
	 * 被认为是兄弟字符串，比如bad和adb即为兄弟字符串，
	 * 现提供一个字符串，如何在字典中迅速找到它的兄弟字符串，请描述数据结构和查询过程。
	 * 
	 * 法一：排序之后比较是否一致
	 * 
	 * 法二：hash
	 * 
	 * 法三：素数对应
	 * 
	 * */

}
