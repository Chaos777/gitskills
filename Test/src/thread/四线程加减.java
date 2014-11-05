package thread;

public class 四线程加减 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		四线程加减 test = new 四线程加减();
		Thread thread = null;
		Inc inc = test.new Inc();
		Dec dec = test.new Dec();
		
		for(int i=0;i<2;i++){
			thread = new Thread(inc);
			thread.start();
			thread = new Thread(dec);
			thread.start();
		}
		System.out.println("最终的值为："+test.j);
	}
	
	private  int j ;
	private class Inc implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<100;i++){
				inc();
			}
		}
		
	}
	
	private class Dec implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<100;i++){
				dec();
			}
		}
		
	}
	
	private synchronized void inc(){
		j++;
		System.out.println(Thread.currentThread().getName()+"_inc:"+j);
	}
	
	private synchronized void dec(){
		j--;
		System.out.println(Thread.currentThread().getName()+"_dec:"+j);

	}
	

}
