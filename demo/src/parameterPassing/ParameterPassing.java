package parameterPassing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterPassing {
	private static ChromeDriver Driver;
	static WebDriverWait wait;
	@BeforeMethod
		public void stratBrowser()
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
//		Driver.get("http://classroom:90/webapp/AgeProb.html");
		wait=new WebDriverWait(Driver, 60);
		}
		
	@AfterMethod
	public void closeBrowser()
	{
//		Driver.quit();
	}
		@Test
		@Parameters({"strURL", "strUserName","strPassword"})
		public void testParameterPassing(String strURL, String strUserName, String strPassword)
		{
			
			wait=new WebDriverWait(Driver, 60);
			Driver.get(strURL);
			wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
			assertEquals(Driver.getTitle(), "OrangeHRM - New Level of HR Management");
			Reporter.log("Title Displayed as 'OrangeHRM - New Level of HR Management'");
			WebElement objName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
			WebElement objPwd=Driver.findElement(By.name("txtPassword"));
			WebElement objLogin=Driver.findElement(By.name("Submit"));
			assertTrue(objName.isDisplayed() && objPwd.isDisplayed() && objLogin.isDisplayed());
			Reporter.log("UserName Feild displayed");
			Reporter.log("Password Feild displayed");
			Reporter.log("Login Feild displayed");
			
			objName.sendKeys(strUserName);
			
			objPwd.sendKeys(strPassword);
			
			objLogin.click();
			
		}
		
		
		

	

}
