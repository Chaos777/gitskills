package art;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ��1_2�ַ������� {
	
	
	/***
	 * ���������ֱ�����ĸ��ɵ��ַ���A���ַ���B���ַ���B�ĳ��ȱ��ַ���A�̡����ʣ���������ж��ַ���B��������ĸ�Ƿ����ַ���A�
	 * Ϊ�˼���������ǹ涨������ַ���ֻ������дӢ����ĸ����ʵ�ֺ���bool StringContains(string &A, string &B)
	 * ���磬��������������ַ�����
	 * String 1��ABCD
	 * String 2��BAD
	 * ����true����String2�����ĸ��String1��Ҳ���У�����˵String2��String1�����Ӽ���
	 * ��������������ַ�����
	 * String 1��ABCD
	 * String 2��BCE
	 * ����false����Ϊ�ַ���String2���E��ĸ�����ַ���String1�
	 * ͬʱ�����string1��ABCD��string 2��AA��ͬ������true�� 
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
	 * ��һ�������ƽⷢ
	 * str1���ַ��Ƿ��ǳ�����str2��
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
	 * ������
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
	 * ��������ַ������ַ�һ��������˳��һ����
	 * ����Ϊ���ֵ��ַ���������bad��adb��Ϊ�ֵ��ַ�����
	 * ���ṩһ���ַ�����������ֵ���Ѹ���ҵ������ֵ��ַ��������������ݽṹ�Ͳ�ѯ���̡�
	 * 
	 * ��һ������֮��Ƚ��Ƿ�һ��
	 * 
	 * ������hash
	 * 
	 * ������������Ӧ
	 * 
	 * */

}
