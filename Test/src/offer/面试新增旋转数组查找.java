package offer;

public class ����������ת������� {
	/**
	 * ����ת�������в���			���ظ�Ԫ��
	 * ���ź��������A������Ϊn�����ڽ�����A��λ��m(m<n��mδ֪)�ֿ������������ֻ���λ�ã������������ΪB��
	 * �ҵ�ʱ�临�Ӷ�ΪO(lgn)���㷨���Ҹ�������x�Ƿ��������B�У�
	��ʾ��ͬ�����ö��ֲ��ҡ�����˼�����ȷ�������������ڵķ�Χ��ͨ���Ƚ�3������ͷ��β���м䣩����������֮��Ĺ�ϵ������ȷ���´β��ҵķ�Χ
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {10,11,13,15,3,5,7,8};
//		int num[] = {3,5,7,8};
		int target = 8;
		System.out.println(function(num, target));
		
	}
	
	public static int function(int num[] ,int target){
		
		int i=0;
		int j= num.length-1;
		while(i<=j){
			int mid = (i+j)/2;
			if(num[mid] == target){
				return mid;
			}
			if(num[mid]>=num[0]){					//�������
				if(num[mid]>target&&target>=num[0]){
					j = mid-1;
				}				
				else{
					i = mid+1;
				}
			}			
			else{									//�ұ�����
				if(num[mid]<target&&target<=num[j]){
					i = mid+1;
				}
				else{
					j = mid-1;
				}
			}
		}
		return -1;
		
	}

}
