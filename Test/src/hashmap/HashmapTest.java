package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashmapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Person, String> testMap = new HashMap<Person, String>();
		Person p1 = new Person();
		p1.setName("whu");
		p1.setHeight(100);
		
		Person p2 = new Person();
		p2.setName("nlp");
		p2.setHeight(1000);
		
		Person p3 = new Person();
		p3.setName("lcz");
		p3.setHeight(10000);
		
		System.out.println(p1+":"+p1.hashCode());
		System.out.println(p2+":"+p2.hashCode());
		System.out.println(p3+":"+p3.hashCode());
		
		testMap.put(p1, "p1");
		testMap.put(p2, "p2");
		testMap.put(p3, "p3");
		System.out.println("---------");
		p2.setName("nlp mode");
		System.out.println("修改之后的:"+p2+":"+p2.hashCode());
		System.out.println("---------");
		for(Entry<Person, String> entry:testMap.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue()+":"+entry.getKey().hashCode());			
			if(entry.getKey().getName().equals("whu")){
				System.out.println("没有改变"+(entry.getKey() == p1));
				
			}
			else if(entry.getKey().getName().equals("nlp mode")){
				System.out.println("已经发生改变"+(entry.getKey()==p2));
			}
			System.out.println();
		}
		
		System.out.println("---------");
		String p =testMap.get(p2);
		System.out.println("最后的结果"+p);
	}
	
	/*public V get(Object key) {     
		if (key == null)         
			return getForNullKey();     
		int hash = hash(key.hashCode());     
		for (Entry<K,V> e = table[indexFor(hash, table.length)];e != null;e = e.next) {
			Object k;         
			if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
				return e.value;     
		}     
		return null; 
	}*/
}
