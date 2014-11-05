
public class Puzzle_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(yesOrNo("true")+" "+yesOrNo("Yes"));
	}
	
	static boolean yesOrNo(String s){
		s = s.toLowerCase();
		if(s.equals("yes")||s.equals("y")||s.equals("t")){
			s = "true";
		}
		
		return Boolean.getBoolean(s);
	}

}
