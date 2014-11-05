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

						// �õ��źŵ�
						s.acquire();

						System.out.println("�̣߳�" + NO + "���ˡ�����");
						Thread.sleep((long) (Math.random() * 10000));

						// �����ˣ����źŵ����¹����ſ�
						System.out.println("�̣߳�" + NO + "�����ˡ�����");
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
