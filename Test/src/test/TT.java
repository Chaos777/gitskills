package test;

public class TT {
	
	static int i = 0;
	public int aMethod(){
		
		i++;
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*S s = new S();
		P p = (P)s;
		p.method();
		p.smethod();*/
		TT tt = new TT();
		tt.aMethod();
		int j = tt.aMethod();
		System.out.println(j);
		
	}

}
