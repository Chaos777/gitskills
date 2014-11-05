
public class 因式分解 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function(17);
	}
	
	public static void function(int n){
		int k=2;
		System.out.print(n+"=");
		while(n>=k){
			if(n==k){
				System.out.println(n);
				break;
			}
			else if(n%k==0){
				System.out.print(k+"*");
				n=n/k;
			}
			else{
				k++;
			}
		}
	}

}
