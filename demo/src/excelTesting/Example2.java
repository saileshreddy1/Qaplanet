package excelTesting;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;


public class Example2 {
public static void main(String[] args) throws Exception {
	
	
	File file=new File("D:\\workspace\\demo\\src\\excelWriteOperationFiles\\Excel.xls");
	Workbook wb=Workbook.getWorkbook(file);
	Sheet s=wb.getSheet("Sheet2");
	
	int iRow=s.getRows();
	
//	int iCol=s.getColumns();
	
	for (int i = 0; i < iRow; i++) 
	{
		String UserName=s.getCell(0, i).getContents();
		String Password=s.getCell(1, i).getContents();
		
		System.out.println(UserName+" "+Password);
		
	}
	
	
}
}
