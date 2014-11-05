package task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class wy extends Test1 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public wy(){
		System.out.print("C");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*wy wy = new wy();
		try {
			FileOutputStream fos = new FileOutputStream("tes.txt");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(wy);
			fos.close();
			
			FileInputStream fin = new FileInputStream("tes.txt");
			ObjectInputStream in = new ObjectInputStream(fin);
			wy wy2 = (wy)in.readObject();
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		String str = "0***0******************";
		long start = System.currentTimeMillis();
		function(str,0);
		long end = System.currentTimeMillis();
		System.out.println((end-start)/60000.0);
	}
	
	public static void function(String str,int first){
		int index = -1;
		for(int i=first;i<str.length();i++){
			if(str.charAt(i)=='*'){
				index = i;
				break;
			}
			
		}
		if(index == -1){
			System.out.println(str);
			return;
		}
		else{
			function(str.substring(0, index)+"0"+str.substring(index+1),index+1);
			function(str.substring(0, index)+"1"+str.substring(index+1),index+1);
		}
		
	}

}
class Test1 {
	public Test1(){
		System.out.print("P");
	}
}

