package task;

public class ���� {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		���� ss = new ����();
		t1 h1 = ss.new t1();
		t2 h2 = ss.new t2();
		/*new Thread(h1).start();
		new Thread(h2).start();*/
		
		
		System.out.println(t1.class+":"+h1.getClass()+":"+Class.forName("task.����$t1"));
	}
	
	private static Object objec1 = new Object();
	private static Object objec2 = new Object();
	
	public void func1(){
		synchronized (objec1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (objec2) {
				System.out.println("����1������");
			}
		}
	}
	
	public void func2(){
		synchronized (objec2) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (objec1) {
				System.out.println("����2������");
			}
		}
	}
	
	class t1 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			func1();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	class t2 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			func2();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
