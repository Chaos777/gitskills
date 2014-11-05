
public class AAAQ extends BQ{
	static {
		System.out.println("load A");
	}
	public AAAQ(){
		System.out.println("create A");
	}
	
	
	@Override
	public void function() {
		// TODO Auto-generated method stub
		System.out.println("AAAQ");
	}
	
	public void funb(){
		System.out.println("HJAH");
	}


	public static void main(String []args){
		new AAAQ();
		
		BQ sBq = new AAAQ();
		sBq.function();
		
	}
}

class BQ extends Object{
	static{
		System.out.println("load B");
	}
	public BQ(){
		System.out.println("create B");
	}
	public void function(){
		System.out.println("B");
	}
}