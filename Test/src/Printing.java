import javax.print.*;
import javax.print.attribute.*;
import java.io.*;

public class Printing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			String filename = "F:\\name\\test.pdf";

			PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

			/*PrintService printService[] = PrintServiceLookup
					.lookupPrintServices(flavor, pras);// �û���ѡ�õ�PrintServiceʵ�����顣
			int i = 0;
			for (PrintService ps : printService) {
				System.out.println(ps.getName());
				i++;
			}
*/
			PrintService defaultService = PrintServiceLookup
					.lookupDefaultPrintService(); // Ĭ�ϵ�PrintService

	/*	//	PrintService service = ServiceUI.printDialog(null, 200, 200,,rintService, defaultService, flavor, pras);
*/
		//	if (service != null) {
				DocPrintJob job = defaultService.createPrintJob(); // ������ӡ����
				FileInputStream fis;

				fis = new FileInputStream(filename);

				DocAttributeSet das = new HashDocAttributeSet();

				/*
				 * ����Ҫ��ӡ���ĵ�
				 */
				Doc doc = new SimpleDoc(fis, flavor, das);

				job.print(doc, pras);
				Thread.sleep(10000);
				fis.close();
			//}
			System.exit(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
