package offer;

public class ������ʮ��_��1��2��n {
	
	static int sum = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		GetOntToN(n);
		System.out.println(sum);
		System.out.println(find(n));
	}
	
	/**
	 *����||�Ķ�·ԭ�� 
	 * 
	 * */
	public static boolean GetOntToN(int n){
		sum = sum +n;
		
		return ((n-1<0)||GetOntToN(n-1));
	}
	
	/**
	 * 
	 * */
	static int find(int n){   
        int re=0;   
        boolean whatever=false;   
        int a=-1;   
        whatever=(n!=0)&&(a==(re=find(n-1)));   
        return re+n;   
    }   

}
