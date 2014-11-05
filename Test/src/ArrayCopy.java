import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dtiel [] temo = new Dtiel[5];
		for(int i=0;i<5;i++){
			Dtiel d = new Dtiel("String;"+i, i);
			temo[i] = d;
		}
		for(Dtiel d:temo){
			System.out.println(d);
		}
	
		Dtiel copydDtiel[] = Arrays.copyOf(temo, 5);
		Dtiel cloneDtiel[] = temo.clone();		
		copydDtiel[0].setName("修改");;
		System.out.println("修改之后");
		for(Dtiel d:temo){
			System.out.println(d);
		}
		cloneDtiel[0].setName("whu");
		System.out.println("----");
		for(Dtiel d:temo){
			System.out.println(d);
		}
		
		StringBuffer [] temp  = new StringBuffer[5];
		for(int i=0;i<5;i++){
			temp[i] = new StringBuffer(i+":num");
		}
		for(StringBuffer sb:temp){
			System.out.println(sb);
		}
		
		StringBuffer [] copy = Arrays.copyOf(temp, 5);
		copy[0].append("ksjdksjdk");		
		System.out.println("_____");
		for(StringBuffer sb:temp){
			System.out.println(sb);
		}
		StringBuffer [] coBuffers = new StringBuffer[5];
		Collections.copy(Arrays.asList(copydDtiel), Arrays.asList(temo));
		List<Dtiel> org = new ArrayList<>();
		for(int i=0;i<5;i++){
			Dtiel dtiel = new Dtiel("String :"+i, i);
			org.add(dtiel);
		}
		
		for(Dtiel d:org){
			System.out.println(d);
		}
		
		List<Dtiel> cop = new ArrayList<>();
		for(int i=0;i<5;i++){
			cop.add(null);
		}
		Collections.copy(cop, org);
		cop.get(0).setName("如是说");		
		
		System.out.println("----");
		for(Dtiel d:org){
			System.out.println(d);
		}
	}

}

class Dtiel implements Cloneable {
	private String name;
	private int size;
	
	public Dtiel(String n,int s){
		this.name = n;
		this.size = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Dtiel [name=" + name + ", size=" + size + "]";
	}
	public Dtiel clone() throws CloneNotSupportedException{
		return new Dtiel(new String(name),size);
	}
	
}
