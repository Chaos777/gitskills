package sort;

public class SortNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num[] = { 9, 8, 4, 7, 6, 1, 0, 0 };
		quick(num, 0, num.length - 1);

		for (int i : num) {
			System.out.print(i + " ");
		}
		System.out.println("-----快排");
		int num1[] = { 9, 8, 4, 7, 6, 1, 0, 0 };
		bubbleSortModif(num1);

		for (int i : num1) {
			System.out.print(i + " ");
		}
		System.out.println("-----泡排");

		int num2[] = { 9, 8, 4, 7, 6, 1, 0, 0 };
		heap(num2);

		for (int i : num2) {
			System.out.print(i + " ");
		}
		System.out.println("-----堆排");

		int num3[] = { 9, 8, 4, 7, 6, 1, 0, 0, 5 };
		shellSortModify(num3);
		for (int i : num3) {
			System.out.print(i + " ");
		}
		System.out.println("-----shell");

		int num4[] = { 9, 8, 4, 7, 6, 1, 0, 0 };
		selectSort(num4);
		for (int i : num4) {
			System.out.print(i + " ");
		}
		System.out.println("-----选择");

		int num5[] = { 9, 8, 4, 7, 6, 1, 0, 0 };
		insertSort(num5);
		for (int i : num5) {
			System.out.print(i + " ");
		}
		System.out.println("-----插入");

		int num6[] = { 9, 8, 4, 7, 6, 1, 0, 0 };
		MergeSort2(num6);
		for (int i : num6) {
			System.out.print(i + " ");
		}
		System.out.println("-----归并");

	}

	public static int partition(int num[], int low, int high) {
		int temp = num[low];
		while (low < high) {
			while (low < high && num[high] >= temp) {
				high--;
			}
			num[low] = num[high];
			while (low < high && num[low] <= temp) {
				low++;
			}
			num[high] = num[low];
		}
		num[low] = temp;
		return low;
	}

	public static void quickSort(int num[], int low, int high) {
		if (low > high) {
			return;
		}
		int mid = partition(num, low, high);
		quickSort(num, low, mid - 1);
		quickSort(num, mid + 1, high);
	}

	public static void quick(int num[], int low, int high) {
		if (low < high) {
			int i = low;
			int j = high;
			int temp = num[low];
			while (i < j) {
				while (i < j && num[j] > temp) {
					j--;
				}
				if (i < j) {
					num[i] = num[j];
					i++;
				}
				while (i < j && num[i] < temp) {
					i++;
				}
				if (i < j) {
					num[j] = num[i];
					j--;
				}
				num[i] = temp;
				quick(num, low, i - 1);
				quick(num, i + 1, high);
			}
		}

	}

	public static void bubbleSort(int num[]) {
		for (int i = num.length; i >= 0; i--) {
			for (int j = 1; j < i; j++) {
				if (num[j] < num[j - 1]) {
					int temp = num[j];
					num[j] = num[j - 1];
					num[j - 1] = temp;
				}
			}
		}
	}

	public static void bubbleSortModif(int num[]) {
		boolean flag = false;
		for (int i = num.length; i >= 0; i--) {
			flag = true;
			for (int j = 1; j < i; j++) {

				if (num[j] < num[j - 1]) {
					int temp = num[j];
					num[j] = num[j - 1];
					num[j - 1] = temp;
					flag = false;
				}

			}
			if (flag) {
				break;
			}
		}
	}

	public static void heapAdjust(int[] num, int father, int length) {
		int child, cup;
		for (child = father * 2 + 1, cup = num[father]; child < length; father = child, child = father * 2 + 1) {
			if (child + 1 < length && num[child + 1] > num[child])
				child++;
			if (num[child] > cup) {
				num[father] = num[child];
				num[child] = cup;
			} else
				break;
		}
	}

	public static void heapSort(int num[]) {
		for (int i = num.length / 2 - 1; i >= 0; i--) {
			heapAdjust(num, i, num.length);
		}

		for (int i = num.length - 1; i > 0; i--) {
			int temp = num[0];
			num[0] = num[i];
			num[i] = temp;

			heapAdjust(num, 0, i);
		}
	}

	public static void adjust(int num[], int i, int length) {
		int child = 0;
		for (int temp = num[i]; i * 2 + 1 < length; i = child) { // 从当前节点的子节点开始调整，下次循环时从调整的那个子节点开始调整
			child = i * 2 + 1;
			if (child < length - 1 && num[child + 1] > num[child]) { // 找到两个节点中较大的一个
				child++;
			}
			if (num[child] > temp) { // 如果比父节点大，就交换
				num[i] = num[child];
				num[child] = temp;
			} else {
				break;
			}
		}
	}

	public static void heap(int num[]) {
		for (int i = num.length / 2 - 1; i >= 0; i--) { // 建立一个大根堆
			adjust(num, i, num.length);
		}
		for (int i = num.length - 1; i > 0; i--) { // 交换根节点与最后的节点，然后重新调整堆（注意去掉最后的节点）
			int temp = num[0];
			num[0] = num[i];
			num[i] = temp;

			adjust(num, 0, i);
		}
	}

	public static void shellSort(int num[]) {
		int d = num.length;
		while (d > 1) {
			d = (d + 1) / 2;
			for (int i = 0; i < num.length - d; i++) {
				for (int j = i; j < num.length - d; j += d) {
					if (num[j] > num[j + d]) {
						int temp = num[j];
						num[j] = num[j + d];
						num[j + d] = temp;
					}
				}
			}
		}
	}

	public static void shellSortModify(int num[]) {
		int d = num.length / 2;
		while (d > 0) {
			for (int i = d; i < num.length; i++) {
				int temp = num[i];
				int j = i - d;
				while (j >= 0 && temp < num[j]) {
					num[j + d] = num[j];
					j = j - d;
				}
				num[j + d] = temp;

			}
			d = d / 2;
		}
	}

	public static void selectSort(int num[]) {
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[j] < num[i]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}

	public static void insertSort(int num[]) {
		for (int i = 1; i < num.length; i++) {

			int j = i;
			while (j > 0 && num[j] < num[j - 1]) {
				int temp = num[j];
				num[j] = num[j - 1];
				num[j - 1] = temp;
				j--;
			}

		}
	}

	public static void Merge(int num[], int begin, int mid, int end) {
		int temp[] = new int[end - begin + 1];
		int i = begin;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end) {
			if (num[i] < num[j]) {
				temp[k++] = num[i++];
			} else {
				temp[k++] = num[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = num[i++];
		}
		while (j <= end) {
			temp[k++] = num[j++];
		}

		for (int n = 0; n < temp.length; n++) {
			num[begin + n] = temp[n];
		}
	}

	public static void MergePass(int num[], int length) { // 自底向上
		int i;
		for (i = 0; i + 2 * length - 1 < num.length; i = i + 2 * length) {
			Merge(num, i, i + length - 1, i + 2 * length - 1);
		}
		if (i + length - 1 < num.length) {
			Merge(num, i, i + length - 1, num.length - 1);
		}
	}

	public static void MergeSort(int num[]) {
		for (int i = 1; i < num.length; i = 2 * i) {
			MergePass(num, i);
		}
	}

	public static void MergeDc(int num[], int low, int high) { // 自顶向下
		int mid;
		if (low < high) {
			mid = (low + high) / 2;
			MergeDc(num, low, mid);
			MergeDc(num, mid + 1, high);
			Merge(num, low, mid, high);
		}
	}

	public static void MergeSort2(int num[]) {
		MergeDc(num, 0, num.length - 1);
	}
}
