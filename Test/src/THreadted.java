public class THreadted {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Object lock = new Object();
		synchronized (lock) {
			System.out.println("start");
			new Thread(new Runnable() {
				public void run() {
					synchronized (lock) {
						System.out.println("step2");
						lock.notify();
					}
				}
			}).start();
			System.out.println("step1");
			lock.wait();
			new Thread(new Runnable() {
				public void run() {
					synchronized (lock) {
						System.out.println("step3");
						lock.notify();
					}
				}
			}).start();
			lock.wait();
			System.out.println("end");
		}
	}

}
