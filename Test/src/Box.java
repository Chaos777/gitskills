import java.lang.reflect.Field;

public class Box{
	public double d;
	
	public static void main(String []args){
		try {
			Class clas = Class.forName("Box");
			Field fld = clas.getField("d");
			Box b = new Box();
			System.out.println("d="+b.d);
			fld.setDouble(b, 12.34);
			System.out.println("d="+b.d);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}