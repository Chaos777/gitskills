package test;

public class Ô¼Éª·ò»· {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean [] use = new boolean[30];
		for(int i=0;i<use.length;i++){
			use[i] = true;
		}
		
		int leftCount = use.length;
		int countNum = 0;
		int index = 0;
		while(leftCount>15){
			if(use[index]){
				countNum++;
				if(countNum==9){
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
			}
			
		}
		for(int i = 0;i<use.length;i++){
			if(i%10==0&&i!=0){
				System.out.println();
			}
			System.out.print(use[i]+" ");
		}
	}

}
