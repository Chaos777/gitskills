package test;

import java.io.UnsupportedEncodingException;

public class 中英文混合截取 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str = "我gfr是chinese";
		System.out.println(cutString(str, 1));
		System.out.println(cutString(str, 2));
		System.out.println(cutString(str, 6));
		System.out.println(cutString(str, 7));
	}
	
	public static boolean isChinese(char c) throws UnsupportedEncodingException{
		return String.valueOf(c).getBytes("GBK").length>1;
	}
	
	public static String cutString(String str,int count) throws UnsupportedEncodingException{
		StringBuffer sb = new StringBuffer();
		if(str!=null&&!"".equals(str)){
			str = new String(str.getBytes(),"GBK");
			if(count>0&&count<str.length()){
				char c ;
				for(int i=0;i<count-1;i++){
					c = str.charAt(i);
					sb.append(c);
					if(isChinese(c)){
						--count;
					}
				}				
				
			}
			
			
		}
		return sb.toString();
	}

}
