package ver1;

import java.awt.event.ActionEvent;

import javax.swing.filechooser.FileNameExtensionFilter;


public class MenuLisener implements java.awt.event.ActionListener{


	public void actionPerformed(ActionEvent e) {
		String commen = e.getActionCommand();
		if("����".equals(commen)){
			//System.out.println("111111111");
			javax.swing.JOptionPane.showConfirmDialog(null, "By Stchou 2010@NetJava","����",javax.swing.JOptionPane.YES_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE);
		}if("�˳�".equals(commen)){
			System.exit(0);
		}if("��".equals(commen)){
			//�����ļ�ѡ���
			javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
			//����
			   FileNameExtensionFilter filter = new FileNameExtensionFilter("BMP Images", "BMP");
			   chooser.setFileFilter(filter);
			//   System.out.println("22222222");
			   chooser.showOpenDialog(null);
			   //�õ�ѡ���ļ���·��
			   String path = chooser.getSelectedFile().getAbsolutePath();
			   //��������ʾͼ��
			   Decode decode = new Decode(path);
			   decode.doit();
			
		}if("����".equals(commen)){
			
		}
	}

}
