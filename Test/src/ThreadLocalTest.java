import java.util.Random;


public class ThreadLocalTest implements Runnable{
	
	private final static ThreadLocal STUDE_LOCAL = new ThreadLocal();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLocalTest test = new ThreadLocalTest();
		Thread t1 = new Thread(test, "A");
		Thread t2 = new Thread(test, "B");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		accessStudent();
	}
	
	public void accessStudent(){
		String curr =Thread.currentThread().getName();
		System.out.println(curr+" is running");
		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println("thread"+curr+" set age to "+age);
		Student student = getStudent();
		student.setAge(age);
		System.out.println("thresd "+curr+" first set age is "+student.getAge());
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("thread "+curr+" second read age is "+student.getAge());
	}
	
	protected Student getStudent(){
		Student student = (Student)STUDE_LOCAL.get();
		if(student==null){
			student = new Student();
			STUDE_LOCAL.set(student);
		}
		return student;
	}

}

class Student{
	
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}