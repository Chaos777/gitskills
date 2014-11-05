package test;

public class MutilateThread {
	
	volatile static int test1 = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread t1 = new TestThread("test1");
		TestThread t2 = new TestThread("test2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println(MutilateThread.test1);
	}

}
class TestThread extends Thread{
	public TestThread(String n){
		super(n);
	}
	
	public void run(){
		synchronized (MutilateThread.class) {
			for(int i=0;i<1000000;i++){
				int oldV = MutilateThread.test1;
				MutilateThread.test1++;
				int newV = MutilateThread.test1;
				if(newV - oldV >1){
					System.out.println("found");
				}
			}
		}
		System.out.println(this.getName()+" thread end "+MutilateThread.test1);
	}
}