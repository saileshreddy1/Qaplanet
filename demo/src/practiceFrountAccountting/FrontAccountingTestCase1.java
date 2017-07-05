package practiceFrountAccountting;
import java.awt.AWTException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontAccountingTestCase1 {

	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://apps.qaplanet.in/frontaccounting/";
		Driver.get(sUrl);
		WebDriverWait wait =new WebDriverWait(Driver, 10);
		Boolean title =wait.until(ExpectedConditions.titleIs("FrontAccounting 2.3.20 - Login"));
		if (title)
		{
			System.out.println("FrontAccounting 2.3.20 - Login Title displayed");
			
		}
		else {
			System.out.println("FrontAccounting 2.3.20 - Login Title not displayed");
			return;
		}
		
		WebElement objUN=Driver.findElement(By.xpath("//div[@id='_page_body']/form/center/table/tbody/tr[3]/td[2]/input"));
		WebElement objPWD=Driver.findElement(By.xpath("//*[@id='_page_body']/form/center[1]/table/tbody/tr[4]/td[2]/input"));
		WebElement objCompany=Driver.findElement(By.name("company_login_name"));
		WebElement objLogin=Driver.findElement(By.xpath("//*[@id='_page_body']/form/center[2]/input"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='_page_body']/form/center/table/tbody/tr[3]/td[2]/input")));
		if (objUN.isDisplayed() && objPWD.isDisplayed() && objCompany.isDisplayed() && objLogin.isDisplayed())
		{
			System.out.println("UserName, Password and Login button fields are displayed");
			
		}
		else
		{
			System.out.println("UserName, Password and Login button fields are not displayed");
			return;
		}
		String sUN="qaplanet1";
		String sPWD="user1";
		objUN.sendKeys(sUN);
		objPWD.sendKeys(sPWD);
		objLogin.click();
		
		Boolean bDashboardTitle= wait.until(ExpectedConditions.titleIs("Main Menu"));
		if (bDashboardTitle) 
		{
			System.out.println("Main Menu DashboardTitle Displayed");
		}
		else
		{
			System.out.println("Main Menu DashboardTitle not displayed");
			return;
		}
		
		WebElement objBlock=Driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/div"));
		List<WebElement>objLinks=objBlock.findElements(By.tagName("a"));
		for (int i = 0; i < objLinks.size(); i++) 
		{
			String sLinkName= objLinks.get(i).getText();
			if (objLinks.get(i).isDisplayed())
			{
				System.out.println(sLinkName+" Displayed");
				
			}
			
		}

		WebElement objPreferences=Driver.findElement(By.xpath("//td[@class='logoutBarRight']/a[1]"));
		WebElement objChangepassword=Driver.findElement(By.xpath("//td[@class='logoutBarRight']/a[2]"));
		WebElement objLogout=Driver.findElement(By.xpath("//td[@class='logoutBarRight']/a[3]"));
		
		if (objPreferences.isDisplayed() && objChangepassword.isDisplayed() && objLogout.isDisplayed()) 
		{
			System.out.println("Links are displayed");
			
		}
		else
		{
			System.out.println("Links are not displayed");
			return;
		}
		objLogout.click();
		wait.until(ExpectedConditions.titleIs("Logout"));
		if (Driver.getTitle().equals("Logout"))
		{
			System.out.println("Sign-off sucessfully-- Logout page displayed");
			
		}
		else
		{
			System.out.println("Sign-off sucessfully-- Logout page not displayed");
			return;
		}
		Boolean bLogoutTitle=wait.until(ExpectedConditions.titleIs("Logout"));
		if (bLogoutTitle) 
		{
			System.out.println("Sign off sucessfully Logout title displayed");
			
		}
		else
		{
			System.out.println("Sign off sucessfully Logout title not displayed");
		}
		

		WebElement objClickHereToLoginAgain=Driver.findElement(By.xpath("//b[text()='Click here to Login Again.']"));
		if (objClickHereToLoginAgain.isDisplayed())
		{
			System.out.println("Click Here To Login Again link is displayed");
			
		}
		else
		{
			System.out.println("Click Here To Login Again link is not displayed");
			return;
		}
		
		objClickHereToLoginAgain.click();
		
		if (title)
		{
			System.out.println("FrontAccounting 2.3.20 - Login Title displayed");
		}
		else 
		{
			System.out.println("FrontAccounting 2.3.20 - Login Title not displayed");
			return;
		}
		Driver.close();
		Driver.quit();
	}

}
