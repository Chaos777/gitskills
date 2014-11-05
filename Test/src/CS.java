import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class CS {
	/**
	 * ������������
	 * 
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBlockingQueue<String>queue = new LinkedBlockingQueue<>(10);
		
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			exe.execute(new Producetor(queue, "������"+i));
		}
		for(int i=0;i<1;i++){
			exe.execute(new Consumer(queue, "������"+i));
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	exe.shutdownNow();
	}

}
class Producetor implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
			//	if(queue.size()<=3){
					TimeUnit.MILLISECONDS.sleep(500);
					System.out.println(queue.size()+"�����ߣ�"+name);
					queue.put(name);
			//	}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�������ж�");
		}
	}
	private LinkedBlockingQueue<String> queue;
	private String name;
	
	public Producetor(LinkedBlockingQueue<String>q,String n){
		this.queue = q;
		this.name  = n;
	}
}

class Consumer implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				//if(queue.size()>=3){
					String name = queue.take();
					System.out.println(this.name+"�����ߣ�"+name);
					TimeUnit.MILLISECONDS.sleep(500);
			//	}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�������ж�");
		}
	}
	
	private LinkedBlockingQueue<String> queue;
	private String name;
	public Consumer(LinkedBlockingQueue<String>q,String n){
		this.queue = q;
		this.name = n;
	}
}