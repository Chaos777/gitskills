
public class MutilLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final MutilLock mutilLock = new MutilLock();
		new Thread(){
			public void run(){
				mutilLock.f1(10);
			}
		}.start();
	}
	
	public synchronized void f1(int count){
		if(count-->0){
			System.out.println("f1����f2��countֵ��"+count);
			Thread.yield();
			f2(count);
		}
	}
	
	public synchronized void f2(int count){
		if(count-->0){
			System.out.println("f2����f1��countֵ��"+count);
			Thread.yield();
			f1(count);
		}
	}

}

