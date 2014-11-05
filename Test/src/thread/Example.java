package thread;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);
		
		threadA.start();
		threadB.start();*/
		
		Counter countA = new Counter();
		Counter countB = new Counter();
		
		Thread threadA = new CounterThread(countA);
		Thread threadB = new CounterThread(countB);
		
		threadA.start();
		threadB.start();
	}

}

class Counter{
	long count = 0;
	
	public synchronized void add(long value){
		this.count += value;
	}
}

class CounterThread extends Thread{
	protected Counter counter = null;
	
	public CounterThread(Counter counter){
		this.counter = counter;
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			counter.add(i);		
			System.out.println(Thread.currentThread().getName()+"--"+counter.count);
		}
		
		
	}
}