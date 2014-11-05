package task;

public class $1到n和为m的所有组合 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findCombination(10, 9);
	}
	
	public static void findCombination(int n,int m){
		if(n>m){
			findCombination(m, m);
			return;
		}
		int num[] = new int[n];
		helper(m, 0, num, n);
	}
	
	public static void helper(int dest ,int idx,int num[],int n){
		if(dest ==0){
			print(num, n);
		}
		if(dest<=0||idx==n){
			return;
		}
		helper(dest, idx+1, num, n);
		num[idx] = 1;
		helper(dest-idx-1, idx+1, num, n);
		num[idx] = 0;
	}
	
	public static void print(int num[],int n){
		for(int i=0;i<n;i++){
			if(num[i]!=0){
				System.out.print(i+1+" ");
			}
		}
		System.out.println();
	}
	
	
}
