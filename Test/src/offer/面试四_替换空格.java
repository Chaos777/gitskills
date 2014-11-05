package offer;

public class 面试四_替换空格 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello word  whu   old!";
		System.out.println(function_01(str));
		System.out.println(function_02(str));
		
		int numA[] = {1,3,5,7,9};
		int numB[] = {2,4,6,8,10,11};
		int []numC = function_Extend(numA, numB);
		for(int i:numC){
			System.out.print(i+" ");
		}
	}
	
	/**
	 *法一：直接使用java 中的replaceAll 
	 **/
	public static String function_01(String str){
		return str.replaceAll(" ", "%20");
	}
	
	/**
	 *法二：使用字符数组后移
	 **/
	
	public static String function_02(String str){
		
		char [] temp = str.toCharArray();
		
		int count=0;
		for(char c:temp){
			if(c==' '){
				count++;
			}
		}
		char [] temp_new = new char[temp.length+count*2];		//注意长度
		for(int i=0;i<temp.length;i++){
			temp_new[i] = temp[i];
		}
		
		int i = temp.length-1;
		int j = temp_new.length-1;
		
		while(i>=0&&j>i){
			if(temp_new[i] == ' '){
				temp_new[j--] ='0';
				temp_new[j--] ='2';
				temp_new[j--] ='%';
			}
			else{
				temp_new[j--] = temp_new[i];
			}
			i--;
		}
		
		String result = new String(temp_new);
		
		return result;
	}
	
	/**
	 * 扩展合并数组
	 * 
	 * */
	
	public static int[] function_Extend(int[]numA,int[]numB){
		int i = numA.length-1;
		int j = numB.length-1;
		
		int[]numC = new int[i+j+2];
		int k = numC.length-1;
		
		while(i>=0&&j>=0){
			if(numA[i]>numB[j]){
				numC[k] = numA[i];
				k--;
				i--;
			}
			else{
				numC[k] = numB[j];
				k--;
				j--;
			}
		}
		
		while(i>=0){
			numC[k--] = numA[i--];
		}
		
		while(j>=0){
			numC[k--] = numB[j--];
		}
		return numC;
	}

}
