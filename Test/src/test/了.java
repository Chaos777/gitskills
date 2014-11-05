package test;

public class ¡À {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {1,8,5,2,4,9,7};
		
		/*for(int i=0;i<num.length;i++){
			for(int j=i+1;j<num.length;j++){
				if(num[i]>num[j]){
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}*/
		for(int i=num.length-1;i>=0;i--){
			for(int j = 0;j<i;j++){
				if(num[j]>num[j+1]){
					int temp = num[j+1];
					num[j+1] = num[j];
					num[j] = temp;
				}
			}
		}
		for(int i:num){
			System.out.print(i+" ");
		}
		
		int j  =0;
		for(int i=0;i<100;i++){
			j = j++;
		}
		System.out.println("ƒ„√√µƒ"+j);
	}

}
