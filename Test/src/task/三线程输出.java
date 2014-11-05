package task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 三线程输出 {
	
	private static int index=0;
	private static Lock lock = new ReentrantLock(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		三线程输出  t = new 三线程输出();
		
		/*Thread1 t1 = t.new Thread1();
		Thread2 t2 = t.new Thread2();
		Thread3 t3 = t.new Thread3();*/
		new Thread(t.new Thread1(),"1").start();
		new Thread(t.new Thread2(),"2").start();
		new Thread(t.new Thread3(),"3").start();
	}
	
	class Thread1 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				lock.lock();
				if(index%3==0){
					System.out.println(Thread.currentThread().getName()+"1");
					index++;
				}
				
				lock.unlock();
			}
		}
		
	}
	
	class Thread2 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				lock.lock();
				if(index%3==1){
					System.out.println(Thread.currentThread().getName()+"2");
					index++;
				}
				
				lock.unlock();
			}
		}
		
	}
	
	class Thread3 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				lock.lock();
				if(index%3==2){
					System.out.println(Thread.currentThread().getName()+"3");
					index++;
				}
				
				lock.unlock();
			}
		}
		
	}

}
