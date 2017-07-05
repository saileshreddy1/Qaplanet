package practiseOrangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrmTestCase1 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://apps.qaplanet.in/qahrm/login.php";
		Driver.get(sUrl);
		WebDriverWait wait =new WebDriverWait(Driver, 20);
		
		Boolean title=wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		if (title)
		{
			System.out.println("OrangeHRM - New Level of HR Management title displayed");
			
		}
		else 
		{
			System.out.println("OrangeHRM - New Level of HR Management title not displayed");
			return;
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));	
		WebElement objUN=Driver.findElement(By.name("txtUserName"));
		WebElement objPWD=Driver.findElement(By.name("txtPassword"));
		WebElement objLOGIN=Driver.findElement(By.name("Submit"));
		WebElement objCLEAR=Driver.findElement(By.name("clear"));
		
		if (objUN.isDisplayed() && objPWD.isDisplayed() && objLOGIN.isDisplayed() && objCLEAR.isDisplayed()) 
		{
			System.out.println("All the fileds in the login page are displayed");
			
		}
		else
		{
			System.out.println("All the fileds in the login page are not displayed");
			return;
		}
		
		String sUserName="qaplanet1";
		String sPassword="user1";
		
		objUN.clear();
		objPWD.clear();
		objUN.sendKeys(sUserName);
		
		objPWD.sendKeys(sPassword);
		
		objLOGIN.click();
		
		Boolean bLoginTitle=wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		if (bLoginTitle)
		{
			System.out.println("OrangeHRM title displayed");
			
		}
		else
		{
			System.out.println("OrangeHRM title not displayed");
		}
		
		
		String sWelcome=Driver.findElement(By.xpath("//div[@id='option-menu-bar']/ul/li[1]")).getText();
		
		if (sWelcome.equals("Welcome "+sUserName))
		{
			System.out.println("Welcome UserName displayed");
			
			
		}
		else
		{
			System.out.println("Welcome UserName not displayed");
			return;
		}
		
		
		WebElement objChangePassword=Driver.findElement(By.xpath("//a[text()='Change Password']"));
		WebElement objLogout=Driver.findElement(By.xpath("//a[text()='Logout']"));
				
		if (objChangePassword.isDisplayed() && objLogout.isDisplayed())
		{
			System.out.println("Change Password and Logout fields are displayed");
			
		}
		else
		{
			System.out.println("Change Password and Logout fields are not displayed");
			return;
		}
		
		objLogout.click();
		
		if (title)
		{
			System.out.println("Sign Off sucessfully Home page title displayed");
			
		}
		else
		{
			System.out.println("Sign Off sucessfully HomePage title not displayed");
			return;
		}
		
		Driver.close();
		Driver.quit();
		
		

	}

}
