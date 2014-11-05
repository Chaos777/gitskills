
public class CVTE2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D d= new D();
		C c = d;
		BB b = c;
		AA a = b;
		d.M2();
		c.M2();
		b.M();
		a.M();
		System.out.println(9+9+"A");
		System.out.println("A"+9+9);
		int num[] = new int[]{1,2,3};
		System.out.println(-10%-3);
		int count = 1;
		for(int i=1;i<=5;i++){
			count += i;
		}
		System.out.println(count);
		int bnum[][] = {{1,2,3},{4,5},{6,7,8}};
		System.out.println(bnum.length);
		System.out.println(bnum[1].length);
		
		for(int i=0;i<bnum.length;i++){
			for(int j=0;j<bnum[i].length;j++){
				System.out.print(bnum[i][j]);
			}
			System.out.println();
		}
		StringBuffer s = new StringBuffer("abcdefgh");
		StringBuffer ss = s.replace(0, 1, "q");
		System.out.println(s);
		System.out.println(ss==s);
		
		int sum = 0;
		int nums[] = {10,20,30,40,50,60,70};
		for(int i=0;i<nums.length;i++)
			if(i%2==1)
				sum += nums[i];
		
		System.out.println(sum);
		System.out.println(012);
		
		int num2[] = {5,3,47,8,2};
		quick(num2, 0, num2.length-1);
		for(int i:num2){
			System.out.print(i+"\t");
		}
		
		System.out.println();
		int t = 125;
		t = t&27;
		t = t^31;
		System.out.println(t);
		
		int aa = 0xc396;
		int bb = 064474;
		System.out.println(aa^bb);
	//	System.out.println(function(2013));
		
		int result =0;
		for(int i=1;i<=10;i++){
			result += i;
		}
		System.out.println(result);
		
		System.out.println(func(5));
		System.out.println(func2(5));
	}
	
	public static void quick(int num[] ,int left,int right){
		if(left<right){
			int i=left;
			
			int j = right;
			int temp = num[i];
			while(i<j){
				while(i<j&&num[j]>temp){
					j--;
				}
				if(i<j){
					num[i] = num[j];
					i++;
				}
				while(i<j&&num[i]<temp){
					i++;
				}
				if(i<j){
					num[j] = num[i];
					j--;
				}
			}
			num[i] = temp;
			quick(num, left, i-1);
			quick(num, i+1, right);
		}
	}
	
	public static int function(int n){
		if(n==1){
			return n;
		}
		else if(n==0){
			return n;
		}
		else{
			return (function(n-1)+function(n-2))%5;
		}
	}
	
	public static int func(int n){
		int a[] = new int [n-1];
		for(int i=0;i<a.length;i++){
			a[i] = i+1;
		}
		
		int result=a[0] ;
		for(int i=1;i<a.length;i++){
			result ^= a[i];
		}
		
		System.out.println(result);
		
		int re = 1;
		for(int i=2;i<=n;i++){
			re ^= i;
		}
		
		return re^result;
	}
	
	public static int func2(int n){
		int a[] = new int [n-1];
		for(int i=0;i<a.length;i++){
			a[i] = i+1;
		}
		
		int sum1 =0;
		for(int i:a){
			sum1 += i;
		}
		
		int total = 0;
		for(int i=1;i<=n;i++){
			total += i;
		}
		
		return total - sum1;
	}

}

class AA{
	public void M(){
		System.out.println("A");
	}
}

class BB extends AA{
	public void M(){
		System.out.println("B");
	}
}

class C extends BB{
	public static void M2(){
		System.out.println("C");
	}
}
class D extends C{
	public static void M2(){
		System.out.println("D");
	}
}