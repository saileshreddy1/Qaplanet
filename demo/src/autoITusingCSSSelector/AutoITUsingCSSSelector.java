package autoITusingCSSSelector;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.jacob.com.LibraryLoader;
public class AutoITUsingCSSSelector {

	public static void main(String[] args) throws InterruptedException, IOException 
	
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
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\upload file.exe");
		
		
//		
//		
//		https://sourceforge.net/projects/jacob-project/files/latest/download
//		
//		
//		https://code.google.com/archive/p/autoitx4java/downloads
		
		
		
		
		
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, "E:\\JACOB\\jacob-1.18\\jacob-1.18\\jacob-1.18-x86.dll");
		
													//	  "E:\JACOB\jacob-1.18\jacob-1.18\"
		
		
//		AutoItX x=new AutoItX();
//		
//		x.winWaitActive("Open");
//		System.out.println("what");
//		if (x.winExists("Open"))
//		{
//			System.out.println("File upload displayed");
//			
//		}
//	
//		x.send("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
////		x.controlSend("File Upload", "C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg", "Edit1", "");
//		x.sleep(1000);
//		x.controlClick("Open", "", "Button1");
		
		
		
		
	}

}
