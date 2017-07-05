package excelTesting;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelReadandWriteOperation2 
{
	ChromeDriver Driver;
	WebDriverWait wait;
	@BeforeMethod 
	public void startDriverser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://apps.qaplanet.in/qahrm/login.php";
		Driver.get(sUrl);
		wait =new WebDriverWait(Driver, 20);
	}
	
	
	@Test 
	public void TestCase() throws InterruptedException, Exception
	{
		
        File file=new File("D:\\workspace\\demo\\src\\excelWriteOperationFiles\\Excel.xls");
        
        Workbook objWB=Workbook.getWorkbook(file);
        
        Sheet sheet=objWB.getSheet(1);
        
        
        WritableWorkbook objWWB= Workbook.createWorkbook(new File("D:\\workspace\\demo\\src\\excelReadOperationFiles\\WriteOperation2.xls"));
        WritableSheet ws=objWWB.createSheet("Result", 0);
        
        Label l1=new Label(0, 0, "UserName");
        Label l2=new Label(1, 0, "Password");
        Label l3=new Label(2, 0, "Result");
        
        ws.addCell(l1);
        ws.addCell(l2);
        ws.addCell(l3);
        
        Label r1;
        Label r2;
        Label r3;
        
        
        int iRC=sheet.getRows();
        
        for (int i = 1; i <iRC ; i++) 
        {
        	String strUN=sheet.getCell(0, i).getContents();
        	
        	String strPWD=sheet.getCell(1, i).getContents();
        	
        	
        	WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
			objUN.clear();
			objUN.sendKeys(strUN);
			
			WebElement objPwd=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
			objPwd.clear();
			objPwd.sendKeys(strPWD);
			
			WebElement objlogin=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
			objlogin.click();
			
			Thread.sleep(2000);
			
			String strPassed="Passed";
			
			String strFailed="Failed";
			
			if (Driver.getTitle().equals("OrangeHRM"))
			{
				
				r1=new Label(0, i, sheet.getCell(0, i).getContents());
				
				r2=new Label(1, i, sheet.getCell(1, i).getContents());
				
				r3=new Label(2, i, strPassed);
				
				ws.addCell(r1);
				
				ws.addCell(r2);
				
				ws.addCell(r3);
				
	            Driver.findElement(By.linkText("Logout")).click();
	            Thread.sleep(2000);

			}
			else
			{
				r1=new Label(0, i, sheet.getCell(0, i).getContents());
				
				r2=new Label(1, i, sheet.getCell(1, i).getContents());
				
				r3=new Label(2, i, strFailed);
				
				
				ws.addCell(r1);
				ws.addCell(r2);
				ws.addCell(r3);
				
				WebElement objUN1=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
				objUN1.clear();
				
				WebElement objPwd1=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
				objPwd1.clear();
			}
			
		}
        
        
        objWWB.write();
        objWWB.close();
       
	}

	
	
	
}
