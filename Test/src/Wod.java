import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;


public class Wod extends supe {
	
	public  String s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wod wod = new Wod();
		wod.fun();
		List<String> stack = new Stack<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> temp = new ArrayList<>();
		for(int i=0;i<100;i++){
			temp.add("asas");
		}
		
		for(String s:temp){
			if(map.containsKey(s)){
				map.put(s,map.get(s)+1);
			}
			else{
				map.put(s, 1);
			}
		}
		for(Entry<String,Integer> en:map.entrySet()){
			System.out.println(en.getKey()+";"+en.getValue());
		}
		TreeMap<Integer, Integer> m = new TreeMap<>();
		
	}
	
	
	
	public static void fun(final String s){
		final String string = "12sss";
		System.out.println("sub");
		class inner{
			public void function(){
				System.out.println(s+"s"+string);
			}
		}
		new inner().function();
	}

}

class supe{
	public static void fun(){
		System.out.println("super");
	}
}