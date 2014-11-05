package art;

public class 第1_1旋转字符串 {
	
	
	/**
	 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
	 * 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] str = {'a','b','c','d','e','f'};
	//	function_01(str, 2);
	//	str = function_02(str, 2);
		function_03(str, 2);
		for(char c:str){
			System.out.print(c);
		}
	}
	
	/**
	 * 法一：暴力破解法
	 * 
	 * */
	public static void function_01(char[] str,int m){
		for(int i=0;i<m;i++){
			char temp = str[0];
			for(int j=1;j<str.length;j++){
				str[j-1] = str[j];
			}
			str[str.length-1] = temp;
		}
	}
	
	/**
	 *法：三次翻转 
	 * 
	 * */
	public static void function_03(char[]str,int m){
		m = m%str.length;			//m大于长度时用取余的方法
		func(str, 0, m-1);
		func(str, m, str.length-1);
		func(str, 0, str.length-1);
	}
	/**
	 * 
	 *翻转方法 
	 * */
	public static void func(char[] str,int begin,int end){
		while(begin<end){
			char temp = str[begin];
			str[begin++] = str[end];
			str[end--] = temp;
		}
	}
	
	/**
	 * 法二：java substring
	 *  
	 * */
	public static char[] function_02(char [] str,int m){
		String temp = String.valueOf(str);
		temp = temp.substring(m)+temp.substring(0, m);
		return temp.toCharArray();
	}
	
	/***
	 * 1、链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，
	 * 则翻转后2→1→6→5→4→3，若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
	 * 方法：分别翻转再拼接
	 * 
	 * 2、编写程序，在原字符串中把字符串尾部的m个字符移动到字符串的头部，要求：长度为n的字符串操作时间复杂度为O(n)，
	 * 空间复杂度为O(1)。 例如，原字符串为”Ilovebaofeng”，m=7，输出结果为：”baofengIlove”。
	 * 
	 * 先整个翻转再分别翻转
	 * 
	 * 3、单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。
	 * 为简单起见，标点符号和普通字母一样处理。例如，输入“I am a student.”，则输出“student. a am I”。
	 * 
	 * 下整个翻转再单词内部翻转* 
	 * 
	 * 
	 * */

}
