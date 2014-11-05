package hashmap;

public class Person {
	
	private String name;
	private int height;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + "]";
	}
	
	@Override
	public int hashCode(){
	//	System.out.println(this.name+": HashCode() invoked!");
		return this.name.hashCode()+this.height;
	}
}
