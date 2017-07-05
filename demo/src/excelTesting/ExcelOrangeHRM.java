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

public class ExcelOrangeHRM {

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
	public void Testcase() throws Exception
	{
		
		File file=new File("D:\\workspace\\demo\\src\\excelWriteOperationFiles\\Excel.xls");
		
		Workbook objWB=Workbook.getWorkbook(file);
		Sheet objSheet=objWB.getSheet(1);
		
		int iRow=objSheet.getRows();
		
		for (int i = 1; i < iRow; i++) 
		{
			
			String strUserName=objSheet.getCell(0, i).getContents();
			String strPassword=objSheet.getCell(1,i).getContents();
			
			System.out.println(strUserName +" "+ strPassword);
			
			
			WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
			objUN.clear();
			objUN.sendKeys(strUserName);
			
			WebElement objPwd=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
			objPwd.clear();
			objPwd.sendKeys(strPassword);
			
			WebElement objlogin=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
			objlogin.click();
			
			
			if (Driver.getTitle().equals("OrangeHRM")) 
			{
				WebElement objlogout=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
				objlogout.click();
			}
			else
			{
					WebElement objUN1=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
					objUN1.clear();
					WebElement objPwd1=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
					objPwd1.clear();
					WebElement objClear=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("clear")));
					objClear.click();
			}
		}
		
		Driver.close();
		Driver.quit();
		
		
		
	}
	
}
