package test;

public class ����д {
	
	private final static char[] E={'��','Ҽ','��','��','��','��','½','��','��','��','ʰ'};
	private final static char[] O={'Ԫ','ʰ','��','Ǫ','��','ʰ','��','Ǫ','��'};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int money = 508;
		System.out.println(convert(money));

	}
	
	public static String convert(int money){
		StringBuffer sb = new StringBuffer();
		int count = 0;
		while(money!=0){
			sb.insert(0, O[count++]);
			int number = money%10;
			sb.insert(0, E[number]);
			money /= 10;

		}
		return sb.toString().replaceAll("��[ʰ��Ǫ]", "��").
							replaceAll("��+��", "��").
							replaceAll("��+Ԫ", "Ԫ").replaceAll("��", "��");
	}

}
