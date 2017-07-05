package practiceFrountAccountting;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontAccounting {

	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://apps.qaplanet.in/frontaccounting/");
		WebDriverWait wait =new WebDriverWait(Driver, 20);
		wait.until(ExpectedConditions.titleIs("FrontAccounting 2.3.20 - Login"));
		if (Driver.getTitle().equals("FrontAccounting 2.3.20 - Login"))
		{
			System.out.println("Title displayed");
			
		}
		else {
			System.out.println("Title not displayed");
			return;
		}
		
		WebElement objUN=Driver.findElement(By.xpath("//div[@id='_page_body']/form/center/table/tbody/tr[3]/td[2]/input"));
		
		WebElement objPWD=Driver.findElement(By.xpath("//*[@id='_page_body']/form/center[1]/table/tbody/tr[4]/td[2]/input"));
				
		WebElement objLogin=Driver.findElement(By.xpath("//*[@id='_page_body']/form/center[2]/input"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='_page_body']/form/center/table/tbody/tr[3]/td[2]/input")));
		
		if (objUN.isDisplayed() && objPWD.isDisplayed() && objLogin.isDisplayed())
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
		
		wait.until(ExpectedConditions.titleIs("Main Menu"));
		if (Driver.getTitle().equals("Main Menu")) 
		{
			System.out.println("Main Menu title Displayed");
		}
		else
		{
			System.out.println("Main Menu title not displayed");
			return;
		}
		
		WebElement objSales=Driver.findElement(By.xpath("//div[@class='tabs']/a[1]"));
		
		WebElement objPurchases=Driver.findElement(By.xpath("//div[@class='tabs']/a[2]"));
		
		WebElement objItemandInventery=Driver.findElement(By.xpath("//div[@class='tabs']/a[3]"));
		
		WebElement objManufacturing=Driver.findElement(By.xpath("//div[@class='tabs']/a[4]"));
		
		WebElement objDimensions=Driver.findElement(By.xpath("//div[@class='tabs']/a[5]"));
		
		WebElement objBankingandGeneralLedger=Driver.findElement(By.xpath("//div[@class='tabs']/a[6]"));
		
		WebElement objSetup=Driver.findElement(By.xpath("//div[@class='tabs']/a[7]"));
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs']/a[1]")));
		if (objSales.isDisplayed() && objPurchases.isDisplayed() && objItemandInventery.isDisplayed() && objManufacturing.isDisplayed() && objDimensions.isDisplayed() && objBankingandGeneralLedger.isDisplayed() && objSetup.isDisplayed())
		{
			System.out.println("Links are displayed");
			
		}
		else
		{
			System.out.println("Links are not displayed");
			return;
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
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table[2]/tbody/tr[5]/td/div/a/b")));
		WebElement objClickHereToLoginAgain=Driver.findElement(By.xpath("html/body/table[1]/tbody/tr/td/table[1]/tbody/tr/td/table[2]/tbody/tr[5]/td/div/a/b"));
		if (objClickHereToLoginAgain.isDisplayed())
		{
			System.out.println("Click Here To Login Again link is displayed");
			
		}
		else
		{
			System.out.println("Click Here To Login Again link is not displayed");
			return;
		}
	
		Driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Driver.close();
		Driver.quit();
	}

}
