package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ×éºÏ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arry = new String[]{"1","2","3","4"};
		listAll(Arrays.asList(arry), "");
	}
	
	public static void listAll(List<String> list,String prefix){
		if(list.isEmpty()){
			System.out.println(prefix);
		}
		
		for(int i=0;i<list.size();i++){
			List<String> temp = new LinkedList<>(list);
			listAll(temp, prefix+temp.remove(i));
		}
	}

}
