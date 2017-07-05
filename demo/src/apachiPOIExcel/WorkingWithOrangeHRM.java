package apachiPOIExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkingWithOrangeHRM 
{
	
	
	ChromeDriver Driver;
	WebDriverWait wait;
	@BeforeMethod 
	public void startBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://apps.qaplanet.in/qahrm/login.php";
		Driver.get(sUrl);
		wait =new WebDriverWait(Driver, 20);
	}
	
	@Test
	public void testCaseOrangeHRM() throws IOException, Exception
	{
		
		InputStream ExcelFile=new FileInputStream("C:\\Users\\admin\\Desktop\\Excel.xls");
		
		HSSFWorkbook objWB=new HSSFWorkbook(ExcelFile);
		HSSFSheet	sheet=objWB.getSheetAt(1);
		
		 
		HSSFWorkbook objCWB=new HSSFWorkbook();
		HSSFSheet objCS=objCWB.createSheet("OrangeHRMData");
		
		
		HSSFRow r=objCS.createRow(0);
		
		r.createCell(0).setCellValue("OrangeHRM_User_Name");
		r.createCell(1).setCellValue("OrageHRM_Password");
		r.createCell(2).setCellValue("Result");
		
		
		int i=1;
		Iterator<Row> rows=sheet.rowIterator();
		rows.next();
		while (rows.hasNext()) 
		{
			HSSFRow	 row =(HSSFRow)rows.next();
						
			String strExpectedUserName=row.getCell(0).getStringCellValue();
			String strExpectedPassword=row.getCell(1).getStringCellValue();
			
			HSSFRow r1=objCS.createRow(i);
			r1.createCell(0).setCellValue(strExpectedUserName);
			r1.createCell(1).setCellValue(strExpectedPassword);
			 
			WebElement objUserName=Driver.findElement(By.name("txtUserName"));
			WebElement objPassword=	Driver.findElement(By.name("txtPassword"));
			WebElement objLogin=Driver.findElement(By.name("Submit"));
			objUserName.clear();
			objUserName.sendKeys(strExpectedUserName);
			
			objPassword.clear();
			objPassword.sendKeys(strExpectedPassword);
			objLogin.click();
			if (Driver.getTitle().equals("OrangeHRM"))
			{
				Driver.findElement(By.linkText("Logout")).click();
				r1.createCell(2).setCellValue("Login and logout Sucessfull");
			}
			else
			{
				WebElement objUN=Driver.findElement(By.name("txtUserName"));
				WebElement objPWD=	Driver.findElement(By.name("txtPassword"));
				objUN.click();
				objUN.clear();
				objPWD.click();
				objPWD.clear();
				WebElement objClear=Driver.findElement(By.name("clear"));
				objClear.click();
				r1.createCell(2).setCellValue("Failed to login");
			}
			
			i++;
			
			
		}
		
		FileOutputStream fos=new FileOutputStream("D:\\workspace\\demo\\src\\CreateApachiPoiExcel\\OrangeHRM.xls");
		objCWB.write(fos);
		fos.flush();
		fos.close();
		
		Driver.quit();
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
