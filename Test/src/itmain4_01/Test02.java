package itmain4_01;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Test02 {
	
	
	/**
	 *��ָ��Ŀ¼�µ�ָ����ʽ���ļ����Ƶ�ָ��Ŀ¼�����޸�ԭ���ĸ�ʽ 
	 * @throws Exception 
	 * 
	 **/
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String pathname = "E:\\Workspaces\\ZJPC\\Healthy20131227\\src\\Spider\\";
		String destpath = "E:\\01\\";
		File dir = new File(pathname);
		if(!(dir.exists()||dir.isDirectory())){
			throw new Exception("Ŀ¼�����ڻ�ָ��Ŀ¼�Ƿ�");
		}
		File [] files = dir.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pathname.getName().endsWith(".java");
			}
		});
		File des = new File(destpath);
		if(!(des.exists())){
			des.mkdir();
		}
		for(File f:files){
			StringBuilder s = new StringBuilder();
			s.append(f.getName().replaceAll("\\.java$", ".jad"));
			FileInputStream fi = new FileInputStream(f);
			FileOutputStream fo = new FileOutputStream(new File(des.getPath()+"\\"+s.toString()));
			copy(fi, fo);
			fi.close();
			fo.close();
		}
	}
	
	private static void copy(InputStream ips,OutputStream ops) throws Exception{
        int len = 0;
        byte[] buf =new byte[1024];
        while((len =ips.read(buf)) != -1){
               ops.write(buf,0,len);
        }

 }


}
