import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;


public class ToastOMatic {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ToastQueue dryQueue = new ToastQueue();
		ToastQueue butterQueue = new ToastQueue();
		ToastQueue finishQueue = new ToastQueue();
		
		ExecutorService exe = Executors.newCachedThreadPool();
		exe.execute(new Toaster(dryQueue));
		exe.execute(new Butterer(dryQueue, butterQueue));
		exe.execute(new Jammer(butterQueue, finishQueue));
		exe.execute(new Eater(finishQueue));
		TimeUnit.SECONDS.sleep(5);
		exe.shutdownNow();
	}

}

class Toast{
	public enum Status{DRY,BUTTERED,JAMMED};
	private Status status = Status.DRY;
	
	private final int id;
	
	public Toast(int idn){
		this.id = idn;
	}
	public void butter(){
		status = Status.BUTTERED;
	}
	
	public void jam(){
		status = Status.JAMMED;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public int getId(){
		return id;
	}
	
	public String toString(){
		return "Toast "+id+": "+status;
	}
}
class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(!Thread.interrupted()){
				TimeUnit.MILLISECONDS.sleep(100+random.nextInt(500));
				Toast toast = new Toast(count++);
				System.out.println(toast);
				toastQueue.put(toast);
			}
		}catch(Exception e){
			System.out.println("Toaster 中断");
		}
		System.out.println("Toaster 关闭");
	}
	
	private ToastQueue toastQueue;
	private int count = 0;
	private Random random = new Random(47);
	public Toaster(ToastQueue q){
		this.toastQueue = q;
	}
	
}

class Butterer implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				Toast toast = dryQueue.take();
				toast.butter();
				System.out.println(toast);
				butteredQueue.put(toast);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Butterer 中断");
		}
		System.out.println("Butterer 关闭");
	}
	
	private ToastQueue dryQueue,butteredQueue;
	public Butterer(ToastQueue d,ToastQueue b)
	{
		this.dryQueue = d;
		this.butteredQueue = b;
	}
}

class Jammer implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				Toast toast = butterQueue.take();
				toast.jam();
				System.out.println(toast);
				finishedQueue.put(toast);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Jammer 中断");
		}
		System.out.println("Jammer 完成");
	}
	
	private ToastQueue butterQueue,finishedQueue;
	
	public Jammer(ToastQueue b,ToastQueue f){
		this.butterQueue = b;
		this.finishedQueue = f;
	}
	
	
}

class Eater implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				Toast toast = finishedQueue.take();
				if(toast.getId()!=count++||toast.getStatus()!=Toast.Status.JAMMED){
					System.out.println("错误 "+toast);
					System.exit(1);
				}
				else{
					System.out.println("Chomp!"+toast);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Eater 中断");
		}
		System.out.println("Eater 完成");
	}
	private ToastQueue finishedQueue;
	private int count = 0;
	public Eater(ToastQueue f){
		this.finishedQueue = f;
	}
	
}