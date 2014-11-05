package task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KDThread {
	private static Lock lock = new ReentrantLock();
	private static int state = 0;

	static class Thread1 extends Thread {
		@Override
		public void run() {
			while(true) {
				lock.lock();
				if (state % 3 == 0) {
					System.out.println("1");
					state++;
					
				}
				lock.unlock();
			}
		}
	}

	static class Thread2 extends Thread {
		@Override
		public void run() {
			while(true) {
				lock.lock();
				if (state % 3 == 1) {
					System.out.println("2");
					state++;
					
				}
				lock.unlock();
			}
		}
	}

	static class Thread3 extends Thread {
		@Override
		public void run() {
			while(true) {
				lock.lock();
				if (state % 3 == 2) {
					System.out.println("3");
					state++;
					
				}
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		new Thread1().start();
		new Thread2().start();
		new Thread3().start();
	}

}