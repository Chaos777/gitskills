package task;



public class Tuan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] str = {'R','B','B','b','W','W','B','R','B','w'};
		function_02(str);
		System.out.println();
		int []num1 = {120,120,120};
		int []num2 = {60,80,80,20,80};
		
		System.out.println(function_03(num1, num2));
		function_04(200, 10);
		
		int [][]num = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		function_05(num, 4);
		
		function_08(9,1);
		function_08New(9,1);
		
		
	}
	
	public static void function_02(char [] str){
		int temp[] = new int[255];
		for(int i=0;i<str.length;i++){
			temp[str[i]]++;
		}
		
		for(int i=97;i<255;i++){
			if(i>'z'){
				break;
			}
			if(temp[i]>0){
				for(int j=temp[i];j>0;j--){
					System.out.print((char)i+" ");
				}
			}
			if(temp[i-32]>0){
				for(int j=temp[i-32];j>0;j--){
					System.out.print((char)(i-32)+" ");
				}
			}
		}		
		
		
	}
	
	public static boolean function_03(int []num1,int []num2){
		int j=0;
		for(int i=0;i<num1.length;i++){
			for(;j<num2.length;j++){
				if(num1[i]>=num2[j]){
					num1[i] = num1[i]-num2[j];
					num2[j] = 0;
				}
				else{
					break;
				}
			}
		}
		if(j==num2.length&&num2[j-1]==0){
			return true;
		}
		
		return false;
	}
	
	public static void function_04(int x,int n){
		
		if(x>1){
			double result = 0;
			result = (double)(1-Math.pow(x, n+1))/(1-x);
			System.out.println((int)result);
		}
		else{
			System.out.println(n+1);
		}
	}
	
	public static void function_05(int [][]num,int n){
		for(int j=n-1;j>-1;j--){
			int x = 0;
			int y=j;
			while(x<n&&y<n){
				System.out.print(num[x][y]+" ");
				x++;
				y++;
			}
			System.out.println();
			
		}
		for(int i=1;i<n;i++){
			int x =i;
			int y =0;
			while(x<n&&y<n){
				System.out.print(num[x][y]+" ");
				x++;
				y++;
			}
			System.out.println();
		}
	}
	
	/**
	 * 从小到大返回第k个排列
	 * */
	public static void function_08(int n,int k){
		int i,j;
		int data[] = new int [10];
		int sign[] = new int [10];
		data[0] = 1;
		for(i=1;i<=n;i++){
			data[i] = data[i-1]*i;
		}
		i = i - 2;
		k--;
		StringBuffer sb = new StringBuffer();
		while(i>=0){
			int temp = k/data[i];
			for(j=1;j<10;j++){
				if(sign[j]==0){
					temp--;
				}
				if(temp<0){
					break;
				}
			}
			sign[j] = 1;
			sb.append(j);
			k = k%data[i];
			i--;
		}
		
		System.out.println(sb);
		
	}
	
	public static void function_08New(int n,int k){
		int data[] = new int[10];
		data[0] = 1;
		for(int i=1;i<=n;i++){
			data[i] = data[i-1]*i;
		}
		boolean sign[] = new boolean[10];
		sign[0] = true;
		StringBuffer sb = new StringBuffer();
		int m=n-1;
		k--;
		while(m>=0){
			int temp = k/data[m];
			int j=1;
			while(temp>=0&&j<n){
				if(!sign[j]){
					temp--;														
				}
				if(temp<0){
					break;
				}
				j++;
			}
			sign[j] = true;
			sb.append(j);
			k = k%data[m];
			m--;
		}
		/*for(int i=1;i<=n;i++){
			if(!sign[i]){
				sb.append(i);
			}
		}*/
		
		System.out.println(sb);
	}
	
	

}
