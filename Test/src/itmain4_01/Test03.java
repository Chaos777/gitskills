package itmain4_01;

import java.io.UnsupportedEncodingException;

public class Test03 {
	
	/**
	 * 
	 *��ȡ�ַ���������
	 *ABC���� ��5��ȡ����ABC��  
	 * @throws UnsupportedEncodingException 
	 * 
	 **/
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String str = "��ABC��DEF";
		int index = getIndex(str.getBytes("GBK"), 4);
		System.out.println(str.substring(0,index));
	}
	
	public static int getIndex(byte[] buf,int n){
		int index = 0;
		boolean flag = false;
		for(int i=0;i<n;i++){
			if(buf.length-1<0&&!flag){
				flag =true;
			}
			else{
				index++;
				flag =false;
			}
		}
		return index;
	}

}
