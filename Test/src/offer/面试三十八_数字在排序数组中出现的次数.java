package offer;

public class ������ʮ��_���������������г��ֵĴ��� {
	
	/**
	 * 
	 * ���ö��ֲ���
	 * */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num[] = {1,2,3,3,3,3,4,5};
		int k= 3;
		
		System.out.println(getNumberOfK(num, k));
	}
	
	/**
	 * ���ݵ�һ�γ��ֵ�λ�������һ�γ��ֵ�λ�õõ����ֵĴ���
	 * */
	public static int getNumberOfK(int []num,int k){
		int number = 0;
		if(num.length>0){
			int first = Get_firstK(num, k, 0, num.length-1);
			int end = Get_endK(num, k, 0, num.length-1);
			
			if((first>-1)&&(end>-1)){
				return end - first+1;
			}
		}
		
		return number;
	}
	
	/**
	 *�õ���һ�γ��ֵ�λ�� 
	 * */
	public static int Get_firstK(int num[],int k,int start,int end){
		if(start>end){
			return -1;
		}
		
		int midIndex = (start+end)/2;
		int midData = num[midIndex];
		
		if(midData==k){
			if((midIndex==0)||((midIndex>0)&&(num[midIndex-1]!=k))){		//���ǵ�һ�����ֵ�λ��
				return midIndex;
			}
			
			else{														//���ǵ�һ�γ��ֵ�λ�ã�����ǰ��
				end = midIndex-1;
			}
		}
		else if(midData>k){												//���м�ֵС����ǰ��
			end = midIndex-1;
		}
		else{															//���м�ֵ��������
			start = midIndex+1;
		}
		
		return Get_firstK(num, k, start, end);
	}
	
	
	/**
	 * �ҵ����һ�γ��ֵ�λ��
	 * 
	 * */
	public static int Get_endK(int num[],int k,int start,int end){
		if(start>end){
			return -1;
		}
		
		int midIndex = (start+end)/2;
		int midData = num[midIndex];
		if(midData==k){
			if((midIndex==num.length-1)||((num[midIndex+1]!=k)&&(midIndex<num.length-1))){
				return midIndex;
			}
			
			else{
				start = midIndex+1;
			}
		}
		else if(midData>k){
			end = midIndex-1;
		}
		else{
			start = midIndex+1;
		}
		
		return Get_endK(num, k, start, end);
	}
	

}
