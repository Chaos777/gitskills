
public class wy implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//	for(int i=0;i<100;i++){
			Thread t = new Thread(new wy());
			t.start();
			System.out.print("m1");
	//		t.join();
			System.out.print("m2");
			System.out.println();
	//	}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("r1");
		System.out.print("r2");
	}

}
