package offer;

public class ������ʮ��_ԲȦ�����ʣ������� {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4000;
		int m = 997;
		System.out.println(LastRemaining(n, m));
		System.out.println(LastRemaining_02(n, m));
	}
	
	/**
	 *��ʽ�� 
	 * */
	
	public static int LastRemaining(int n,int m){
		if(n<1||m<1){
			return -1;
		}
		int last = 0;
		for(int i=2;i<=n;i++){
			last = (last+m)%i;
		}
		
		return last;
	}
	
	/**
	 *������ʹ�ö���ռ䱣�����ֵ�״̬ 
	 * 
	 * */
	public static int LastRemaining_02(int n,int m){
		if(n<1||m<1){
			return -1;
		}
		boolean state[] = new boolean[n];
		for(int i=0;i<state.length;i++){
			state[i] = true;
		}
		int remain = n;
		int countNumber = 0;
		int index = 0;
		while(remain>1){
			if(state[index]){
				countNumber++;
				if(countNumber==m){
					state[index] = false;
					countNumber=0;
					remain--;
				}
			}
			index++;
			if(index == state.length){
				index=0;
			}
		}
		for(int i=0;i<n;i++){
			if(state[i]){
				return i;
			}
		}
		
		return 0;
	}
}
