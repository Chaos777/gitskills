package list;

public class 最长不重复子串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdeab";
		function_01(str);
	}
	
	public static void function_01(String str){
		
		int maxlen = 0;
		int maxindex = 0;
		int dp[] = new int[str.length()];
		dp[0] = 1;
		for(int i=1;i<str.length();i++){
			int j;
			for(j=i-1;j>=0;j--){
				if(str.charAt(i)==str.charAt(j)){
					dp[i] = i-j;
					break;
				}
			}
			if(j==-1){
				dp[i] = dp[i-1]+1;
			}
			if(dp[i]>maxlen){
				maxlen = dp[i];
				maxindex = i+1-maxlen;
			}
		}
	//	System.out.println(maxlen+"ll"+maxindex);
		StringBuffer sb = new StringBuffer();
		for(int i=maxindex;i<=maxindex+maxlen-1;i++){
			sb.append(str.charAt(i));
		}
		
		System.out.println(sb.toString());
	}

}
