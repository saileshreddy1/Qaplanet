package excelTesting;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;

public class Example {

	public static void main(String[] args) throws Exception 
	{
		
		File f= new File("D:\\workspace\\demo\\src\\excelWriteOperationFiles\\Excel.xls");
			
		Workbook wb = Workbook.getWorkbook(f);
		
		Sheet s=wb.getSheet("Sheet1");
				
		int i=1;
		
			String strBrow= s.getCell(0, i).getContents();
			String strURL= s.getCell(1, i).getContents();
			String strUN= s.getCell(2, i).getContents();
			String strPWD= s.getCell(3, i).getContents();
			String strEMAIL= s.getCell(4, i).getContents();
			
			System.out.println(strBrow);
			System.out.println(strURL);
			System.out.println(strUN);
			System.out.println(strPWD);
			System.out.println(strEMAIL);
		
		
			
			
//		File File=new File("D:\\workspace\\demo\\src\\excelFiles\\Excel.xls");
//        Workbook objWB=Workbook.getWorkbook(File); 
//        Sheet s1= objWB.getSheet(1); //1- Means second sheet, index start from 0
//        
//        //Get row count
//        int rows=s1.getRows();    
////        int cols=s1.getColumns();
//        for (int j=0;j<rows;j++)
//        {
//            String un=s1.getCell(0, j).getContents();    
//            String pwd=s1.getCell(1, j).getContents();    
//            System.out.println(un+" "+pwd);            
//        }

		
		
		
		
	}

}
