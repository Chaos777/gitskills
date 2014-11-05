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
					.lookupPrintServices(flavor, pras);// 用户可选用的PrintService实例数组。
			int i = 0;
			for (PrintService ps : printService) {
				System.out.println(ps.getName());
				i++;
			}
*/
			PrintService defaultService = PrintServiceLookup
					.lookupDefaultPrintService(); // 默认的PrintService

	/*	//	PrintService service = ServiceUI.printDialog(null, 200, 200,,rintService, defaultService, flavor, pras);
*/
		//	if (service != null) {
				DocPrintJob job = defaultService.createPrintJob(); // 创建打印任务
				FileInputStream fis;

				fis = new FileInputStream(filename);

				DocAttributeSet das = new HashDocAttributeSet();

				/*
				 * 定义要打印的文档
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
