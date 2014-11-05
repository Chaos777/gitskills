package test;

public class ½Ï´ó {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[]= {0,1,2,3,4,5,6,7,8,9}; 
		System.out.println(max(s, s[0], 0));
	}
	
	public static int max(int s[],int n,int b){
		if(b==s.length){
			return n;
		}
		
		n = n>=s[b]?n:s[b];
		return max(s, n, b+1);
	}

}
