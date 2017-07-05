package multipleWindowHandle;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandling 
{
	WebDriver Driver;
	WebDriverWait wait;
	@BeforeMethod
	public void stratBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://qaplanet.in/";
		Driver.get(sUrl);
		wait=new WebDriverWait(Driver, 20);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		Driver.close();
		Driver.quit();
	}
	
	@Test
	public void windowHandling()
	{
		try
		{
		String strExpectedTitle="Best Training Institute for Testing Tools in Ameerpet, Hyderabad- QA Planet";
		String strActualTitle=Driver.getTitle();
		assertEquals(strActualTitle, strExpectedTitle);
		Reporter.log("Title verified");
		WebElement objLinkdin=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='section-tophat']/div/div/div[2]/ul/li[4]/a/img")));
//		if (objLinkdin.isDisplayed()) 
//		{
//			System.out.println("Element displayed");
//			
//		}
//		else
//		{
//			System.out.println("element not displayed");
//		}
		
		assertTrue(objLinkdin.isDisplayed(), "linkden Element displayed on web page");
		File srcfile=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("D:\\qaplanet.png"));
		Reporter.log("Screen shot of first window taken");
		objLinkdin.click();
		
		Set<String>strwindows=Driver.getWindowHandles();
		Iterator<String>iterator=strwindows.iterator();
		String strFirstWindow=iterator.next();
		String strSecondWindow=iterator.next();
		
		Thread.sleep(1000);
		Driver.switchTo().window(strSecondWindow);
		Reporter.log("Switched to second window");
		WebElement objSignIn=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='minimal-util-nav']/ul/li[1]/a")));
		assertTrue(objSignIn.isDisplayed(), "Sigin button displayed");
		objSignIn.click();
		WebElement objEmailAddress=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#session_key-login")));
		WebElement objPassword=Driver.findElement(By.xpath(".//*[@id='session_password-login']"));
		WebElement objSignInButton=Driver.findElement(By.cssSelector("#btn-primary"));
		assertTrue(objEmailAddress.isDisplayed() && objPassword.isDisplayed() && objSignInButton.isDisplayed(), "Email Address, Password, Signin fields are displayed");
		Reporter.log("Email address, Password and Login buttons are displayed");
		objEmailAddress.sendKeys("test@test.com");
		objPassword.sendKeys("test@password");
		objSignInButton.click();
		File srcFile2=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile2, new File("D:\\loginpage.png"));
		
		Driver.close();
		Thread.sleep(1000);
		Driver.switchTo().window(strFirstWindow);
		Reporter.log("Switch to First Window");
		WebElement objFacebook=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[3]/a/img")));
		assertTrue(objFacebook.isDisplayed(), "Facebook link with image displayed");
		objFacebook.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		
	}
	
	
	

	
	
	
}
