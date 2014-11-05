
public class tryCatchTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		tryCatchTest test = new tryCatchTest();
		try {
			String teString = test.test();
			Thread.sleep(500);
			System.out.println("return string:"+teString);
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	public String test() throws Throwable{
		String retString = "start";
		try {
			System.out.println("start String:"+retString);
			retString = "try inner";
			throw new Exception("Exception inner");
		} catch (Exception e) {
			// TODO: handle exception
			retString = "catch inner";
			return retString;
		}finally{
			retString = "finally inner";
			System.out.println("finally string:"+retString);
			return retString;
		}
	}

}
