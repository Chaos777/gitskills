
public class CVTE1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i =10;
		do {
			i /= 2;
		} while (i-->1);
		System.out.println(i);
		
		try {
			throw new TT();
		} catch (T e) {
			// TODO: handle exception
			System.out.println("T");
		}catch (Exception e) {
			System.out.println("Exception");
		}
	}

}
class T extends Exception{}
class TT extends T{}