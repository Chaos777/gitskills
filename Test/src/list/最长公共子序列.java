package list;

public class 最长公共子序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "ADEFG";
		String str2 = "ABCDEG";
		/*
		 * int [][]b =getLength(str1, str2); Display(b, str1, str1.length()-1,
		 * str2.length()-1);
		 */
		
		int [][]opt  = LCS(str1, str2);
		for(int i=0;i<opt.length;i++){
			for(int j=0;j<opt[i].length;j++){
				System.out.print(opt[i][j]+" ");
			}
			System.out.println();
		}
		print(opt, str1, str2);
		
		function_01(str1, str2);
	}
	
	
	public static void function_01(String str1, String str2) {  
        char[] a = str1.toCharArray();  
        char[] b = str2.toCharArray();  
        int a_length = a.length;  
        int b_length = b.length;  
        int[][] lcs = new int[a_length + 1][b_length + 1];  
        // 初始化数组   
        for (int i = 0; i <= b_length; i++) {  
            for (int j = 0; j <= a_length; j++) {  
                lcs[j][i] = 0;  
            }  
        }  
        for (int i = 1; i <= a_length; i++) {  
            for (int j = 1; j <= b_length; j++) {  
                if (a[i - 1] == b[j - 1]) {  
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;  
                }  
                if (a[i - 1] != b[j - 1]) {  
                    lcs[i][j] = lcs[i][j - 1] > lcs[i - 1][j] ? lcs[i][j - 1]  
                            : lcs[i - 1][j];  
                }  
            }  
        }  
        // 输出数组结果进行观察   
        for (int i = 0; i <= a_length; i++) {  
            for (int j = 0; j <= b_length; j++) {  
                System.out.print(lcs[i][j]+",");  
            }  
            System.out.println("");  
        }  
        // 由数组构造最小公共字符串   
        int max_length = lcs[a_length][b_length];  
        char[] comStr = new char[max_length];  
        int i =a_length, j =b_length;  
        while(max_length>0){  
            if(lcs[i][j]!=lcs[i-1][j-1]){  
                if(lcs[i-1][j]==lcs[i][j-1]){//两字符相等，为公共字符   
                    comStr[max_length-1]=a[i-1];  
                    max_length--;  
                    i--;j--;  
                }else{//取两者中较长者作为A和B的最长公共子序列   
                    if(lcs[i-1][j]>lcs[i][j-1]){  
                        i--;  
                    }else{  
                        j--;  
                    }  
                }  
            }else{  
                i--;j--;  
            }  
        }  
        System.out.print("最长公共字符串是：");  
        System.out.print(comStr);  
    }  


	public static int[][] LCS(String str1, String str2) {
		int[][] opt = new int[str1.length() + 1][str2.length() + 1];

		for(int i=0;i<=str1.length();i++){
			for(int j=0;j<=str2.length();j++){
				opt[i][j] = 0;
			}
		}

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					opt[i][j] = opt[i - 1][j - 1] + 1;
				} else {
					opt[i][j] = (opt[i - 1][j] >= opt[i][j - 1] ? opt[i - 1][j]
							: opt[i][j - 1]);
				}
			}
		}

		return opt;
	}

	public static void print(int[][] opt, String X, String Y) {

		StringBuffer sb = new StringBuffer();
		for(int i= X.length(),j=Y.length();i>0&&j>0;){
			if(X.charAt(i-1)==Y.charAt(j-1)){
				sb.insert(0, X.charAt(i-1));
				i--;
				j--;
			}
			else{
				if(opt[i][j-1]>opt[i-1][j]){
					j--;
				}
				else{
					i--;
				}
			}
		}
		System.out.println(sb);
		
	}

	/**
	 * 有问题
	 * 
	 * */
	public static int[][] getLength(String x, String y) {
		int[][] b = new int[x.length()][y.length()];
		int[][] c = new int[x.length()][y.length()];

		for (int i = 1; i < x.length(); i++) {
			for (int j = 1; j < y.length(); j++) {
				// 对应第一个性质
				if (x.charAt(i) == y.charAt(j)) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = 1;
				}
				// 对应第二或者第三个性质
				else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = 0;
				}
				// 对应第二或者第三个性质
				else {
					c[i][j] = c[i][j - 1];
					b[i][j] = -1;
				}
			}
		}
		return b;
	}

	// 回溯的基本实现，采取递归的方式
	public static void Display(int[][] b, String x, int i, int j) {
		if (i == 0 || j == 0)
			return;

		if (b[i][j] == 1) {
			Display(b, x, i - 1, j - 1);
			System.out.print(x.charAt(i) + " ");
		} else if (b[i][j] == 0) {
			Display(b, x, i - 1, j);
		} else if (b[i][j] == -1) {
			Display(b, x, i, j - 1);
		}
	}

}
