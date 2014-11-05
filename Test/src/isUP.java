
public class isUP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ASBD";
		System.out.println(function(str));
		
		String s1 = "Good";
		s1 = s1+"morning";
		System.out.println(s1.intern());
		
		String s2 = "Goodmorning";
		System.out.println(s1==s2);
		short a = 128;
		byte b =(byte)a;
		System.out.print(a+"f"+b);
		String st = "数据";
		char [] t = {'数','据'};
		System.out.println(st.equals(t));
		
		isUP isUP = new isUP();
		isUP.Dog d = isUP.new Dog("s", 3);
		d.step = 25;
		d.run(d);
		System.out.println("asasa" instanceof Object);

	}
	
	public static boolean function(String str){
		for(int i=0;i<str.length();i++){
			if(!Character.isUpperCase(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	class Dog{
		private String name;
		private int age;
		private int step;
		
		public Dog(String a,int s){
			this.name = a;
			this.age = s;
			step=0;
		}
		
		public void run(Dog fist){
			fist.step++;
		}
	}

}
