package art;

public class ��1_3�ַ���ת��Ϊ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "-1234&567";
		System.out.println(function_01(s));
	}
	
	public static int function_01(String s){
		int result = 0;
		s = s.trim();
		int begin = 0;
		boolean isZ = true;
		if(s.charAt(0)=='+'){
			begin = 1;
			
		}
		else if(s.charAt(0)=='-'){
			begin = 1;
			isZ = false;
		}
		for(int i=begin;i<s.length();i++){
			if(s.charAt(i)>'9'||s.charAt(i)<'0'){
				result = 0;
				System.out.println("�Ƿ�����");
				break;				
			}
			else{
				result = 10*result+Integer.parseInt(s.charAt(i)+"");
			}
		}
		
		return (isZ)?result:-result;
	}
	

}
