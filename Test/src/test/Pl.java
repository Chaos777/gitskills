package test;

import java.util.ArrayList;
import java.util.List;

public class Pl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {1,1,1,1,1,2,2,2,2,3,3,3};
		List<ArrayList<Integer>> resuList = permute(num);
		int count = 0;
		
		for(ArrayList<Integer> a:resuList){
			System.out.println(a);
			/*String temp = a.toString().replaceAll("\\[", "");
			temp = temp.replaceAll("\\]", "");
			temp = temp.replaceAll("\\,", "");
			temp = temp.replaceAll(" ", "");
			if(!(temp.charAt(2)=='4')&&!(temp.contains("35"))&&!(temp.contains("53"))){
				count++;
				System.out.println(temp);
			}*/
		}
		System.out.println(count+":"+resuList.size());
	}

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, result);
		return result;
	}

	static void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {

		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}

		for (int j = start; j <= num.length - 1; j++) {
			if (containsDuplicate(num, start, j)) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
			}
		}
	}
	private static boolean containsDuplicate(int[] arr, int start, int end) {
		for (int i = start; i <= end-1; i++) {
			if (arr[i] == arr[end]) {
				return false;
			}
		}
		return true;
	}

	private static ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
