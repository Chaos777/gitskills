package test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;



public class ◊Û∆Ê”“≈º {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[]= {1,2,3,4,5,6,7,8,9};
		/*int i=0,j = s.length-1;
		while(i<j){
			if(s[i]%2!=0&&s[j]%2==1){
				i++;
			}
			else if(s[i]%2==0&&s[j]%2!=1){
				j--;
			}
			else if(s[i]%2==0&&s[j]%2==1){
				int temp = s[i];
				s[i] = s[j];
				s[j] = temp;
				i++;
				j--;
			}
			else{
				i++;
				j--;
			}
		}
		while(i<j){
			if(s[i]%2==1){
				i++;
			}
			if(s[j]%2==0){
				j--;
			}
			if(i<j){
				int temp = s[i];
				s[i] = s[j];
				s[j] = temp;
			}
		}
		
		for(int l:s){
			System.out.print(l+"\t");
		}*/		
		function(s);
		
	}
	public static void function(int num[]){
		Queue<Integer> result = new PriorityQueue<>(num.length,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int re = o1%2 - o2%2;
				if(re==1){
					re = o1-o2;
				}
				return re;
			}
		});
		
		for(int i=0;i<num.length;i++){
			result.offer(num[i]);
		}
		
		System.out.println(result);
	}

}
