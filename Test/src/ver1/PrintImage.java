package ver1;

import java.io.*; 
 
import javax.print.*; 
import javax.print.attribute.*; 
import javax.print.attribute.standard.*;
	


public class PrintImage { 
	
	public static void main(String args[]){
		PrintImage pImage = new PrintImage();
		pImage.drawImage("F:\\name\\test.pdf", 1);
	}
	
    public void drawImage(String fileName, int count){ 
        try { 
            DocFlavor dof = null; 
             
            if(fileName.endsWith(".gif")){ 
                dof = DocFlavor.INPUT_STREAM.GIF; 
            }else if(fileName.endsWith(".jpg")){ 
                dof = DocFlavor.INPUT_STREAM.JPEG; 
            }else if(fileName.endsWith(".png")){ 
                dof = DocFlavor.INPUT_STREAM.PNG; 
            }else if(fileName.endsWith(".pdf")){
            	dof = DocFlavor.INPUT_STREAM.PDF;
            }
            
         //   dof = DocFlavor.INPUT_STREAM.AUTOSENSE;
             
            PrintService ps = PrintServiceLookup.lookupDefaultPrintService(); 
             
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();             
            pras.add(OrientationRequested.PORTRAIT); 
             
            pras.add(new Copies(count)); 
            pras.add(PrintQuality.HIGH); 
            DocAttributeSet das = new HashDocAttributeSet(); 
            das.add(new MediaPrintableArea(0, 0, 4, 6, MediaPrintableArea.INCH));  
            FileInputStream fin = new FileInputStream(fileName);  
         
            Doc doc = new SimpleDoc(fin ,dof, das); 
             
            DocPrintJob job = ps.createPrintJob(); 
             
            job.print(doc, pras); 
            fin.close(); 
        } 
        catch (IOException ie) { 
            ie.printStackTrace(); 
        } 
        catch (PrintException pe) { 
            pe.printStackTrace(); 
        } 
    }  
     
}

