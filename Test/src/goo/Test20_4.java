package goo;

public class Test20_4 {
	
	
	/**
	 * дһ������������0��n֮��2�ĸ���
	 * ����Ϊ���� 0��n֮��i��1-9���ĸ���
	 * http://www.cricode.com/2520.html
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 123456789;
		function_01(n);
		function_02(n);
		
		fun(n,1);
	}
	
	/**
	 *������
	 * 
	 * 
	 * */
	public static void function_01(int n){
		int count=0;
		for(int i=0;i<=n;i++){
			int temp = i;
			while(temp>0){
				if(temp%10==2){
					count++;
				}
				temp =temp/10;
			}
		}
		System.out.println("0��"+n+"֮��2�ĸ���wΪ:"+count);
	}
	
	/**
	 * ����
	 * 
	 * */
	public static void function_02(int n){
		int count = 0;
		int low =0,cur=0,high=0;
		int factor =1;
		while(n/factor!=0){
			low = n - (n/factor)*factor;
			cur = ((n/factor)%10);
			high = n/(factor*10);
			
			switch (cur) {
			case 0:
			case 1:
				count += high*factor;
				break;
			case 2:
				count += high*factor+low+1;
				break;
			default:
				count += (high+1)*factor;
				break;
			}
			factor =factor*10;
		}
		System.out.println("0��"+n+"֮��2�ĸ���wΪ:"+count);
	}
	
	/**
	 * ͨ����
	 * 
	 * */
	public static void fun(int n,int i){
		if(i<1||i>9||n<0){
			System.out.println("����������");
			return;
		}
		int count = 0;
		int low =0,cur=0,high=0;
		int factor =1;
		while(n/factor!=0){
			low = n - (n/factor)*factor;
			cur = ((n/factor)%10);
			high = n/(factor*10);
			
			if(cur<i){									//��ĳһλ������С��iʱ����ô��λ����i�Ĵ���Ϊ������λ����x��ǰλ��
				count += high*factor;
			}
			else if(cur==i){							//��ĳһλ�����ֵ���iʱ����ô��λ����i�Ĵ���Ϊ������λ����x��ǰλ��+��λ����+1
				count += high*factor+low+1;
			}
			else{										//��ĳһλ�����ִ���iʱ����ô��λ����i�Ĵ���Ϊ��(����λ����+1)x��ǰλ��
				count += (high+1)*factor;
			}
			factor =factor*10;
		}
		System.out.println("0��"+n+"֮��"+i+"�ĸ���wΪ:"+count);
	}

}
