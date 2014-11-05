package offer;

public class 面试十二_打印1到最大的n位数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
	//	PrintMaxN(n);
		PrintMaxN_Extend(n);
	}
	
	/**
	 * 理想解法
	 * 未考虑大数
	 * */
	public static void PrintMaxN(int n){
		int num = 1;
		int i=0;
		while(i++<n){
			num *= 10;
		}
		for(int j=1;j<num;j++){
			System.out.println(j);
		}
	}
	
	/**
	 * 改进版
	 * 字符数组
	 * */
	public static void PrintMaxN_Extend(int n){
		if(n<=0){
			return;
		}
		char [] number = new char[n+1];
		for(int i=0;i<number.length;i++){
			number[i] = 0;
		}
		while(!Incream(number)){
			PrintNumber(number);
		}
		
	}
	
	
	/**
	 * 自增并判断是否溢出
	 * */
	static boolean Incream(char [] number){
		boolean isOverflow = false;
		int nTakeOver = 0;
		int nLength = number.length;
		for(int i = nLength-1;i>=0;i--){
			int nSum = number[i] -'0' + nTakeOver;
			if(i==nLength-1){
				nSum++;
			}
			if(nSum>=10){
				if(i==0){
					isOverflow = true;
				}
				else{
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0'+nSum);
				}
			}
			else{
				number[i] = (char) ('0'+nSum);
				break;
			}
		}
		return isOverflow;
	}
	
	/**
	 * 打印，去掉前面的0
	 * */
	static void PrintNumber(char [] number){
		boolean isBeginZero = true;
		int nLenght = number.length;
		for(int i=0;i<nLenght;i++){
			if(isBeginZero&&number[i]!='0'){
				isBeginZero = false;
			}
			if(!isBeginZero){
				System.out.print(number[i]);
			}
		}
	}

}
