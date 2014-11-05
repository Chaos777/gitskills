package offer;

public class ������ʮ��_��ת����������ת�ַ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "i am a student.";
		System.out.println(ReverseSentence(str));
		
		String string = "abcdefghij";
		System.out.println(LeftRotateString_02(string, 2));
		System.out.println(LeftRotateString_02(string, 2));
	}
	
	/**
	 *��ת�ַ��� 
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
	 *��ת���� 
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
	 *�����ַ���
	 *��һ�� 
	 * */
	public static String LeftRotateString_01(String str,int n){
		if(str!=null){
			int length = str.length();
			if(length>0&&n<length&&n>0){
				char temp[] = str.toCharArray();
				Reverce(temp, 0, n-1);						//ǰ�벿��
				Reverce(temp, n, length-1);					//��벿��
				Reverce(temp, 0, length-1);					//����
				
				return new String(temp);
			}
		}
		return str;
	}
	/**
	 *�����ַ���
	 *������ ����substring
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
