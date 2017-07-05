package abstractWindowToolkitUsingCSS;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractWindowToolkitUsingCSS {

	public static void main(String[] args) throws AWTException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://apps.qaplanet.in/qahrm/login.php";
		Driver.get(sUrl);
		
		WebElement objuserName=Driver.findElement(By.cssSelector(".loginText"));
		WebElement objPassword=Driver.findElement(By.cssSelector("input[type='password']"));
		WebElement objLogin=Driver.findElement(By.cssSelector("input.button[name='Submit']"));
		WebElement objClear=Driver.findElement(By.cssSelector("input.button[name='clear']"));
		WebDriverWait wait=new WebDriverWait(Driver, 10);
		
		if (objuserName.isDisplayed() && objPassword.isDisplayed() && objLogin.isDisplayed() && objClear.isDisplayed())
		{
			System.out.println("UserName, Password, Login and Clera fields are displayed"); 
			
		}
		else
		{
			System.out.println("UserName, Password, Login and Clera fields are not displayed");
			return;
		}
		
		objuserName.sendKeys("qaplanet1");
		objPassword.sendKeys("user1");
		objLogin.click();
		if (wait.until(ExpectedConditions.titleIs("OrangeHRM")))
		{
			System.out.println("OrangeHRM Title displayed");
			
		}
		else
		{
			System.out.println("OrangeHRM Title not displayed");
		}
		
		WebElement objPim=Driver.findElement(By.cssSelector("span.drop.current"));
		
		WebElement objAddEmployee=Driver.findElement(By.cssSelector("a.l2_link.empadd>span"));
		Actions action=new Actions(Driver);
		action.moveToElement(objPim).moveToElement(objAddEmployee).click().build().perform();
	
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
		WebElement objBrowse=Driver.findElement(By.cssSelector("#photofile"));
		if (objBrowse.isDisplayed())
		{
			System.out.println("Browse button is displayed");
			
		}
		else
		{
			System.out.println("Browse button not displayed");
		}
		
		objBrowse.click();
		
		Robot rb=new Robot();
		StringSelection strss=new StringSelection("C:\\Users\\Public\\Pictures\\Sampl;e Pictures\\Lighthouse.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strss, null);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);
		
//		StringSelection ss=new StringSelection("");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		
		
		
	}

}
