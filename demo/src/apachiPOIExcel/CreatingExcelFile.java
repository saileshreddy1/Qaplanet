package apachiPOIExcel;


import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreatingExcelFile {

	public static void main(String[] args) throws IOException {
		
		
		
		String excelFileName = "D:/Test.xls";			// name of excel file

        String sheetName = "Sheet1";	// name of sheet

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);

// // iterating r number of rows

        for (int i = 0; i < 5; i++) 
        {
            HSSFRow row = sheet.createRow(i);
            // iterating c number of columns
            for (int j = 0; j < 5; j++) 
            {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue("Cell " + i + " " + j);
            }
		
		
        }
	
        FileOutputStream fileOut = new FileOutputStream(excelFileName);
 								
		//	write this workbook to an Outputstream.
      
		wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
        
        
//        HSSFWorkbook wb=new HSSFWorkbook();
//        HSSFSheet sheet=wb.createSheet("Cell Data");
//        
//        for (int i = 0; i < 10; i++)
//        {
//        	HSSFRow row=sheet.createRow(i);
//        	
//        	for (int j = 0; j < 10; j++) 
//        	{
//        		HSSFCell cell=row.createCell(j);
//        		
//        		cell.setCellValue("Cell "+i+" "+j);
//        		
//				
//			}
//        	
//			
//		}
//        FileOutputStream fos=new FileOutputStream("D:\\workspace\\demo\\src\\CreateApachiPoiExcel\\celldata.xls");
//        wb.write(fos);
//        fos.flush();
//        fos.close();
//        
        
        
        
        
        
        
        
}
}