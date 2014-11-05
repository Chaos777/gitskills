package task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KuaiDiT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Thread1().start();
		new Thread2().start();
		new Thread3().start();
	}
	
	private static Lock lock = new ReentrantLock();
	private static int index = 0;

	static class Thread1 extends Thread {
		@Override
		public void run() {
			while(true) {
				lock.lock();
				if (index % 3 == 0) {
					System.out.println("1");
					index++;
					
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
				if (index % 3 == 1) {
					System.out.println("2");
					index++;
					
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
				if (index % 3 == 2) {
					System.out.println("3");
					index++;
					
				}
				lock.unlock();
			}
		}
	}

}
