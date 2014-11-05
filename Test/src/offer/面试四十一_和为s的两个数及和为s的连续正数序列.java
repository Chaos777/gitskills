package offer;

public class ������ʮһ_��Ϊs������������Ϊs�������������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[]  = {1,2,4,7,11,15};
		int sum = 15;
		FindNumberWithSum(num, sum);
		FindContinuousSequence(100);
	}
	
	/**
	 * ��Ϊs��������
	 * ����ָ��ǰ��
	 * */
	public static void FindNumberWithSum(int num[],int sum){
		if(num.length<1){
			System.out.println("�޽⣬������������");
		}
		
		int ahead = 0;
		int behind = num.length-1;
		
		while(ahead<behind){
			int tempsum = num[ahead]+num[behind];
			if(tempsum==sum){
				System.out.println("��Ϊ"+sum+"����������"+num[ahead]+","+num[behind]);
				break;
			}
			
			else if(tempsum>sum){
				behind--;
			}
			else{
				ahead++;
			}
		}
	}
	
	/**
	 * ��Ϊs��������������
	 * ͬ����ָ��
	 * */
	static void FindContinuousSequence(int sum){
		if(sum<3){
			System.out.println("�����������");
		}
		int small = 1;
		int big =2;
		int maxNum = (sum+1)/2;
		int tempSum = small+big;
		
		while(small<maxNum){
			if(tempSum==sum){
				Print(small, big);
				System.out.println(sum);
			}
			while((tempSum>sum)&&(small<maxNum)){
				tempSum -= small;
				small++;
				if(tempSum==sum){
					Print(small, big);
					System.out.println(sum);
				}
			}
			
			big++;
			tempSum += big;
		}
	}
	
	
	/**
	 *��ӡ�������� 
	 * */
	static void Print(int begin,int end){
		for(int i=begin;i<end;i++){			
			System.out.print(i+"+");
		}
		System.out.print(end+"=");
		
	}

}
