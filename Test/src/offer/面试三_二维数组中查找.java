package offer;

public class 面试三_二维数组中查找 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] num = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15},{10,13,14,16}};
	//	System.out.println(num.length+":"+num[0].length);
		int target = 9;
		
		for(int i=0;i<num.length;i++){
			for(int j = 0;j<num[i].length;j++){
				System.out.print(num[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("查找数字为"+target+"，结果为:"+function_01(num, target));
		System.out.println("查找数字为"+target+"，结果为:"+function_02(num, target));
	}
	
	/**
	 *右上角开始 
	 * 
	 **/
	
	public static boolean function_01(int [][]num,int target){
		boolean found = false;
		int i = 0;
		int j = num[0].length-1;
		
		while(i<num.length&&j>=0){
			if(num[i][j] == target){
				found = true;
				break;
			}
			else if(num[i][j]>target){			//大，说明右边的数都比它大，去掉右边的列
				j--;
			}
			else{								//小，说明上边的数都比他小，去掉上边的行
				i++;
			}
		}
		
		return found;
	}
	
	/**
	 *左下角 
	 * 
	 **/
	
	public static boolean function_02(int [][]num,int target){
		boolean found = false;
		
		int i=num.length-1;
		int j = 0;
		
		while(i>=0&&j<num[i].length){
			if(num[i][j]==target){
				found = true;
				break;
			}
			else if(num[i][j]>target){				//大，说明下边的行都比它大，去掉下边的行
				i--;
			}
			else{									//小，说明左边的列都比它小，去掉左边的列
				j++;
			}
		}
		
		return found;		
	}

}
