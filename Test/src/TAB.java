import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*long start = System.currentTimeMillis();
		Th aTh = new Th();		
		
		Thread thread1 = new Thread(aTh);
		thread1.start();
		
		while(Th.cnt<10000){
			
		}
		long mid = System.currentTimeMillis();
		
		Th hTh = new Th();
		for(int i=0;i<10000;i++){			
			hTh.fun();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((mid-start)+";;;"+(end-mid));*/
		
		tg tg = new tg();
		Thread [] threads = new Thread[10];
		for(int i=0;i<threads.length;i++){
			threads[i] = new Thread(tg, "jj"+i);
			threads[i].start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tgh tgh = new tgh();
		Thread [] threads2 = new Thread[10];
		for(int i=0;i<threads2.length;i++){
			threads2[i] = new Thread(tgh, "kk"+i);
			threads2[i].start();
		}
	}

}

class tgh implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			lock.lock();
			i++;
			System.out.println(Thread.currentThread().getName()+";"+i);
		} finally{
			lock.unlock();
		}
	}
	private Lock lock = new ReentrantLock();
	private int i  = 0;
	
}

class tg implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			i++;
			System.out.println(Thread.currentThread().getName()+";;"+i);
		}
		
	}
	
	private int i = 0;
	
}

class Th implements Runnable{
	
	int a = 0;
	static int cnt=0;
	String file = "F:\\out.txt";
	String file2 = "F:\\out2.txt";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			for(int i=0;i<10000;i++){
				a = a+1;
				try {
					write(file,a+";;");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//	System.out.println(Thread.currentThread().getName()+"--"+a);
		}
	//	Thread.yield();
		//System.out.println("hhh"+a);
	}
	
	public void fun(){
		
		a = a+1;
		try {
			write(file2,a+";;");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void write(String filename,String content) throws Exception{
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File(filename),true));
		out.write(content+"\r\n");
		
		out.close();
		cnt++;
	}
	
}