package offer;

public class 面试四十二_翻转单词与左旋转字符串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "i am a student.";
		System.out.println(ReverseSentence(str));
		
		String string = "abcdefghij";
		System.out.println(LeftRotateString_02(string, 2));
		System.out.println(LeftRotateString_02(string, 2));
	}
	
	/**
	 *旋转字符串 
	 * 
	 * */ 
	public static void Reverce(char [] str,int begin,int end){
		if(str.length<2||begin==end){
			
			return ;
		}
		
		while(begin<end){
			char temp = str[begin];
			str[begin] = str[end];
			str[end] = temp;
			
			begin++;
			end--;
		}
	}
	
	
	/**
	 *翻转句子 
	 * */
	public static String ReverseSentence(String str){
		if(str==null){
			return null;
		}
		int begin = 0;
		int end = str.length()-1;
		char tempChar[] = str.toCharArray(); 
		Reverce(tempChar, begin, end);
		System.out.println(tempChar);
		begin = 0;
		end = 0;
		while(begin<str.length()){
			if(tempChar[begin]==' '){
				begin++;
				end++;
			}
			else if(end==str.length()||tempChar[end] == ' '){				
				Reverce(tempChar, begin, --end);
				begin = ++end;
			}
			else{
				end++;
			}
		}
		
		return new String(tempChar);
	}
	
	/**
	 *左旋字符串
	 *法一： 
	 * */
	public static String LeftRotateString_01(String str,int n){
		if(str!=null){
			int length = str.length();
			if(length>0&&n<length&&n>0){
				char temp[] = str.toCharArray();
				Reverce(temp, 0, n-1);						//前半部分
				Reverce(temp, n, length-1);					//后半部分
				Reverce(temp, 0, length-1);					//整个
				
				return new String(temp);
			}
		}
		return str;
	}
	/**
	 *左旋字符串
	 *法二： 利用substring
	 * */
	public static String LeftRotateString_02(String str,int n){
		if(str!=null&&n<str.length()&&n>0){
			/*String str1= str.substring(0, n)+"";
			String str2 = str.substring(n)+"";
			return str2+str1;*/
			
			return str.substring(n)+str.substring(0, n);
		}
		
		return str;
	}
	
	

}
