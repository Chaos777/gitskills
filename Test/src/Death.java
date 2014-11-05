
public class Death {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*for(int i=1;i<200;i++){
			new Thread(new Thre(1, 2)).start();
			new Thread(new Thre(2, 1)).start();
		}*/
		
		De1 de1 = new De1();
		De2 de2 = new De2();
		
		Thread t1 = new Thread(de1);
		Thread t2 = new Thread(de2);
		for(int i=0;i<100;i++){
			t1.start();
			t2.start();
		}
	}	
	
	static class Thre implements Runnable{
		
		int a,b;
		
		public Thre(int a,int b){
			this.a = a;
			this.b = b;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (Integer.valueOf(a)) {
				synchronized(Integer.valueOf(b)){
					System.out.println(a+b+"::"+Thread.currentThread().getName());
				}
			}
		}
		
		
		
	}

}

class Source {
	public static String o1 = "dd";
	public static String o2 = "dd";
}

class De1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (Source.o1) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (Source.o2) {
				System.out.println("线程1 正在运行中");
			}
		}
	}
	
}

class De2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (Source.o2) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (Source.o1) {
				System.out.println("线程2 正在运行中");
			}
		}
	}
	
}

