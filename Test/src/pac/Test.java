package pac;

public class Test {
	
	 
	class Base {
        Base() {
            this.info();
        }
        public void info() {
            System.out.println("Base");
        }
        public void getInfo() {
            info();
        }
    }
     
    public class Child extends Base{
        @Override
        public void info() {
            System.out.println("Child");
        }
    }
     
    public static void main(String[] args) {
        Test test = new Test();
        Base base = test.new Child();
        base.info();
        base.getInfo();
    }
}
