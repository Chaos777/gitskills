package offer;

import java.util.Arrays;

public class ������ʮ��_�˿��Ƶ�˳�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num = {0,0,3,4,7};
		System.out.println(IsContinous(num));
	}
	
	/**
	 *����ͳ��0�ĸ�����ͳ�Ʒ�������֮��Ĳ�Ƚ�
	 * 
	 * */
	public static boolean IsContinous(int []num){
		if(num==null||num.length<1){
			return false;
		}
		
		Arrays.sort(num);
		
		int numberOfZero = 0;
		int numberOfGrap = 0;
		for(int i:num){
			if(i==0){
				numberOfZero++;
			}
		}
		
		int begin = numberOfZero;
		int end = begin +1;
		while(end<num.length){
			if(num[begin] == num[end]){			//�ж��ӳ��֣�һ����˳��
				return false;
			}
			numberOfGrap += num[end]-num[begin]-1;
			end++;
			begin++;
		}
		
		return numberOfGrap-numberOfZero>0?false:true;
	}

}
