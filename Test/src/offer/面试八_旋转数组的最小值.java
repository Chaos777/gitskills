package offer;

public class ���԰�_��ת�������Сֵ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = { 3, 4, 5, 1, 2 };
		// int num[] = {1,0,1,1,1};
		// int num[] = {1,2,3,4,5};
		System.out.println("��ת�������СֵΪ:" + function(num));
		System.out.println("��ת�������СֵΪ:" + function_Modify(num));
		System.out.println("��ת��������ֵΪ:" + function_02(num));
		
		int num1[] = {1,2,3,4,5,4,3,2,1};
		System.out.println("���������������ֵ��:"+function_03(num1));

	}

	/**
	 * ��һ����©�� ����{1,0,1,1,1}����{1,1,1,0,1}
	 * 
	 **/
	public static int function(int num[]) {
		int i = 0;
		int j = num.length - 1;
		int mid = i;

		while (num[i] >= num[j]) {
			if (i + 1 == j) {
				mid = j;
				break;
			}
			mid = (i + j) / 2;

			if (num[mid] >= num[i]) {
				i = mid;
			} else if (num[mid] <= num[j]) {
				j = mid;
			}
		}

		return num[mid];
	}

	/**
	 * �������Ľ��� ���num[i],num[mid],num[j] ����ֵ��ͬʱ��ʹ��˳�����
	 * 
	 **/
	public static int function_Modify(int num[]) {
		int i = 0;
		int j = num.length - 1;
		int mid = i;

		while (num[i] >= num[j]) {
			if (i + 1 == j) {
				mid = j;
				break;
			}

			mid = (i + j) / 2;

			if (num[i] == num[mid] && num[mid] == num[j]) {
				return func(num, i, j);
			}
			if (num[mid] >= num[i]) {
				i = mid;
			} else if (num[mid] <= num[j]) {
				j = mid;
			}
		}

		return num[mid];
	}

	public static int func(int num[], int begin, int end) {
		int result = num[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (result > num[i]) {
				result = num[i];
			}
		}
		return result;
	}

	/**
	 * ��ת���������ֵ
	 * 
	 * */
	public static int function_02(int num[]) {
		int i = 0;
		int j = num.length - 1;
		int mid = j;
		while (num[i] >= num[j]) {
			if (i + 1 == j) {
				mid = i;
				break;
			}
			mid = (i + j) / 2;
			if (num[mid] == num[i] && num[mid] == num[j]) {
				return func_02(num, i, j);
			}
			if (num[mid] >= num[i]) {
				i = mid;
			} else if (num[mid] <= num[j]) {
				j = mid;
			}
		}

		return num[mid];
	}

	public static int func_02(int[] num, int begin, int end) {
		int result = num[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (result < num[i]) {
				result = num[i];
			}
		}
		return result;
	}

	/**
	 * ����������������ֵ
	 * 
	 * */
	public static int function_03(int num[]) {
		int i = 0;
		int j = num.length - 1;
		int mid = 0;
		while (i <= j) {
			mid = (i + j) / 2;
			if((mid==0||num[mid]>=num[mid-1])&&(mid==num.length-1||num[mid]>num[mid+1])){
				break;
			}
			else if(mid>0&&num[mid-1]>num[mid]){
				j = mid-1;
			}
			else{
				i = mid+1;
			}
		}
		return num[mid];
	}

}
