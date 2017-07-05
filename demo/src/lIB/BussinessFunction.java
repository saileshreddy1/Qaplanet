package lIB;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BussinessFunction {

	WebDriver Driver;
	WebDriverWait wait;
	
	WebElement objUserName;
	WebElement objPassword;
	static String strCode;
	String strLastName;
	String strFirstName;
	
	
	
	public void configDriver(String Browser)
	{
		if (Browser.equals("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.16.1-win32\\geckodriver.exe");
			Driver=new FirefoxDriver();
			Reporter.log("FirefoxDriver launched To Automate TestCases");
		}
		else if (Browser.equals("IE")) 
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\admin\\Downloads\\IEDriverServer_Win32_3.4.0\\IEDriverServer.exe");
			Driver=new InternetExplorerDriver();
			Reporter.log("IEDriver launched To Automate TestCases");
		}
		else if (Browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			Driver=new ChromeDriver();
			Reporter.log("ChromeDriver launched To Automate TestCases");
		}
		else
		{
			Reporter.log("Invalid Driver Passed");
		}
		wait=new WebDriverWait(Driver, 60);
		Driver.manage().window().maximize();		
	
	}
	
	public void closeBrowser()
	{
		Driver.close();
	}
	
	public void quitBrowser()
	{
		Driver.quit();
	}
	
	public void openOrangeHRMApplication(String strURL)
	{
		Driver.get(strURL);
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		assertEquals(Driver.getTitle(), "OrangeHRM - New Level of HR Management");
		Reporter.log("OrangeHRM - New Level of HR Management title displayed at home page");
		objUserName=Driver.findElement(By.name("txtUserName"));
		objPassword=Driver.findElement(By.name("txtPassword"));
		assertTrue(objUserName.isDisplayed() && objPassword.isDisplayed());
		Reporter.log("UserNmae and Password text box feild exist");

	}
	
	public void loginToOrangeHRMApplication(String strUserName, String strPassword)
	{
		
		objUserName.sendKeys(strUserName);
		objPassword.sendKeys(strPassword);
		WebElement objSubmit=Driver.findElement(By.name("Submit"));
		WebElement objClear=Driver.findElement(By.name("clear"));
		assertTrue(objSubmit.isDisplayed() && objClear.isDisplayed());
		Reporter.log("Submit and Clear buttons are exist");
		objSubmit.click();
		
	}
	
	public void logoutFromOrangeHRMApplication(String strUserName)
	{
		
		wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		assertEquals(Driver.getTitle(), "OrangeHRM");
		Reporter.log("Dashboard Page Exist");
		String strWUN=Driver.findElement(By.xpath("//li[text()='Welcome qaplanet1']")).getText();
		assertTrue(strWUN.equals("Welcome "+strUserName));
		Reporter.log("Login to valid user");
		WebElement objChangePassword=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Logout']")));
		WebElement objLogout=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Logout']")));
		assertTrue(objChangePassword.isDisplayed() && objLogout.isDisplayed());
		Reporter.log("ChangePassword and Logout link Exist");
		objLogout.click();
		
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		assertEquals(Driver.getTitle(), "OrangeHRM - New Level of HR Management");
		Reporter.log("Sign-off sucessfully 'OrangeHRM - New Level of HR Management' title displayed at home page");
		
		
	}
	
	public void pimAddEmployee(String strLastName,String strFirstName) throws InterruptedException
	{
		WebElement objPIM=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='PIM']")));
		WebElement objAddEmployee=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Add Employee']")));
		Actions action=new Actions(Driver);
		action.moveToElement(objPIM).moveToElement(objAddEmployee).click().build().perform();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
		Reporter.log("Switched to frame");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[text()='PIM : Add Employee']"), "PIM : Add Employee"));
		assertEquals(Driver.findElement(By.xpath("//h2[text()='PIM : Add Employee']")).getText(), "PIM : Add Employee");
		Reporter.log("PIM : Add Employee page exist");
		
		WebElement objCode=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtEmployeeId")));
		BussinessFunction.strCode=objCode.getAttribute("value");
		
		WebElement objLastName=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtEmpLastName")));
		WebElement objFirstName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtEmpFirstName']")));
		WebElement objSave=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnEdit")));
		assertTrue(objCode.isDisplayed() && objLastName.isDisplayed() && objFirstName.isDisplayed() && objSave.isDisplayed());
		Reporter.log("Code, LastName, FirstName and Save Feilds are exist");
	
		
		
		objSave.click();
		Alert alert=Driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		if (alert.getText().equals("Last Name Empty!")) 
		{
			Reporter.log("Last Name Empty! alert message displayed");
			alert.accept();
		}
		else
		{
			Reporter.log("No alert present");
		}
		
		objLastName.sendKeys(strLastName);
		objSave.click();
		wait.until(ExpectedConditions.alertIsPresent());
		if (alert.getText().equals("First Name Empty!")) 
		{
			Reporter.log("First Name Empty! alert message displayed");
			alert.accept();
		}
		else
		{
			Reporter.log("No alert present");
		}
		objFirstName.sendKeys(strFirstName);
		objSave.click();
		Driver.switchTo().parentFrame();
		Thread.sleep(2000);
		WebElement objPim1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='PIM']")));
		WebElement objEmployeeList=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Employee List']")));
		action.moveToElement(objPim1).build().perform();
		objEmployeeList.click();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
		List<WebElement>RowCount=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr"));
		for (int i=1; i<=RowCount.size(); i++)
		{
			String strEmployeeID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			String strEmployeeName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			if (strEmployeeID.equals(strCode) && strEmployeeName.equals(strFirstName+" "+strLastName)) 
			{
				System.out.println("Table Data : "+ strEmployeeID+" "+strEmployeeName+" is displayed at : "+i);
				Reporter.log("Table Data"+ strEmployeeID+" "+strEmployeeName+" is displayed at i");
				break;
			}
			
		}
		
		Driver.switchTo().parentFrame();

	}
	
	public void editAddEmployee(String strLastName,String strFirstName, String strEditLastName,String strEditFirstName)
	{
		System.out.println(BussinessFunction.strCode);
		WebElement objPIM=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='PIM']")));
		assertTrue(objPIM.isDisplayed());
		
		Actions action=new Actions(Driver);
		action.moveToElement(objPIM).build().perform();
		Reporter.log("PIM webelement displayed");
		
		WebElement objEmployeeList=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Employee List']")));
		assertTrue(objEmployeeList.isDisplayed());
		objEmployeeList.click();
		Reporter.log("Employee List link displayed");
		
		Driver.switchTo().frame("rightMenu");
		
		boolean blnEmployeeInformation=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[text()='Employee Information']"), "Employee Information"));
		if (blnEmployeeInformation) 
		{
			Reporter.log("Employee Information page displayed in the frame");
		}
		else
		{
			Reporter.log("Employee Information page not displayed in the frame");
		}
		
		List<WebElement>objEditTabelData=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='data-table']/tbody/tr")));
		for (int i=1; i<objEditTabelData.size(); i++)
		{
			String strEmployeeID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			String strEmployeeName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			System.out.println(strEmployeeID+" "+strEmployeeName);
			if (strEmployeeID.equals(BussinessFunction.strCode) || strEmployeeName.equals(strFirstName+" "+strLastName))
			{
				System.out.println("hello");
				Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).click();
				Reporter.log("Clicked on employee name to make changes at : "+i);
				break;
				
				
			}
		}
		WebElement objEditAndSave=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnEditPers")));
		assertTrue(objEditAndSave.isDisplayed());
		Reporter.log("Edit and Save button displayed");
		objEditAndSave.click();
		
		WebElement objEmployeeCode=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtEmployeeId")));
		String strEmployeeId=objEmployeeCode.getAttribute("value");
		assertSame(strCode, strEmployeeId);
		Reporter.log("Add employee code and edit employee code both are same");
				
		WebElement objFirstName=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtEmpFirstName")));
		WebElement objLastName=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtEmpLastName")));
		assertTrue(objFirstName.isDisplayed() && objLastName.isDisplayed());
		Reporter.log("FirstName and LastName Feilds are displayed");
		
		objFirstName.click();
		objFirstName.clear();
		objFirstName.sendKeys(strEditFirstName);
		
		objLastName.click();
		objLastName.clear();
		objLastName.sendKeys(strEditLastName);
		objEditAndSave.click();
		
		WebElement objBackButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='backbutton']")));
		objBackButton.click();
		Reporter.log("Back button displayed");
		assertEquals(blnEmployeeInformation, "Employee Information");
		Reporter.log("Employee Information page displayed in the frame");
		
		for (int i=1; i<=objEditTabelData.size(); i++)
		{
			String strEmployeeID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			String strEditEmployeeName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			if (strEmployeeID.equals(BussinessFunction.strCode) && strEditEmployeeName.equals(strEditFirstName+" "+strEditLastName))
			{
				String strEditEmployeeData=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td")).getText();
				Reporter.log(strEditEmployeeData+" displayed at : "+i);
				break;
			}
		}
		
		Driver.switchTo().defaultContent();
		
		
	}
	
	
	
	
	
}
