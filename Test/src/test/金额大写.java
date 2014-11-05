package test;

public class ½ğ¶î´óĞ´ {
	
	private final static char[] E={'Áã','Ò¼','·¡','Èş','ËÁ','Îé','Â½','Æâ','°Æ','¾Á','Ê°'};
	private final static char[] O={'Ôª','Ê°','°Û','Çª','Íò','Ê°','°Û','Çª','ÒÚ'};
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
		return sb.toString().replaceAll("Áã[Ê°°ÛÇª]", "Áã").
							replaceAll("Áã+Íò", "Íò").
							replaceAll("Áã+Ôª", "Ôª").replaceAll("Áã", "Áã");
	}

}
