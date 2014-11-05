package goo;

public class Test19_5 {
	
	/**
	 * http://www.cricode.com/2450.html
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "RYGB";
		String g = "YRRR";
		function(s, g);
	}
	
	public static void function(String solution,String guess){
		int fit = 0;
		int pre_fit =0;
		int num = 26;
		int guess_count[] = new int[num];
		int solut_count[] = new int[num];
		for(int i=0;i<solution.length();i++){
			if(solution.charAt(i)==guess.charAt(i)){
				fit++;
			}
			++guess_count[(int)guess.charAt(i)-'A'];
			++solut_count[(int)solution.charAt(i)-'A'];
		}
		char []colors = {'R','G','B','Y'};
		for(int i=0;i<colors.length;i++){
			int idx =(int)(colors[i]-'A');
			pre_fit += Math.min(guess_count[idx], solut_count[idx]);
		}
		
		pre_fit -= fit;
		
		System.out.println(fit+"::"+pre_fit);
		
	}

}
