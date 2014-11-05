package test;

import java.util.ArrayList;
import java.util.List;

public class È«ÅÅÁÐ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String>num = new ArrayList<>();
		for(int i=1;i<=4;i++){
			num.add(String.valueOf(i));
		}
		listAll(num, "");
	}
	
	public static void listAll(List<String> candite,String prefix){
		System.out.println(prefix);
		
		for(int i = 0;i<candite.size();i++){
			List<String> temp = candite;
			listAll(temp, prefix+temp.remove(i));
		}
	}

}
