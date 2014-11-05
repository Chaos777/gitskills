


public class Bee extends dy{

	public Bee(String name, String color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("fly");
		
	}


	/*@Override
	public void Attact() {
		// TODO Auto-generated method stub
		move();
	//	super.Attact();
		System.out.println("Attact");
	}*/


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dy bee = new Bee("bee1", "red");
		bee.Attact();
		
	}

}

class dy{
	private String name;
	private String color;
	
	public dy(String name,String color){
		this.name = name;
		this.color = color;
	}
	
	public void move(){
		System.out.println("Move");
	}
	
	public void Attact(){
		move();
		System.out.println("Attact");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}