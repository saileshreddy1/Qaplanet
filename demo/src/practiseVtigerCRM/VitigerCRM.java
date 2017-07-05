package practiseVtigerCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VitigerCRM {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://classroom:8888/");
		WebDriverWait wait=new WebDriverWait(Driver, 20);
		Boolean bLoginPageTitle=wait.until(ExpectedConditions.titleIs("vtiger CRM 5 - Commercial Open Source CRM"));
		if (bLoginPageTitle)
		{
			System.out.println("vtiger CRM 5 - Commercial Open Source CRM page displayed");
			
		}
		else
		{
			System.out.println("vtiger CRM 5 - Commercial Open Source CRM page not displayed");
			return;
			
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user_name']")));
		WebElement objUN=Driver.findElement(By.xpath("//input[@name='user_name']"));
		
		WebElement objPwd=Driver.findElement(By.xpath("//input[@name='user_password']"));
		
		WebElement objLogin=Driver.findElement(By.xpath("//input[@id='submitButton']"));
		
		if (objUN.isDisplayed() && objPwd.isDisplayed() && objLogin.isDisplayed())
		{
			System.out.println("UserName, Password and Login fields are displayed");
			
		}
		else
		{
			System.out.println("UserName, Password and Login fields are not displayed");
			return;
		}
		
		String sUserName="qaplanet1";
		String sPassword="user1";
		objUN.clear();
		objPwd.clear();
		objUN.sendKeys(sUserName);
		objPwd.sendKeys(sPassword);
		objLogin.click();
		
		
		Boolean bDashboardTitle=wait.until(ExpectedConditions.titleIs("user1 - Home - vtiger CRM 5 - Commercial Open Source CRM"));
		if (bDashboardTitle)
		{
			System.out.println("user1 - Home - vtiger CRM 5 - Commercial Open Source CRM page displayed");
			
		}
		else
		{
			System.out.println("user1 - Home - vtiger CRM 5 - Commercial Open Source CRM page not displayed");
			return;
		}
		
		String sXpath = "//td[@class='small']/table/tbody/tr/td/a";
		
		java.util.List<WebElement> links=Driver.findElements(By.xpath(sXpath));
		System.out.println(links.size());
		for (int i = 0; i < links.size(); i++)
		{
			String sLinkName = links.get(i).getText();
			
			if (links.get(i).isDisplayed()) 
			{
				System.out.println(sLinkName + " Links are displayed");
				
			}
			else
				{
				
				System.out.println(sLinkName + " Links are not displayed");

				}
			
		}
	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='searchBox']")));
		Driver.findElement(By.xpath("//input[@class='searchBox']")).click();
		
		
		WebElement objUser=Driver.findElement(By.xpath("//td[@class='small'][1]/img[1]"));
		Actions action=new Actions(Driver);
		WebElement objSignOut = Driver.findElement(By.xpath("//a[text()='Sign Out']"));
		
		
		if (objUser.isDisplayed() && objSignOut.isDisplayed()) 
		{
			System.out.println("User and SignOut links are displayed");
			
		} 
		else
		{
			System.out.println("User and SignOUt links are not displayed");
		}
		
		action.moveToElement(objUser).build().perform();
		objSignOut.click();
		
		if (bLoginPageTitle)
		{
			System.out.println("Sign off sucessfully vtiger CRM 5 - Commercial Open Source CRM page displayed");
			
		}
		else
		{
			System.out.println("Sign off sucessfully vtiger CRM 5 - Commercial Open Source CRM page not displayed");
			return;
			
		}
		
		

	}

}
