package task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Qunar {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int num[] = {1,3,4,6,8,9};
		int key = 4;
//		System.out.println(function(num, key));
		
		
		String str = "qywyer23tdd";
//		System.out.println(function(str));
		
		String filename = "E:\\Workspaces\\EclipseJAVA\\Test\\src\\task\\task.txt";
		function_Order(filename);
		functionReadFile(filename);
		
//		System.out.println(function("",10,'3'));
		
		System.out.println(function_new("-name jack -age 20 -address \"HangZhou ZheDa Road   \"   "));
		
//		functionStr("abcdefe","aabcadef ");
		
		
		int a[]= {1,3,5,7,9,11,13,14,0,0,0,0,0,0,0,0};
		int b[]= {2,4,5,6,8,10,13,15};
		sort(a, b, 8, b.length);
		for(int i=0;i!=7+b.length;i++){
			System.out.print(a[i]+" ");
		}
		
		System.out.println();
		Stack<Integer> tempStack = new Stack<>(10);
		tempStack.push(2);
		tempStack.push(2);
		tempStack.push(2);
		tempStack.push(2);
		tempStack.push(2);
		tempStack.push(2);
		tempStack.push(2);
		tempStack.push(2);
		tempStack.push(2);
		tempStack.push(7);
		
		System.out.println(tempStack.getSize()+";"+tempStack.peek());
		
		int numt[] ={3,32,321};
		fun(numt);
		
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<100;i++){
			list.add(i);
		}
		
		Iterator<Integer> lIterator = list.iterator();
		while(lIterator.hasNext()){
			lIterator.next();
			lIterator.remove();
		}
		System.out.println(list.size());
		
		Set<Character> set = new LinkedHashSet<>();
		set.add('c');
		set.add('a');
		set.add('b');
		set.add('a');
		set.add('c');
		
		for(char c:set){
			System.out.print(c+" ");
		}
		System.out.println();
		String string = "a++abc";
		String p[] = string.split("\\+");
		for(String s:p){
			s = s.replaceAll("\\s+", "");
			if(s.equals(" ")||s.equals("")||s==null){
				
			}
			else{
				System.out.println(s);
			}
		}
		
		int n = -1;
		toHex(n);
		
	}
	
	public static int function(int num[],int key){
		int begin = 0;
		int end = num.length-1;
		while(begin<=end){
			int mid = begin+((end-begin)>>1);
			if(num[mid]==key){
				return mid;
			}
			else if(num[mid]>key){
				end = mid-1;
			}
			else{
				begin = mid+1;
			}
		}
		
		return -1;
	}
	
	public static char function(String str){
		char [] temp  = str.toCharArray();
		Map<Character, Integer> tMap = new HashMap<>();
		for(char c:temp){
			if(tMap.containsKey(c)){
				
				tMap.put(c, tMap.get(c)+1);
				return c;
			}
			else{
				tMap.put(c, 1);
			}
		}		
		
		
		return ' ';
	}
	
	public static void function_Order(String filename) throws Exception{
		
		InputStreamReader in = new InputStreamReader(new FileInputStream(new File(filename)),"utf-8");
		BufferedReader bf = new BufferedReader(in);
		String line;
		List<Myclas> list = new ArrayList<Myclas>();
		while(null!=(line = bf.readLine())){
			System.out.println(line);
			String [] temp = line.split(" ");
			int count = 0;
			for(String s:temp){
				if(s.equalsIgnoreCase("your")){
					count++;
				}
			}
			Myclas c = new Myclas(line, count);
			list.add(c);
			
		}	
		
		bf.close();
		
		Collections.sort(list, new Comparator<Myclas>() {

			@Override
			public int compare(Myclas o1, Myclas o2) {
				// TODO Auto-generated method stub
				/*return o2.getCont()-o1.getCont();*/
				if(o1.getCont()>o2.getCont()){
					return -1;
				}
				else if(o1.getCont()==o2.getCont()){
					return 0;
				}
				else{
					return 1;
				}
			}
		});
		
		for(Myclas c:list){
			System.out.println(c);
		}
	}
	
	public static String function(String str,int miniLength,char c){
		if(str==null){
			return "输入有问题str不能为空";
		}
		if(miniLength<=str.length()){
			return str;
		}
		int grip = miniLength-str.length();
		StringBuffer sb = new StringBuffer();
		while(grip>0){
			sb.append(c);
			grip--;
		}
		sb.append(str);
		return sb.toString();
	}
	
	public static String function_new(String stemp){
		String temp[] = stemp.split("-");
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0;i<temp.length;i++){
			temp[i] = temp[i].trim();
			temp[i] = temp[i].replaceAll("\\s+", " ");
			if(temp[i].length()!=0&&!temp[i].equals(" ")){
				sb.append("-");
				sb.append(temp[i]);  
                if(i!=temp.length-1){  
                    sb.append(", ");  
                } 
			}
		}
		sb.append("]");
		
		return sb.toString();
		
	}	
	
	public static void functionStr(String str1,String str2){
		str1 = str1.trim().toLowerCase();
		str2 = str2.trim().toLowerCase();
		int temp[] = new int[26];
		for(int i=0;i<str1.length();i++){
			temp[str1.charAt(i)-'a']++;
		}
		
		for(int i=0;i<str2.length();i++){
			temp[str2.charAt(i)-'a']--;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<temp.length;i++){
			if(temp[i]>0){
				int grip = temp[i];
				while(grip>1){
					sb.append("-"+(char)(i+'a')+",");
					grip--;
				}
				sb.append("-"+(char)(i+'a'));
				
			}
			
			if(temp[i]<0){
				int grip = Math.abs(temp[i]);
				while(grip>0){
					sb.append("+"+(char)(i+'a')+",");
					grip--;
				}			
				
			}
		}
		if(sb.lastIndexOf(",")==sb.length()-1){
			sb.deleteCharAt(sb.length()-1);
		}
		
		System.out.println(sb.toString());
	}
	
	
	public static void functionReadFile(String filename) throws IOException{
		InputStreamReader in = new InputStreamReader(new FileInputStream(new File(filename)),"utf-8");
		BufferedReader bf = new BufferedReader(in);
		String line;
		while(null!=(line=bf.readLine())){
			System.out.println(line);
		}
		
		bf.close();
		
	}
	
	/**
	 * 2013年的改错题
	 * 
	 * */
	public static void sort(int []a,int []b,int lastA,int lastB){
		int indexA = lastA-1;
		int indexB = lastB-1;
		int indexAll = lastA+lastB-1;
		
		while(indexA>=0&&indexB>=0){
			if(a[indexA]>b[indexB]){
				a[indexAll--] = a[indexA--];
			}
			else{
				a[indexAll--] = b[indexB--];
			}
		}
		while(indexA>=0){
			a[indexAll--] = a[indexA--];
		}
		while(indexB>=0){
			a[indexAll--] = b[indexB--];
		}
	}
	
	
	public static boolean  ComString(String str1,String str2)//是否交换
    {
        int s1=Integer.parseInt(str1);
        int s2=Integer.parseInt(str2);
        int stm1 = 1, stm2 = 1;
        for (int k = 0; k < str1.length(); k++) {
            stm1 *= 10;
        }
        
        for (int k = 0; k < str2.length(); k++) {
            stm2 *= 10;
        }
        if((s1*stm2+s2)>(s2*stm1+s1)){
              return true;
        }
        
        return false;
               
    }

	
	public static void fun(int []num){
		List<String> temp = new ArrayList<>();
		for(int i:num){
			temp.add(i+"");
		}
		Collections.sort(temp);
		
		int s=1;
        for (int i = 0; i < temp.size() - 1; i++) {
            
            while((i+s)<temp.size()&&temp.get(i).charAt(0)==temp.get(i+s).charAt(0)){
                  ++s;
            }
            s--;
            for(int j=0;j<s;j++)
                for(int m=1;m<=(s-j);m++)
                    if(ComString(temp.get(i+j),temp.get(i+j+m)))
                    {
                        
                        String temp1 = temp.get(i+j);
                        temp.set(i+j,temp.get(i+j+m));
                        temp.set(i+j+m,temp1);
                    }
            i=i+s+1;
        }

		
		
		StringBuffer sb = new StringBuffer();
		for(String s1:temp){
			sb.append(s1);
		}
		
		System.out.println(sb);
	}
	
	public static void toHex(int n){
		String hex[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		long num = n;
		if(n<0){
			num = (long) Math.pow(2, 32)+n;
		}
		
		StringBuffer sb = new StringBuffer();
		if(num==0){
			sb.append("0");
		}
		while(num>0){
			int tem = (int)(num%16);
			sb.insert(0, hex[tem]);
			num = num/16;
		}
		
		System.out.println(sb.toString());
		System.out.println(Integer.toHexString(n));
	}
	


}

class Myclas{
	private String stence;
	private int cont;
	
	public Myclas(String s,int c){
		this.stence = s;
		this.cont = c;
	}

	public String getStence() {
		return stence;
	}
	
	public int getCont() {
		return cont;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+stence+": "+cont+"]";
	}
	
}

class Stack<T>{
	Object[]data;
	int maxSize;
	int top;
	
	public Stack(int maxSize){
		this.maxSize = maxSize;
		top = -1;
		data = new Object[this.maxSize];
		
	}
	
	public int getSize(){
		return top+1;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public boolean isFull(){
		return top+1==maxSize;
	}
	
	public T peek(){
		if(isEmpty()){
			return null;
		}
		return (T)data[getSize()-1];
		
	}
	
	public boolean push(T d){
		if(isFull()){
			System.out.println("栈已满");
			return false;
		}
		
		data[++top] = d;			
		
		return true;
	}
	
	public T pop(){
		if(isEmpty()){
			System.out.println("栈为空");
			return null;
		}
		return (T)data[top--];
	}

	

	
	
}
