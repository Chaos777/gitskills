package list;

public class 最长重复子串长度 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ddfdaaabbcc";
		function_01(str);
		
		/*L l = new L();
		l.func();
		H a = (H)l;
		a.func();
		a = new H();
		a.func();*/
	}
	
	public static void function_01(String str){
		int maxlen = 1;
		int templen = 1;
		int endindex = 0;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)==str.charAt(i-1)){
				templen++;
			}else{
				templen=1;
			}
			
			if(templen>maxlen){
				maxlen = templen;
				endindex = i;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=endindex;i>=endindex-maxlen+1;i--){
			sb.insert(0, str.charAt(i));
		}
		System.out.println(sb+":长度是"+maxlen);
		
	}

}

class H {
	public void func(){
		System.out.println("H");
	}
}

class L extends H{
	public void func(){
		System.out.println("L");
	}
}
