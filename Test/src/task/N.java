package task;

public class N {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]num = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		function(num, 4);
	}
	
	public static void function(int [][]num,int n){
		for(int j=n-1;j>-1;j--){
			int x = 0;
			int y=j;
			while(x<n&&y<n){
				System.out.print(num[x][y]+" ");
				x++;
				y++;
			}
			System.out.println();
			
		}
		for(int i=1;i<n;i++){
			int x =i;
			int y =0;
			while(x<n&&y<n){
				System.out.print(num[x][y]+" ");
				x++;
				y++;
			}
			System.out.println();
		}
	}

}
