package multipleWindowHandle;
import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandle {

//	https://mvnrepository.com/artifact/org.testng/testng/6.11
	
	ChromeDriver Driver;
	WebDriverWait wait;
	@BeforeMethod
	public void startApp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://qaplanet.in/";
		Driver.get(sUrl);
		wait=new WebDriverWait(Driver, 20);
	}
	
	
	@AfterMethod
	public void closeApp()
	{
		Driver.close();
		Driver.quit();
	}
	@Test
	public void windowHandle()
	{
	try
	{
		String strExpected="Best Training Institute for Testing Tools in Ameerpet, Hyderabad- QA Planet";

		String strActual=Driver.getTitle();
		//
		Driver.findElement(By.tagName("title")).getText();
		
	
		
		assertEquals(strActual, strExpected);
		
		
//		if (Driver.getTitle().equals("Best Training Institute for Testing Tools in Ameerpet, Hyderabad- QA Planet"))
//		{
//			System.out.println("Home page title displayed");
//			
//		}
//		else
//		{
//			System.out.println("Home page title not displayed");
//		}
		
	WebElement objLinkedIn=Driver.findElement(By.xpath("//div[@id='section-tophat']/div/div/div[2]/ul/li[4]/a/img"));
	objLinkedIn.click();
	
	Set<String> objwindowids=Driver.getWindowHandles();
	for(String WID:objwindowids)
	{
		System.out.println(WID);
	}
	Iterator<String> it=objwindowids.iterator();
	String strFirstWindow=it.next();
	String strSecondWindow=it.next();
	Thread.sleep(1000);
	Driver.switchTo().window(strSecondWindow);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.nav-link")));
	Driver.findElement(By.cssSelector("a.nav-link")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#session_key-login")));
	Driver.findElement(By.cssSelector("#session_key-login")).sendKeys("Login@linked.com");
	Driver.findElement(By.cssSelector("input#session_password-login")).sendKeys("Login@linked.com");
	Driver.findElement(By.cssSelector("#btn-primary")).click();
	Driver.close();
	Thread.sleep(1000);
	Driver.switchTo().window(strFirstWindow);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='section-tophat']/div/div/div[2]/ul/li[5]/a/img")));
	Driver.findElement(By.xpath("//div[@id='section-tophat']/div/div/div[2]/ul/li[5]/a/img")).click();
	
	
	}
	catch (Exception e) 
	{
		System.out.println(e);
	}
		
	}
	
	
}
