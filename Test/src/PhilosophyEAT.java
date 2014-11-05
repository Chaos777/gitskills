import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class PhilosophyEAT {
	
	/**
	 * ��ѧ�ҾͲ����⣬ǰ�ĸ����Һ������һ���������
	 * @throws InterruptedException 
	 * */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int p = 0;			//˼��ʱ��,Խ��Խ���ײ������
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
		
		
		
		/**��������*/
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
	public synchronized void take() throws InterruptedException{		//�ÿ���
		while(taken){
			wait();
		}
		taken = true;
	}
	
	public synchronized void drop(){								//������
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
				System.out.println(this+" "+"thinking ˼����" );
				pause();
				
				System.out.println(this+" "+"�����ұߵĿ���");
				right.take();
				
				System.out.println(this+" "+"������ߵĿ���");
				left.take();
				
				System.out.println(this+" "+"����");
				
				pause();
				
				right.drop();
				left.drop();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(this+" "+" �ж��˳�");
		}
	}
	
	public String toString(){
		return "Philosopher ��ѧ�� "+id;
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