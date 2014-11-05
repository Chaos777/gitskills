import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ZFchaun extends ABssa{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabc";
		function(s);
		ZFchaun xFchaun = new ZFchaun();
		xFchaun.funv();
		/*funv();*/
		Map<String, Integer> temp = new HashMap<>();
		Integer integer = 125;
		Integer integer1 = 125;
		Integer integer2 = new Integer(125);
		System.out.println(integer==integer2);
	}
	
	 public  void funv(){
		 System.out.println("子方法中的默认实现");
	 }
	
	public static void function(String s){
		List<String> temp = new ArrayList<>();
		for(int i=0;i<s.length()+1;i++){
			for(int j=i+1;j<s.length()+1;j++){
				if(!temp.contains(s.substring(i, j))){
					temp.add(s.substring(i, j));
					System.out.println(s.substring(i,j));
				}
			}
		}
	}

}
 interface intefA{
	public abstract void func();
}
 interface interB extends intefA{
	 public abstract void func();
	 public abstract void func(String temp);
 }
 
 abstract class ABssa{
	 public  void funv(){
		 System.out.println("抽象方法中的默认实现");
	 }
 }
