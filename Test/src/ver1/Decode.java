package ver1;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

//import cn.netjava.UserColor;

public class Decode extends javax.swing.JFrame{

	//���ڵĻ���
	private java.awt.Graphics g;
	//�ļ��򿪵�·��
	private String path = null;
	//ͼ���ļ��Ĵ�С
	private int Filesize;
	//��ȡ������������
	private int ch1,ch2;
	//����ƫ����
	private int dataOffset;
	//ͼƬ�Ŀ�͸�
	private int image_width,image_heigh;
	//������ص����ɫ
	private int imageR[][],imageG[][],imageB[][];
	
	//��ȡģ
	  int skip_width=0;
	
	public  Decode(String path){
		this.path=path;
	}
	
	public void paint(java.awt.Graphics g){
      for (int h=0;h<image_heigh;h++){
		for (int w=0;w<image_width;w++){
			g.setColor(new java.awt.Color(imageR[h][w],imageG[h][w],imageB[h][w]));
			g.fillOval(w, h, 1, 1);
		}
	  }
	}
	
	
	/**
	 * ��ʾ���� BMP�ļ�
	 */
	public void doit(){
		try {
			// �����ļ�������
			java.io.FileInputStream fis = new java.io.FileInputStream(path);
			// ���ļ�����װ��һ������д�����������͵������
			java.io.DataInputStream dis = new java.io.DataInputStream(fis);

//			if(dis.read ()!='B'&&dis.read()!='M'){
//		          javax.swing.JOptionPane.showMessageDialog(null,"�����ҿ���Ц���������BMP�ļ�");
//		          return ;
//			}
			
			int bflen=14;                            
		    byte bf[]=new byte[bflen];             
		    dis.read(bf,0,bflen); //��ȡ14�ֽ�BMP�ļ�ͷ
		    

		    int bilen=40;                  
		    byte bi[]=new byte[bilen];
		    dis.read(bi,0,bilen);//��ȡ40�ֽ�BMP��Ϣͷ
			    
		     // ��ȡһЩ��Ҫ����
		     image_width=ChangeInt(bi,7);        		//Դͼ���

		     System.out.println("��:"+image_width);
		     
		      image_heigh=ChangeInt(bi,11);       	//Դͼ�߶�
		     System.out.println("��:"+image_heigh);
		            											//λ��
		     int nbitcount=(((int)bi[15]&0xff)<<8) | (int)bi[14]&0xff;
		     System.out.println("λ��:"+nbitcount);
		            											//Դͼ��С
		     int nsizeimage=ChangeInt(bi,23);
		     System.out.println("Դͼ��С:"+nsizeimage);
		    
		     
	          if  (nbitcount  ==   24 )   {
		             showRGB24(dis);
		            }
		     
		     
	          
	          //�ر��ļ���
		     dis.close();
		    
		} catch (Exception ef) {
			ef.printStackTrace();
		}
	}
	
	
    public void showRGB24(DataInputStream dis) throws IOException{
       this.setTitle(path);
 	    //����һ��ͼƬ�Ĵ���һ����С
  	   this.setSize(image_width, image_heigh);
       this.setResizable(false);
 	   this.setVisible(true);
 	   g=this.getGraphics();
 	   
 	  
 	  if(!(image_width*3 % 4==0)){//ͼƬ�Ŀ�Ȳ�Ϊ0
 		 skip_width =4-image_width*3%4;
 	  }
 	  
 	  imageR = new int[image_heigh][image_width];
 	  imageG = new int[image_heigh][image_width];
 	  imageB = new int[image_heigh][image_width];
 	  
 	  
 	   //���ж�ȡ ���H,WΪ��������
 	   for (int h=image_heigh-1;h>=0;h--){
 	      for (int w=0;w<image_width;w++){
 	 //  ������ԭɫ
 	          int blue  = dis.read();
 	          int green = dis.read();
 	          int red = dis.read();
 	        	  imageB[h][w]=blue;
 	        	  imageG[h][w]=green;
 	        	  imageR[h][w]=red;
 	    	  if(w==0){
 	    		  System.out.println(dis.skipBytes(skip_width));
 	    		 
 	    	  }
 	      }
 	   }
 	   repaint();
    }
	//ת��int
	public int ChangeInt(byte[] bi,int start){
		return (((int)bi[start]&0xff)<<24)         		
				| (((int)bi[start-1]&0xff)<<16)
				| (((int)bi[start-2]&0xff)<<8)
				| (int)bi[start-3]&0xff;
	}
	
	
}
