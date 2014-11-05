package task;

public class MutiThread {
	
	
	public  int i = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MutiThread muti = new MutiThread();
		Plus plus = muti.new Plus();
		Minu minu = muti.new Minu();
		
		for(int i=0;i<2;i++){
			Thread t1 = new Thread(plus);
			t1.start();
			Thread t2 = new Thread(minu);
			t2.start();
		}
		
	
	}
	
	class Plus implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<100;i++){
				plus();
			}
		}
		
	}
	
	class Minu implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<100;i++){
				minus();
			}
		}
		
	}
	
	public synchronized void minus(){
		i--;
		System.out.println(Thread.currentThread().getName()+": i="+i);
	}
	
	public synchronized void plus(){
		i++;
		System.out.println(Thread.currentThread().getName()+": i="+i);
	}

}


