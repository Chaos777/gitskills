package task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HS {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String str = "E:\\Workspaces\\EclipseJAVA\\Test\\src\\task\\task.txt";
		function(str);
	}
	
	public static void function(String str)throws Exception{
		InputStreamReader in = new InputStreamReader(new FileInputStream(new File(str)),"gbk");
		BufferedReader bf = new BufferedReader(in);
		String line;
		while(null!=(line = bf.readLine())){
			System.out.println(Integer.parseInt(line, 16)+" "+line);
		}
		bf.close();
	}

}
