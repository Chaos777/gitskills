package test;

public class sta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*T t1 = new T();
		T t2 = new T();
		T t3 = new T();
		T t4 = new T();*/
		/*T t[] = new T[100];
		for(T t1:t){
			t1 = new T();
		}*/
		System.out.println(function(100));
	}
	
	public static int function(int n){
		return n>0?function(n-1)+n:0;
	}

}

class T{
	static int i=0;
	static int sum = 0;
	public T(){
		i++;
		sum += i;
		System.out.println(sum);
	}
}