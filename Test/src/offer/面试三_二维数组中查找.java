package offer;

public class ������_��ά�����в��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] num = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15},{10,13,14,16}};
	//	System.out.println(num.length+":"+num[0].length);
		int target = 9;
		
		for(int i=0;i<num.length;i++){
			for(int j = 0;j<num[i].length;j++){
				System.out.print(num[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("��������Ϊ"+target+"�����Ϊ:"+function_01(num, target));
		System.out.println("��������Ϊ"+target+"�����Ϊ:"+function_02(num, target));
	}
	
	/**
	 *���Ͻǿ�ʼ 
	 * 
	 **/
	
	public static boolean function_01(int [][]num,int target){
		boolean found = false;
		int i = 0;
		int j = num[0].length-1;
		
		while(i<num.length&&j>=0){
			if(num[i][j] == target){
				found = true;
				break;
			}
			else if(num[i][j]>target){			//��˵���ұߵ�����������ȥ���ұߵ���
				j--;
			}
			else{								//С��˵���ϱߵ���������С��ȥ���ϱߵ���
				i++;
			}
		}
		
		return found;
	}
	
	/**
	 *���½� 
	 * 
	 **/
	
	public static boolean function_02(int [][]num,int target){
		boolean found = false;
		
		int i=num.length-1;
		int j = 0;
		
		while(i>=0&&j<num[i].length){
			if(num[i][j]==target){
				found = true;
				break;
			}
			else if(num[i][j]>target){				//��˵���±ߵ��ж�������ȥ���±ߵ���
				i--;
			}
			else{									//С��˵����ߵ��ж�����С��ȥ����ߵ���
				j++;
			}
		}
		
		return found;		
	}

}
