import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class PhilosophyEAT {
	
	/**
	 * 哲学家就餐问题，前四个先右后左，最后一个先左后右
	 * @throws InterruptedException 
	 * */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int p = 0;			//思考时间,越短越容易测出死锁
		int size =5;
		ExecutorService exe = Executors.newCachedThreadPool();
		Chopstick [] chopsticks = new Chopstick[size];
		for(int i=0;i<size;i++){
			chopsticks[i]  = new Chopstick();
		}
		
		for(int i=0;i<size;i++){
			if(i<(size-1)){
				exe.execute(new Philosopher(chopsticks[i], chopsticks[i+1], i, p));
			}
			else{
				exe.execute(new Philosopher(chopsticks[0], chopsticks[i], i, p));

			}
		}
		TimeUnit.SECONDS.sleep(2);
		exe.shutdownNow();
		
		
		
		/**死锁调度*/
		/*int p = 0;
		int size =5;
		ExecutorService exe = Executors.newCachedThreadPool();
		Chopstick [] chopsticks = new Chopstick[size];
		for(int i=0;i<size;i++){
			chopsticks[i]  = new Chopstick();
		}
		
		for(int i=0;i<size;i++){
			
			exe.execute(new Philosopher(chopsticks[i], chopsticks[(i+1)%size], i, p));
			
		}*/
	//	TimeUnit.SECONDS.sleep(5);
		//exe.shutdownNow();
		
	}

}

class Chopstick {
	private boolean taken = false;
	public synchronized void take() throws InterruptedException{		//拿筷子
		while(taken){
			wait();
		}
		taken = true;
	}
	
	public synchronized void drop(){								//还筷子
		taken = false;
		notifyAll();
	}
}

class Philosopher implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted()){
				System.out.println(this+" "+"thinking 思考中" );
				pause();
				
				System.out.println(this+" "+"拿起右边的筷子");
				right.take();
				
				System.out.println(this+" "+"拿起左边的筷子");
				left.take();
				
				System.out.println(this+" "+"开吃");
				
				pause();
				
				right.drop();
				left.drop();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(this+" "+" 中断退出");
		}
	}
	
	public String toString(){
		return "Philosopher 哲学家 "+id;
	}
	
	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int ponderFactor;
	
	private Random random = new Random(47);
	
	private void pause() throws InterruptedException{
		if(ponderFactor==0){
			return ;
		}
		TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor*250));
	}
	
	public Philosopher(Chopstick l,Chopstick r,int i,int p){
		this.left = l;
		this.right = r;
		this.id = i;
		this.ponderFactor = p;
	}
}