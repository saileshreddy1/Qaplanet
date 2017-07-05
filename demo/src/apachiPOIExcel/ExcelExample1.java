package apachiPOIExcel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;



public class ExcelExample1 {

	
	public static void main(String[] args) throws Exception
	{
		
		InputStream ExcelFile= new FileInputStream("D:\\workspace\\demo\\src\\excelWriteOperationFiles\\Excel.xls");
		
		HSSFWorkbook objHWB= new HSSFWorkbook(ExcelFile);
		
		HSSFSheet objSheet=objHWB.getSheetAt(1);
		
		HSSFRow row;
		HSSFCell Cell;
		
//		Row row1;
//		Cell Cell1;
		
		Iterator<Row> rows=objSheet.rowIterator();	
		
		while (rows.hasNext()) 
		{
			
			
			row = (HSSFRow) rows.next();
			Iterator<org.apache.poi.ss.usermodel.Cell>cells=row.cellIterator();
			
			while(cells.hasNext())
			{
				
				Cell=(HSSFCell)cells.next();
				
				if (Cell.getCellType()==HSSFCell.CELL_TYPE_STRING)
				{
					
					System.out.println(Cell.getStringCellValue()+"");
				}
				else if (Cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC)
				{
					
					System.out.println(Cell.getNumericCellValue()+" ");
				}
				else
				{
						
				}
				
				
			}
			
		}
		
		
		
		
		
	}
	
	
	
}
