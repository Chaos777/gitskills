package ver1;

public class BMPMain extends javax.swing.JFrame{
	MyPanle myPanle = null;//�ҵ����
	static int windos_width=400,windos_height=300;
	
	
	
	
	public static void main(String[] args) {
		BMPMain main = new BMPMain();
		main.showUI();
	}

	/**
	 * ��ʾ����
	 */
	public void showUI(){
		this.setTitle("�ҵ�BMP������");
		this.setSize(windos_width, windos_height);
		this.setLocation(200, 100);
		this.setResizable(false);
		
		myPanle = new MyPanle();
		this.add(myPanle);
		
		this.setJMenuBar(getMB());
		this.setVisible(true);

	}
	
	//�õ��˵���
	public javax.swing.JMenuBar getMB(){
		javax.swing.JMenuBar mb = new javax.swing.JMenuBar();
		
		javax.swing.JMenu File = new javax.swing.JMenu("�ļ�");
		javax.swing.JMenu Help = new javax.swing.JMenu("����");
		
		javax.swing.JMenuItem open = new javax.swing.JMenuItem("��");
	//	javax.swing.JMenuItem save = new javax.swing.JMenuItem("����");
		javax.swing.JMenuItem exit = new javax.swing.JMenuItem("�˳�");
		File.add(open);
		//File.add(save);
		File.addSeparator();
		File.add(exit);
		
		
		javax.swing.JMenuItem about = new javax.swing.JMenuItem("����");
		Help.add(about);
		//��Ӳ˵�������
		MenuLisener al = new MenuLisener();
		about.addActionListener(al);
		open.addActionListener(al);
		//save.addActionListener(al);
		exit.addActionListener(al);
		
		mb.add(File);
		mb.add(Help);
		return mb;
	}
}



//�����Լ������
class MyPanle extends javax.swing.JPanel{
	
}
