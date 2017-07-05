package excelTesting;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;


public class ExcelTesting {

	public static void main(String[] args) throws Exception {
		
		
		File file=new File("D:\\workspace\\demo\\src\\excelWriteOperationFiles\\Excel.xls");
		Workbook wb=Workbook.getWorkbook(file);
		Sheet s=wb.getSheet("Sheet2");
		
		int iRow=s.getRows();
		
//		int iCol=s.getColumns();
		
		for (int i = 0; i < iRow; i++) 
		{
			String UserName=s.getCell(0, i).getContents();
			String Password=s.getCell(1, i).getContents();
			
			System.out.println(UserName+" "+Password);
			
		}
		
		
//		File File=new File("D:\\workspace\\demo\\src\\excelWriteOperationFiles\\Excel.xls");
//        Workbook objWB=Workbook.getWorkbook(File); 
//        Sheet s1= objWB.getSheet(1); //1- Means second sheet, index start from 0
//        
//        //Get row count
//        int rows=s1.getRows();    
//        for (int j=0;j<rows;j++)
//        {
//            String un=s1.getCell(0, j).getContents();    
//            String pwd=s1.getCell(1, j).getContents();    
//            System.out.println(un+" "+pwd);            
//        }

		

	}

}
