package task;

public class ����������������ϲ���ĵ�K������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,3,5,7,9};
		int b[] = {0,2,4,6,8};
		int k = 7;
		function(a, b, k);
		functionModify(a, b, k);
		
		System.out.println(function_02(a, 0, a.length-1, b, 0, b.length-1, k));
	}
	
	/**
	 * ����һ������
	 * */
	public static void function(int []a,int []b,int k){
		if(k>a.length+b.length){
			System.out.println("��������");
			return;
		}
		int i=0;
		int j=0;
		int index=0;
		boolean flag = true;
		
		while(k>0&&i<a.length&&j<b.length){
			if(a[i]<=b[j]){
				index = i;
				i++;				
				flag = true;
				
			}
			else{
				index = j;
				j++;				
				flag = false;
			}
			k--;
		}
		while(k>0&&i<a.length){
			index = i;
			i++;
			k--;
			flag = true;
		}
		while(k>0&&i<b.length){
			index= j;
			j++;
			k--;
			flag = false;
		}
		
		if(flag){
			System.out.println(a[index]);
		}
		else{
			System.out.println(b[index]);
		}
		
	}
	
	public static void functionModify(int[]a,int[]b,int k){
		if(k>a.length+b.length){
			System.out.println("��������");
			return;
		}
		int temp[] = new int[a.length+b.length];
		int i=0;
		int j=0;
		int m=0;
		while(k>0&&i<a.length&&j<b.length){
			if(a[i]<=b[j]){
				temp[m++] = a[i++];
			}
			else{
				temp[m++] = b[j++];
			}
			k--;
		}
		
		while(k>0&&i<a.length){
			temp[m++] = a[i++];
			k--;
		}
		while(k>0&&j<b.length){
			temp[m++] = b[j++];
			k--;
		}
		System.out.println(temp[--m]);
		
		
	}
	
	/**
	 * ����
	 * */
	public static int function_02(int a[],int abegin,int aend,int b[],int bbegin,int bend,int k){
		if(abegin>aend){
			return b[bbegin+k-1];
		}
		if(bbegin>bend){
			return a[abegin+k-1];
		}
		//ȡ�м�λ�� 
		int amid = abegin+(aend-abegin)/2;
		int bmid = bbegin+(bend-bbegin)/2;
		
		//��A��B�Ŀ�ʼλ�õ����������м�λ�õ�Ԫ�ظ���
		int halfLen = amid-abegin+bmid-bbegin+2;
		if(a[amid]<b[bmid]){
			if(halfLen>k){
				 // ��ʱ�ںϲ���������A[aBeg...aMid]��Ԫ��һ����B[bMid]����࣬   
	            // ����ʱ��k���Ԫ��һ����B[bMid]���Ԫ��С���ϸ���˵�����ڣ�   
	            // ���Ժ�û�б�Ҫ���� B[bMid...bEnd]��ЩԪ��
				return function_02(a, abegin, aend, b, bbegin, bmid-1, k);
			}else{
				// ��ʱ�ںϲ���������A[aBeg...aMid]Ԫ��һ����B[bMid]����࣬   
	            // ����ǰK��Ԫ����һ������A[aBeg...aMid]������ʹ�÷�֤����֤����㣩��   
	            // �����޷��ж�A[amid+1...aEnd]��B[bBeg...bEnd]֮��Ĺ�ϵ������Ҫ�����ǽ����ж�   
	            // ��ʱK��ʣ�³�ȥA[aBeg...aMid]��ЩԪ�أ�����Ϊk - (aMid - aBeg + 1)   
	   
				return function_02(a, amid+1, aend, b, bbegin, bend, k-(amid-abegin+1));
			}
		}
		else{
			 //ע������������ 
			if(halfLen>k){
				return function_02(a, abegin, amid-1, b, bbegin, bend, k);
			}else{
				return function_02(a, abegin, aend, b, bmid+1, bend, k-(bmid-bbegin+1));
			}
		}
		
	}

}
