package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Ten {

	public static void main(String args[]) {
		function_01("7", 3, '4');
		function_02("-name jack -age 20 -address \"HangZhou ZheDa Road   \"   ");
		function_03("abcdefe", "aabcadef");

		int num[] = { 1, 3, 4, 6, 8, 9, 11 };
		int key = 6;
		System.out.println(function_04(num, key));

		function_05("qywyer23tdd");

		int num1 = 0x7ff007ef;
		System.out.println(num1);
		
		function_06("2014-12-31 23:59:59",0);
		
		function_07(num1);
		
		f();
		
		function(4);
		
		func("i am a student.");
	}

	public static void function_01(String source, int minlength, char c) {
		if (source == null) {
			System.out.println("输入原始字符串为空");
			return;
		}
		if (source.length() >= minlength) {
			System.out.println(source);
			return;
		}
		int grip = minlength - source.length();
		StringBuffer sb = new StringBuffer();
		while (grip > 0) {
			sb.append(c);
			grip--;
		}
		sb.append(source);
		System.out.println(sb.toString());

	}

	public static void function_02(String str) {
		if (str == null || str.length() == 0) {
			System.out.println("输入子串有误！");
			return;
		}
		String list[] = str.split("-");
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < list.length; i++) {
			list[i] = list[i].trim();
			list[i] = list[i].replaceAll(" {1,}", " ");
			if (list[i].length() != 0) {
				sb.append("-");
				sb.append(list[i]);
				if (i != list.length - 1) {
					sb.append(",");
				}
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	public static void function_03(String str1, String str2) {
		int[] temp = new int[255];
		for (char c : str1.toCharArray()) {
			temp[c]++;
		}
		for (char c : str2.toCharArray()) {
			temp[c]--;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < temp.length; i++) {
			while (temp[i] > 0) {
				sb.append("-" + (char) i + ",");
				temp[i]--;
			}
			while (temp[i] < 0) {
				sb.append("+" + (char) i + ",");
				temp[i]++;
			}
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		System.out.println(sb);
	}

	public static int function_04(int[] num, int key) {
		if (num.length != 0) {
			int low = 0;
			int high = num.length - 1;
			int mid;
			while (low <= high) {
				mid = low + ((high - low) >> 1);
				if (num[mid] == key) {
					return mid;
				} else if (num[mid] > key) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void function_05(String str) {
		if (str == null || str.length() == 0) {
			System.out.println("输入字符串为空！");
			return;
		}
		Map<Character, Integer> temp = new HashMap<>();
		for (char c : str.toCharArray()) {
			if (temp.containsKey(c)) {
				System.out.println("第一个出现两次的字符是" + c);
				return;
			} else {
				temp.put(c, 1);
			}
		}
	}

	public static void function_06(String str, int n) {
		String temp[] = str.split(" ");
		String hour[] = temp[1].split("\\:");
		int j = 0;
		
		int tj = (Integer.parseInt(hour[2]) + n + j) / 60;
		hour[2] = String.valueOf((Integer.parseInt(hour[2]) + n + j) % 60);
		j = tj;
		
		tj = (Integer.parseInt(hour[1]) +  j) / 60;
		hour[1] = String.valueOf((Integer.parseInt(hour[1]) +  j) % 60);		
		j = tj;
		
		tj = (Integer.parseInt(hour[0]) +  j) / 24;
		hour[0] = String.valueOf((Integer.parseInt(hour[0]) + j) % 24);
		j = tj;
		
		String date[] = temp[0].split("\\-");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		int leapYaer = ((year%400==0)||(year%4==0&&year%100!=0))?1:0;
		
		int month_date[]={31,28,31,30,31,30,31,31,30,31,30,31};
		int sum = day+j;
		
		do{
			if(month==2){
				month_date[month-1] += leapYaer; 
			}
			if(sum>month_date[month-1]){
				sum -= month_date[month-1];
				month++;
				if(month==13){
					year++;
					if((year%400==0)||(year%4==0&&year%100!=0)){
						leapYaer = 1;
					}
					else{
						leapYaer = 0; 
					}
					month=1;
				}
			}
			month_date[1] = 28;
		}while(sum>month_date[month-1]);
		
		day = sum;
		
		StringBuffer sb = new StringBuffer();
		date[0] = year+"";
		date[1] = month+"";
		date[2] = day+"";
		for(String s:date){
			if(s.length()<2){
				sb.append("0");
			}
			sb.append(s+"-");
		}
		sb.deleteCharAt(sb.lastIndexOf("-"));
		sb.append(" ");
		for(String s:hour){
			if(s.length()<2){
				sb.append("0");
			}
			sb.append(s+":");
		}
		sb.deleteCharAt(sb.lastIndexOf(":"));
		System.out.println(sb);
		
		
		
		
		
		

	}

	public static void function_07(int num) {
		StringBuffer sb = new StringBuffer();
		while (num > 0) {
			int tem = num % 2;
			num = num / 2;
			sb.insert(0, tem);
		}
		System.out.println(sb);
	}
	
	
	public static void f(){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+(i*j)+" ");
			}
			System.out.println();
		}
	}
	
	public static void function(int n){
		long n1=1;
		long n2=1;
		long result=0l;
		if(n<=0){
			System.out.println("输入有误");
			return;
		}
		else if(n==1||n==2){
			System.out.println(1);
			return;
		}
		else{
			for(int i=2;i<=n;i++){
				result=n2;
				n2=n1+n2;
				n1=result;
			}
		}
		
		System.out.println(result);
	}
	
	public static void Reaverse(char[]temp,int begin,int end){
		if(temp.length<2||begin>end){
			return;
		}
		while(begin<end){
			char t = temp[begin];
			temp[begin] = temp[end];
			temp[end] = t;
			
			begin++;
			end--;
		}
	}
	
	public static void func(String str){
		char [] str1 = str.toCharArray();
		int begin = 0;
		int end = str.length()-1;
		Reaverse(str1, begin, end);
		System.out.println(new String(str1));
		begin =0;
		end  =0;
		while(begin<str.length()){
			if(str1[begin]==' '){
				begin++;
				end++;
			}
			else if(end==str.length()||str1[end]==' '){
				Reaverse(str1, begin, --end);
				begin = ++end;
			}
			else{
				end++;
			}
		}
		
		System.out.println(new String(str1));
	}
	
	public static void fu()throws Exception{
		InputStreamReader in = new InputStreamReader(new FileInputStream(new File("")),"utf-8");
		BufferedReader bf = new BufferedReader(in);
		String line;
		while(null!=(line=bf.readLine())){
			
		}
		bf.close();
		
		
		OutputStreamWriter ou = new OutputStreamWriter(new FileOutputStream(new File(""),true),"utf-8");
		BufferedWriter bw = new BufferedWriter(ou);
		bw.write("");
		bw.close();
		
	}

}
