
public class XX5 {
	public XX5 aMethod(){
		return this;
	}
}

class YY7 extends XX5{
	public void aMethod(String s){
		
	}
	public XX5 aMethod(){
		return new YY7();
	}
}
