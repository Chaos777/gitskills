package task;

public class YY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "adaabc";
		String b = "aababbc";
		
		System.out.println(minimize(a, b));
		
		
		String str = "RRRGGGRGGGRGGRRRGGRRRGR";
		System.out.println(function(str));
		
		String[] c = {"type a","type b","type c","undo 10"};
		int[] t = {1,2,3,1000};
		System.out.println(getText(c,t));
	}
	
	public void main(){
		
	}
	
	public static int minimize(String a,String b){
		int alen = a.length();
		int blen = b.length();
		int count  =50;
		if(alen==blen){
			count=0;
			for(int i=0;i<alen;i++){
				if(a.charAt(i)!=b.charAt(i)){
					count++;
				}
			}
			return count;
		}
		
		String first = b.substring(1);
		String last = b.substring(0,b.length()-1);
		
		return Math.min(Math.min(minimize(a, first), minimize(a, last)), count);
	}
	
	public static int function(String str){
		int G=0;
		int R=0;
		int i;
		for(i=str.length()-1;i>=0;i--){				//计算最右边的R前边有几个G
			if(str.charAt(i)=='R'){
				break;
			}
		}
		while(i>0){
			if(str.charAt(i)=='G'){
				G++;
			}
			i--;
		}
		
		for(i=0;i<str.length();i++){
			if(str.charAt(i)=='G'){
				break;
			}
		}
		while(i<str.length()){
			if(str.charAt(i)=='R'){
				R++;
			}
			i++;
		}
		
		return R<G?R:G;
	}
	
	public static String getText(String[] cmds,int[] time){
		StringBuffer sb = new StringBuffer("");
		int t = time[time.length-1];
		for(int i=cmds.length-1;i>0;){   //从后往前读命令
			if(cmds[i].contains("undo")){  //  遇到undo命令
				if(time[i]-time[i-1]>100){  //如果是隔了100秒以上，则undo命令不失效
					i--;
					continue;
				}
				else{
					int u = Integer.parseInt(cmds[i].substring(5));
					t = time[i]-u-1;    //undo命令回退的时间
					while(time[i]>t){     
						i--;
					}
				}
			}
			else{
				sb.append(cmds[i].substring(5)); //遇到type命令
				i--;
			}
		}
		if(cmds[0].contains("undo"))   //第一个命令单独处理
			return sb.reverse().toString();
		else
			return sb.append(cmds[0].substring(5)).reverse().toString();
	}

}
