package list;

public class 最长公共子串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "bab";
		String str2 = "caba";
		System.out.println(function_01(str1, str2));
		System.out.println(function_02(str1, str2));
		System.out.println(function_03(str1, str2));
	}
	
	public static int function_01(String str1,String str2){
		int max = 0;
		int m = str1.length();
		int n = str2.length();
		int temp[][] = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(str1.charAt(i)==str2.charAt(j)){
					temp[i][j] = 1;
					if(i>0&&j>0){
						temp[i][j] = temp[i-1][j-1]+1;
					}
					
					if(max<temp[i][j]){
						max= temp[i][j];
					}
				}
			}
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
		
		return max;
	}
	
	public static int function_02(String str1,String str2){
		int max  =0;
		int end = 0;
		int [] pro = new int[str1.length()];
		int [] now = new int[str1.length()];
		for(int i=0;i<str2.length();i++){
			for(int j=0;j<str1.length();j++){
				if(str2.charAt(i)==str1.charAt(j)){
					 now[j] = 1;
					 if(j>0){
						 now[j] = pro[j-1]+1;
					 }
					 if(max<now[j]){
						 max = now[j];
						 end = j;
					 }
				}
			}
			for(int k=0;k<str1.length();k++){
				pro[k] = now[k];
				now[k] = 0;
			}
		}
		
		for(int i=end-max+1;i<end+1;i++){
			System.out.print(str1.charAt(i));
		}
		return max;
	}
	
	public static int function_03(String str1,String str2){
		int max = 0;
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
					}
				}
				else{
					tempvalue = temp[j];
					temp[j] = 0;
				}
			}
		}
		
		return max;
	}
	

}
