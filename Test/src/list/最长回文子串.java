package list;

public class 最长回文子串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ab";
		function_00(str);
		function_01(str);
		function_02(str);
		
		float f = 0.00000000001f;
		if(Math.abs(f-0.0)<0.000001){
			System.out.println("是零值");
		}
		else{
			System.out.println("不是零值");
		}
		
	}
	
	public static void function_00(String str){
		int length = str.length();
		int max = 0;
		int start=0;
		
		for(int i=0;i<length;i++){	//长度为奇数
			int j=i-1;
			int k=i+1;
			while(j>=0&&k<length&&str.charAt(j)==str.charAt(k)){
				if(k-j+1>max){
					max = k-j+1;
					start = j;
				}
				j--;
				k++;
			}
		}
		
		for(int i=0;i<length;i++){	//长度为偶数
			int j=i;
			int k=i+1;
			while(j>=0&&k<length&&str.charAt(j)==str.charAt(k)){
				if(k-j+1>max){
					max = k-j+1;
					start = j;
				}
				j--;
				k++;
			}
		}
		
		if(max>0){
			System.out.println(str.substring(start, max));
		}
	}
	
	
	/**
	 * 有问题
	 * 
	 * */
	public static void function_01(String str){
		int max = 0;
		int center = 0;
		for(int i=0;i<str.length();i++){
			int j= 1;
			while(i+j<str.length()&&i-j>=0&&str.charAt(i-j)==str.charAt(i+j)){
				j++;
			}
			j--;
			if(j>1&&j>max){
				max = j;
				center = i;
			}
		}
		
		System.out.println(str.substring(center-max, center+max+1));
	}
	
	/**
	 * 把字符串逆序，求两个串的最长公共子串
	 * 有问题
	 * */
	public static void function_02(String str){
		String temp = new StringBuffer(str).reverse().toString();
		//System.out.println(temp+"jjj");
		System.out.println(func(str, temp));
		
		
	}
	
	public static String func(String str1,String str2){
		int max = 0;
		int end = 0;
		int temp[] = new int[str2.length()];
		for(int i=0;i<str1.length();i++){
			int tempvalue = 0;
			for(int j=0;j<str2.length();j++){
				if(str1.charAt(i)==str2.charAt(j)){
					if(i==0||j==0){
						tempvalue = temp[j];
						temp[j] = 1;
					}
					else{
						int tem = temp[j];
						temp[j] = tempvalue+1;
						tempvalue = tem;
					}
					
					if(max<temp[j]){
						max = temp[j];
						end = j;
					}
				}
				else{
					tempvalue = temp[j];
					temp[j] = 0;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		/*for(int i=end-max+1;i<end+1;i++){
			sb.append(str2.charAt(i));
		}*/
		for(int i=end;i>=end-max+1;i--){
			sb.insert(0, str2.charAt(i));
		}
		return sb.toString();
		
		
	}

}
