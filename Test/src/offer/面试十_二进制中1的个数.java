package offer;

public class 面试十_二进制中1的个数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;				//二进制 1010；
		System.out.println(n<<1);
		System.out.println(n+"的二进制中1的个数是:"+function_01(n));
		System.out.println(n+"的二进制中1的个数是:"+function_02(n));
		System.out.println(n+"的二进制中1的个数是:"+function_03(n));
		
		int m = 256;
		System.out.println((function_Is(m)==true)?m+"是2的整数次幂":m+"不是2的整数次幂");
		
		int y = 13;
		System.out.println(n+","+y+"，这两个数字的二进制位相差"+function_Ex(n, y)+"位");
	}
	
	/**
	 * 法一：与1&运算为1是，右移
	 * 可能死循环，负数的时候
	 * */
	public static int function_01(int n){
		int count = 0;
		while(n>0){
			if((n&1)>0){
				count++;
			}
			n = n>>1;
		}
		return count;
	}
	
	/**
	 * 法二：与1左移&运算为1
	 * 
	 * */
	public static int function_02(int n){
		int count = 0;
		int flag =1;
		while(flag>0){
			if((n&flag)>0){
				count++;
			}
			flag = flag<<1;
		}
		return count;
	}
	
	/**
	 * 法三：高效的算法
	 * 
	 * */
	public static int function_03(int n){
		int count = 0;
		while(n>0){
			count++;
			n = (n-1)&n;
		}
		return count;
	}
	
	/**
	 * 扩展：求一个数是否为2的整数次幂
	 * 
	 * */
	public static boolean function_Is(int n){
		return (n&(n-1))==0?true:false;
	}
	
	/**
	 * 扩展:求两个数的二进制数改变几位即可相等
	 * */
	
	public static int function_Ex(int x,int y){
		return function_03((x^y));
	}
	

}
