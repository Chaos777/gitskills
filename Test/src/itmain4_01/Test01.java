package itmain4_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Test01 {
	
	/**
	 *a文件，b文件交替写入c文件 
	 * @throws Exception 
	 * 
	 **/
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String apath = "E:\\Workspaces\\EclipseJAVA\\Test\\src\\itmain4_01\\a.txt";
		InputStreamReader inReaderA = new InputStreamReader(new FileInputStream(apath));
		BufferedReader bf = new BufferedReader(inReaderA);
	    ArrayList<String> acontent = new ArrayList<>();
	    String line;
	    while(null!=(line = bf.readLine())){
	    	acontent.add(line);
	    }
	    bf.close();
	    
	    String bpath = "E:\\Workspaces\\EclipseJAVA\\Test\\src\\itmain4_01\\b.txt";
		InputStreamReader inReaderB = new InputStreamReader(new FileInputStream(bpath));
		BufferedReader bfb = new BufferedReader(inReaderB);
	    ArrayList<String> Bcontent = new ArrayList<>();
	    String lineB;
	    while(null!=(lineB = bfb.readLine())){
	    	String[] strings = lineB.split(" \\|\\r\n");
	    	for(String s:strings)
	    		Bcontent.add(s);
	    }
	    bfb.close();
	    
	    String cpath = "E:\\Workspaces\\EclipseJAVA\\Test\\src\\itmain4_01\\c.txt";
	    OutputStreamWriter ouWriter = new OutputStreamWriter(new FileOutputStream(cpath));
	    BufferedWriter bWriter = new BufferedWriter(ouWriter);
	    int length = (acontent.size()>Bcontent.size()?Bcontent.size():acontent.size());
	    int i=0;
	    for(;i<length;i++){
	    	bWriter.write(acontent.get(i)+"\n"+Bcontent.get(i)+"\n");
	    }
	    while(i<acontent.size()){
	    	bWriter.write(acontent.get(i++)+"\n");
	    }
	    while(i<Bcontent.size()){
	    	bWriter.write(Bcontent.get(i++)+"\n");
	    }
	    bWriter.close();
	    ouWriter.close();
    }
   
}


