package task;

public class Str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdef";
		String str2 = "abx";
		function_01(str1, str2);
	}
	
	public static void function_01(String str1,String str2){
		for(char c:str2.toCharArray()){
			if(str1.contains(c+"")){
				System.out.println(c+"´æÔÚ");
			}
			else{
				System.out.println(c+"²»´æÔÚ");
			}
		}
	}

}
