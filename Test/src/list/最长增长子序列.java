package list;

import java.util.ArrayList;
import java.util.List;

public class ����������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {1,5,8,2,3,4};
		function(num);
		function_02(num);
	}
	
	
	/**
	 * ֻ�г���
	 * */
	public static void function(int num[]){
		int dp[] = new int[num.length];
		int list = 0;
		for(int i=0;i<num.length;i++){
			dp[i] = 1;
			for(int j=0;j<i;j++){
				if(num[i]>num[j]&&dp[i]<dp[j]+1){
					dp[i] = dp[j]+1;
					
					if(dp[i]>list){
						list =dp[i];
					}
				}
			}
		}
		
		System.out.println(list);
		
		for(int i:dp){
			System.out.print(i+" ");
		}
	}
	
	
	/**
	 * ���ȼ�����
	 * 
	 * */
	public static void function_02(int []num){
		int length = num.length;
		int [] list = new int[length];
		List<Integer> result = new ArrayList<>();
		for(int i=0;i<length;i++){
			list[i] = 1;
			for(int j=0;j<i;j++){
				if(num[j]<num[i]&&list[j]+1>list[i]){
					list[i] = list[j]+1;
					if(result.isEmpty()){
						result.add(list[j]);
					}
					if(!result.contains(list[i])){
						result.add(list[i]);
					}
				}
			}
		}
	//	System.out.println("��i��Ԫ��ʱ���������:"+Arrays.toString(list));
		
		int max = 0;
		for(int i=0;i<length;i++){
			if(list[i]>max){
				max = list[i];
			}
		}
		System.out.println("��������г�����:"+max);
		System.out.println("���������:"+result);
	}

	

}
