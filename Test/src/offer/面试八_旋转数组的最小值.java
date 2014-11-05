package offer;

public class 面试八_旋转数组的最小值 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = { 3, 4, 5, 1, 2 };
		// int num[] = {1,0,1,1,1};
		// int num[] = {1,2,3,4,5};
		System.out.println("旋转数组的最小值为:" + function(num));
		System.out.println("旋转数组的最小值为:" + function_Modify(num));
		System.out.println("旋转数组的最大值为:" + function_02(num));
		
		int num1[] = {1,2,3,4,5,4,3,2,1};
		System.out.println("先增后减数组的最大值是:"+function_03(num1));

	}

	/**
	 * 法一：有漏洞 特例{1,0,1,1,1}或者{1,1,1,0,1}
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
	 * 法二：改进版 如果num[i],num[mid],num[j] 三个值相同时，使用顺序遍历
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
	 * 旋转数组求最大值
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
	 * 先增后减数组求最大值
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
