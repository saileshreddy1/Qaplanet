package excelTesting;

import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelWriteOperations {
	
	public static void main(String[] args) throws Exception
	{
		
		
//		 WritableWorkbook wwb=Workbook.createWorkbook(new File("C:\\Login_Results.xls"));
//	     
//		 WritableSheet ws=wwb.createSheet("HRM", 0);
//	     
//		 WritableSheet ws1=wwb.createSheet("RES", 1);
//	     
//		 
//		 Label l=new Label(0,0,"Username");
//	     
//		 
//		 Label l1=new Label(1,0,"password");    
//	     
//		 
//		 Label r1=new Label(0,1,"qaplanet");
//	     
//		 
//		 Label r2=new Label(1,1,"admin");
//	     		 
//		 ws.addCell(l);
//	     		 
//		 ws.addCell(l1);
//	     	 
//		 ws.addCell(r1);
//	     
//		 ws.addCell(r2);
//	     
//		 wwb.write();
//	     
//		 wwb.close();
	
		
		WritableWorkbook objWWB=Workbook.createWorkbook(new File("C:\\Users\\admin\\Desktop\\PractiseExcel.xls"));
		
		WritableSheet ws=objWWB.createSheet("HRM", 0);
		
//		WritableSheet ws1=objWWB.createSheet("RES", 1);
		
		Label l1=new Label(0, 0, "UserName");
		
		Label l2=new Label(1, 0, "Password");
		
		Label l3=new Label(0, 1, "qaplanet1");
		
		Label l4=new Label(1, 1, "user1");
		
		Label l5=new Label(0, 2, "qaplanet2");
		
		Label l6=new Label(1, 2, "user2");
		
		ws.addCell(l1);
		ws.addCell(l2);
		ws.addCell(l3);
		ws.addCell(l4);
		ws.addCell(l5);
		ws.addCell(l6);
		
		objWWB.write();
		objWWB.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
