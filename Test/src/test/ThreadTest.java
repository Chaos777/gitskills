package test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleArray shArray = new SimpleArray(9);
		
		ArrayWrite write1 = new ArrayWrite(1, shArray);
		ArrayWrite write2 = new ArrayWrite(11, shArray);
		ArrayWrite write3 = new ArrayWrite(16, shArray);
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(write1);
		executorService.execute(write2);
		executorService.execute(write3);
		
		executorService.shutdown();
		
		try {
			boolean task = executorService.awaitTermination(1, TimeUnit.MINUTES);
			
			if(task){
				System.out.println(shArray);
			}
			else{
				System.out.println("Timed out while waiting for tasks to finish.");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ArrayWrite implements Runnable{
	
	private final SimpleArray sharedSimpleArray;
	private final int startValue;
	
	public ArrayWrite(int value,SimpleArray array){
		startValue = value;
		sharedSimpleArray = array;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=startValue;i<startValue+3;i++){
			sharedSimpleArray.add(i);
		}
	}
	
}

class SimpleArray{
	
	private final int array[];
	private int writeIndex = 0;
	private final static Random ge = new Random();
	
	public SimpleArray(int size){
		array = new int[size];
	}
	
	public synchronized void add(int value){
		int position = writeIndex;
		
		try {
			Thread.sleep(ge.nextInt(500));
		} catch (Exception e) {
			// TODO: handle exception
		}
		array[position] = value;
		System.out.printf("%s wrote %2d to element %d.\n", Thread.currentThread().getName(),value,position);
		++writeIndex;
		System.out.printf("Next write index: %d\n", writeIndex );
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("Êý×éÖµ:");
		for(int i:array){
			sb.append(i+" ");
		}
		
		return sb.toString();
	}
}