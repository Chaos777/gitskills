import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SmorephoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exe = Executors.newFixedThreadPool(100);
		
		final Semaphore s = new Semaphore(4);
		for (int i = 0; i < 10; i++) {
			final int NO = i + 1;

			Runnable run = new Runnable() {

				@Override
				public void run() {
					try {

						// 拿到信号灯
						s.acquire();

						System.out.println("线程：" + NO + "来了。。。");
						Thread.sleep((long) (Math.random() * 10000));

						// 用完了，把信号灯重新挂在门口
						System.out.println("线程：" + NO + "用完了。。。");
						s.release();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};

			exe.execute(run);
		}

		exe.shutdown();
	}

}
