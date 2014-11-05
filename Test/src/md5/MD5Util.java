package md5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MD5Util {
	public final static String MD5(String s) {
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));

			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args) {
		/*
		 * String[] ss = {"abd","125dfd","125dfd","����","����456"};
		 * 
		 * for(int i=0;i<ss.length;i++){ System.out.println(MD5(ss[i])); }
		 */
		
		String [] tem = {"0","7","9","d"};
		List<String> list = Arrays.asList(tem);
		function("Loben",list);
		

	}

	@SuppressWarnings("deprecation")
	public static void function(String name,List<String> s) {
		
		for(int i=0;;i++){
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MINUTE, new Date().getMinutes()+i);
		
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");			
			String date = df.format(calendar.getTime());			
			String temp = name+" "+ date;
			String target = MD5(temp);
		//	System.out.println(target);
			String tt = target.charAt(target.length()-1)+"";
			if(s.contains(tt)){
			//	System.out.println(date+"\t"+target);
				try {
					writeFile("C:\\Users\\LCZ\\Desktop\\out.txt",temp+"\n"+target+"\n\r\n","gbk");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void writeFile(String pathname,String content,String code) throws IOException, FileNotFoundException{
		File file = new File(pathname);
		if(!file.exists()){
			file.createNewFile();
		}
		
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathname,true),code);
		BufferedWriter writer = new BufferedWriter(out);
		writer.write(content);
		writer.close();
		out.close();
	}
}