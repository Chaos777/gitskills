import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ABC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Lock lock = new ReentrantLock();
		final int size  = 99999;
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			//	try {
					
					while(cont<=size){
						lock.lock();
						if(cont%3==0){
							System.out.println("A");
							cont++;
						}
						lock.unlock();
					}
			/*	} finally{
					lock.unlock();
				}*/
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			//	try{
					while(cont<=size){
						lock.lock();
						if(cont%3==1){
							System.out.println("B");
							cont++;
						}
						lock.unlock();
					}
				/*}
				finally{
					lock.unlock();
				}*/
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(cont<=size){
					lock.lock();
					if(cont%3==2){
						System.out.println("C");
						cont++;
					}
					lock.unlock();
				}
			}
		});
		
		t3.start();
		t2.start();
		t1.start();
	}
	
	private static int cont = 0;
	
	

	

}
