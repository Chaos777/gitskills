import java.util.Vector;

public class Lsc {

	

	public static void main(String args[]) {

		String query = "acbac";
		String text = "acaccbabb";
		System.out.println(getMaxSubStr(text, query));
		System.out.println(function_01(query, text));
		System.out.println(function_02(query, text));
		System.out.println(function_03(text, query));
		System.out.println(function_04(text, query));

	}
	
	
	/**
	 *暴力破解 
	 * 
	 * */
	public static int function_01(String str1,String str2){
		int maxLen = 0;
		for(int i=0;i<str1.length();i++){
			for(int j=0;j<str2.length();j++){
				int tempLength = 0;
				int m = i;
				int n = j;
				while(m<str1.length()&&n<str2.length()){
					if(str1.charAt(m)!=str2.charAt(n)){
						break;
					}
					m++;
					n++;
					tempLength++;
				}
				if(tempLength>maxLen){
					maxLen = tempLength;
				}
			}
		}
		
		return maxLen;
	}
	
	
	/**
	 *动态规划---二维数组 
	 * 
	 * 
	 * */
	public static int function_02(String str1,String str2){
		int maxLength = 0 ;
		int m = str1.length();
		int n = str2.length();
		int dim[][] = new int[m][n];		
		for(int i=0;i<m;i++){
			for(int j = 0;j<n;j++){
				if(str1.charAt(i)==str2.charAt(j)){
					dim[i][j] = 1;
					if(maxLength<dim[i][j]){
						maxLength = dim[i][j];
					}
					if((i-1)>=0&&(j-1)>=0){
						dim[i][j] = dim[i-1][j-1]+1;
						if(maxLength<dim[i][j]){
							maxLength = dim[i][j];
						}
					}
				}
			}
		}
		
		/*for(int i=0;i<dim.length;i++){
			for(int j=0;j<dim[i].length;j++){
				System.out.print(dim[i][j]);
			}
			System.out.println();
		}*/
		
		return maxLength;
	}
	
	
	/**
	 * 动态规划--就保存两行信息，前一行与当前行
	 * 
	 * */
	public static int function_03(String str1,String str2){
		int maxLength = 0;
		int [] preNum = new int[str1.length()];
		int [] nowNum = new int[str1.length()];
		for(int i= 0;i<str2.length();i++){
			for(int j=0;j<str1.length();j++){
				if(str1.charAt(j)==str2.charAt(i)){
					nowNum[j] = 1;
					if(maxLength<nowNum[j]){
						maxLength = nowNum[j];
					}
					if((j-1)>=0){
						nowNum[j] = preNum[j-1]+1;
						if(maxLength<nowNum[j]){
							maxLength = nowNum[j];
						}
					}
				}
			}
			/*for(int l:nowNum){
				System.out.print(l);
			}
			System.out.println();*/
		//	preNum = nowNum;
			for(int k = 0;k<nowNum.length;k++){
				preNum[k] = nowNum[k];
				nowNum[k] = 0;
			}
		}
		
		return maxLength;
	}
	
	
	/**
	 *动态规划 同上，只是用了较少的空间
	 * 
	 * */
	public static int getMaxSubStr(String query, String text) {
		int queryLen = query.length();
		
		Vector<Integer> dinamic = new Vector<>();
		for(int i=0;i<queryLen;i++){
			dinamic.add(0);			
		}

		int maxLen = 0;

		int textLen = text.length();
		for (int i = 0; i < textLen; i++) {
			// 记录上次的d[j-1]值
			int tmpValue = 0;
			for (int j = 0; j < queryLen; j++) {
				if (text.charAt(i) == query.charAt(j)) {
					if (i == 0 || j == 0) {
						tmpValue = dinamic.get(j);
						dinamic.set(j, 1);
					} else {
						int tmp = dinamic.get(j);
						dinamic.set(j, tmpValue + 1);
						tmpValue = tmp;
					}
					if (dinamic.get(j) > maxLen)
						maxLen = dinamic.get(j);
				} else {
					tmpValue = dinamic.get(j);
					dinamic.set(j, 0);
				}
			}
		}
		return maxLen;
	}
	
	/**
	 *动态规划 同上，只是用了较少的空间
	 * 
	 * */
	public static int function_04(String query, String text) {
		int queryLen = query.length();
		
		int [] dinamic = new int[queryLen];

		int maxLen = 0;

		int textLen = text.length();
		for (int i = 0; i < textLen; i++) {
			// 记录上次的d[j-1]值
			int tmpValue = 0;
			for (int j = 0; j < queryLen; j++) {
				if (text.charAt(i) == query.charAt(j)) {
					if (i == 0 || j == 0) {
						tmpValue = dinamic[j];
						dinamic[j]= 1;
					} else {
						int tmp = dinamic[j];
						dinamic[j]=tmpValue + 1;
						tmpValue = tmp;
					}
					if (dinamic[j] > maxLen)
						maxLen = dinamic[j];
				} else {
					tmpValue = dinamic[j];
					dinamic[j]= 0;
				}
			}
		}
		return maxLen;
	}
	
	

}
