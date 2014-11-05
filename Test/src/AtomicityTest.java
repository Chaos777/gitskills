import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AtomicityTest implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService ex = Executors.newCachedThreadPool();
		AtomicityTest ac = new AtomicityTest();
		ex.execute(ac);
		while(true){
			int val = ac.getValue();
			if(val%2!=0){
				System.out.println(val);
				System.exit(0);
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			evenIncreament();
		}
	}
	
	private  int i = 0;
	public  int getValue(){
		return i;
	}
	private synchronized void evenIncreament(){
		i++;
		i++;
	}

}
