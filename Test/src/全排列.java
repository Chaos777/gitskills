
public class 全排列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {1,2,3,4};
		function(num, 0);
		
		String str = "abcd";
		function(str);
	}
	
	/**
	 * 排列问题*/
	public static void function(int []num,int start){
		if(start>=num.length){
			StringBuffer sb = new StringBuffer();
			for(int i:num){
				sb.append(i);
			}
			System.out.println(sb);
			return;
		}
		
		for(int i = start;i<num.length;i++){
			int temp = num[i];
			num[i] = num[start];
			num[start] = temp;
			
			function(num, start+1);
			
			temp = num[i];
			num[i] = num[start];
			num[start] = temp;
		}
		
	}
	
	/**组合问题*/
	public static void function(String str){
		for(int i=0;i<str.length();i++){
			//System.out.println(str.charAt(i));
			StringBuffer sb = new StringBuffer(str.charAt(i));
			for(int j=i;j<str.length();j++){
				
				sb.append(str.charAt(j));
				System.out.println(sb);
				
			}
		}
	}

}
