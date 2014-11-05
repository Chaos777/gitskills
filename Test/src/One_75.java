import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import test.sta;


public class One_75 {
	
	
	/***
	 * 只有一是正确的，使用三个线程打印1-75，每个轮流打印5个数字
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService exe = Executors.newCachedThreadPool();
		/*for(int i=0;i<3;i++){
			exe.execute(new Printer(i));
		}*/
		Lock lock = new ReentrantLock(true);
		for(int i=1;i<=3;i++){
			exe.execute(new Printer01(i, lock));
		}
		
		
		
		/*for(int i=0;i<3;i++){
			exe.execute(new Printer02(i));
		}*/
		
		/*for(int i=0;i<3;i++){
			exe.execute(new Printer03(i));
		}
		*/
		/*for(int i=0;i<3;i++){
			exe.execute(new Printer04(i));
		}*/
		
		/*exe.shutdownNow();*/
		
	}
	
	

}
class Printer implements Runnable{
	/**正确的方法*/

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (Obj) {
			while(begin<=end){
				if(begin/5%3==id){
					System.out.print(id+":");
					for(int i=0;i<5;i++){
						System.out.print(begin+++" ");
					}
					System.out.println();
					Obj.notifyAll();
				}
				else{
					try {
						Obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println(id+"中断");
					}
				}
			}
		}
	}
	
	private static int begin =1;
	private static int end = 7500;
	private static String Obj = "jshdjsd";
	private int id;
	
	public Printer(int id){
		this.id =id;
	}
	
}

class Printer01 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int start = id*5-5;
		while(start<75){
			lock.lock();
			try {
				for(int i=0;i<5;i++){
					start++;
					System.out.print(start+" ");
				}
				System.out.println();
			} finally {
				
				lock.unlock();
			}
			start = start+10;
		}
	}
	
	private final int id;
	private final Lock lock;
	
	public Printer01(int id,Lock lock){
		this.id = id;
		this.lock = lock;
	}
	
}



/***
 * 错误
 * 
 * */
class Printer02 implements Runnable{
	private static int n = 1;
	private int id;
	
	private static Lock lock = new ReentrantLock();

	@Override
	public void run() {
		// TODO Auto-generated method stub
	//	try{
			lock.lock();
			while(n<=75){
				if(n/5%3==id){
					System.out.print(id+": ");
					for(int i=0;i<5;i++){
						System.out.print(n+++" ");
					}
					System.out.println();
				}
				else{
					lock.unlock();
				}
			}
		/*}
		finally{
			lock.unlock();
		}*/
	}
	
	public Printer02(int id){
		this.id = id;
	}
}

class Printer03 implements Runnable{

	@Override
	public  void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			while(n<=7500){
				if(n/5%3==id){
					System.out.print(id+":");
					for(int i=0;i<5;i++){
						System.out.print(n+++" ");
					}
					System.out.println();
					
				}
			}
		}
		
		
	}
	
	private static int n =1;
	
	private int id;
	
	
	/**
	 * 错误
	 * */
	public Printer03(int id){
		this.id = id;
	}
	
}

class Printer04 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(n<=75){
			if(n/5%3==id){
				System.out.print(id+":");
				for(int i =0;i<5;i++){
					System.out.print(n+++" ");
				}
				System.out.println();
			}
		}
	}
	
	private volatile static int n = 1;
	
	private int id;
	
	/**
	 * 错误
	 * 
	 * */
	public Printer04(int id){
		this.id = id;
	}
}