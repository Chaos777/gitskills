
public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thtest dThreadtest = new Thtest();
		Thread thread = new Thread(dThreadtest);
		thread.start();
		System.out.println("start");
		/*finally{
			System.out.println("ending");
		}*/
		for(int i=0;i<111;i++){
			System.out.println(func(5));
		}
	}
	
	public static int func(int n){
		if(n<=2){
			return n;
		}
		return func(n-1)+func(n-2);
	}
	
	

}
class Thtest implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("running:");
			e.printStackTrace();
		}
	}
	
}
