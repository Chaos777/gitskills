import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restaurant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Restaurant();
	}

	Meal meal;
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);
	ExecutorService exe = Executors.newCachedThreadPool();

	public Restaurant() {
		exe.execute(chef);
		exe.execute(waitPerson);
	}

}

class Meal {
	private final int orderNum;

	public Meal(int num) {
		this.orderNum = num;
	}

	public String toString() {
		return "Meal:" + orderNum;
	}
}

class WaitPerson implements Runnable {
	private Restaurant restaurant;

	public WaitPerson(Restaurant r) {
		this.restaurant = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal == null) {
						wait();
					}
					System.out.println("服务员正在拿" + restaurant.meal);
					synchronized (restaurant.chef) {
						restaurant.meal = null;
						restaurant.chef.notifyAll();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("服务进程中断");
		}
	}

}

class Chef implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (restaurant.meal != null) {
						wait();
					}
				}
				if (++count == 10) {
					System.out.println("放不下了，停一会");
				//	restaurant.exe.shutdownNow();
					wait();
				}
				System.out.println("完成菜");
				synchronized (restaurant.waitPerson) {
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
					
				}

				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("厨师进程中断");
		}

	}

	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant r) {
		this.restaurant = r;
	}
}