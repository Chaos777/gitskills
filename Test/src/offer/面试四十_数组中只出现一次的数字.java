package offer;

public class ������ʮ_������ֻ����һ�ε����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {2,4,3,6,3,2,5,5};
		FindNUmberAppearOnce(num);
	}
	
	/**
	 * ��Ҫ˼��ʹ�����
	 * ����ȫ�����Ľ����1�ĳ���λ�ã��������Ϊ���飬
	 * Ȼ��ֱ���򣬵õ����������ս������Ҫ���������ֻ����һ�ε�������
	 * 
	 * */
	public static void FindNUmberAppearOnce(int[] num){
		if(num.length<2){
			System.out.println(num.toString());
		}
		
		int resultOR = 0;
		for(int i:num){
			resultOR ^= i;
		}
		int indexOf1 = findFirstBit1(resultOR);
		
		int num1 = 0;
		int num2 = 0;
		
		for(int i:num){
			if(isBit1(i, indexOf1)){
				num1 ^= i;
			}
			else{
				num2 ^= i;
			}
		}
		
		System.out.println("����һ�ε���������:"+num1+","+num2);
	}
	
	
	
	/**
	 * 
	 * �ҳ�1���ֵ����ұߵ�λ��
	 * 
	 * */
	public static int findFirstBit1(int num){
		int indexBit = 0;
		while((num&1)==0){
			num = num>>1;
			indexBit++;
		}
		
		return indexBit;
	}
	
	/**
	 *�ж�ĳλ�����Ƿ�Ϊ1 
	 * 
	 * */
	static boolean isBit1(int num,int indexBit){
		num = num>>indexBit;
		return (num&1)==1;
	}
	
	

}
