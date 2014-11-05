package test;

public class MostThread {
	
	
	private static Object s = new Object();
	private static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(;;){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					synchronized (s) {
						count +=1;
						System.err.println("新建线程#."+count);
					}
					/*for(;;){*/
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							// TODO: handle exception
							System.err.println(e);
						}
					/*}*/
				}
			}).start();
		}
	}

}
