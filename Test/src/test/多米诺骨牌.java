package test;

public class 多米诺骨牌 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean [] use = new boolean[100];
		for(int i=0;i<use.length;i++){
			use[i] = true;
		}
		
		int leftCount = use.length;
		int countNum = 1;
		int index = 0;
		while(leftCount>1){
			if(use[index]){
				countNum++;
				if(countNum%2==1){
				//	if(!use[index]){
				//		use[++index]=false;
				//		leftCount--;
				//		countNum = 0;
				//	}
				//	else{
						use[index] = false;
						leftCount--;
						countNum = 0;
				//	}
				}
			}
			index++;
			if(index == use.length){
				index  = 0;
				countNum = 0;
			}
			
			for(int i = 0;i<use.length;i++){
				if(i%10==0&&i!=0){
					System.out.println();
				}
				System.out.print(use[i]+" ");
			}
			System.out.println("数据");
			
		}
		for(int i = 0;i<use.length;i++){
			if(i%10==0&&i!=0){
				System.out.println();
			}
			System.out.print(use[i]+" ");
		}
	}

}
