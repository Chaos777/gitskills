package sort;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {5,2,3,4,9,10,15};
		num = BubbleSort(num);
		for(int i = 0;i<num.length;i++){
			System.out.print(num[i]+"\t");
		}
	}
	public static int[] BubbleSort(int num[]){
		for(int i=0;i<num.length;i++){
			for(int j=1;j<num.length-i;j++){
				if(num[j-1]>num[j]){
					int temp = num[j];
					num[j] = num[j-1];
					num[j-1] = temp;
				}
			}
		}
		return num;
	}

}
