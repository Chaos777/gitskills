import java.util.Map;
import java.util.TreeMap;


public class DYG implements Cloneable{

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		DU <String>aDu = new DU("String");
		DU <String>cDu = new DU("String");
		DU <Integer>bDu = new DU(5);
		
		System.out.println(aDu.str.getClass().getName());
		DYG ad = new DYG();
		DYG bd = (DYG)ad.clone();
		Map<String, String> map  = new TreeMap<>();
		
	}

}

class  DU<T>{
	public T str;
	
	public DU(T t){
		this.str = t;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DU<T> other = (DU<T>) obj;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}
	
}