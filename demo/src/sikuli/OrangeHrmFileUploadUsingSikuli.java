package sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class OrangeHrmFileUploadUsingSikuli {

	public static void main(String[] args) throws FindFailed {

		
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
		
		
		Screen screen=new Screen();
		
		screen.type("C:\\Users\\admin\\Documents\\OrangeHrm\\orangehrm.sikulitest.sikuli\\TextBox.png", "C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg");
		screen.click("C:\\Users\\admin\\Documents\\OrangeHrm\\orangehrm.sikulitest.sikuli\\open button.png");
		
		


		
		
		
		
//		System.out.println("hello");
//		App.open("calc.exe");
//		System.out.println("hai");
//		Screen x=new Screen();
//		System.out.println("safdsa");
//		if (x.exists("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli")!=null)
//		{
//			System.out.println("Calci window displayed");
//			
//		}
//		
//		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\1.png");
//		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\0.png");
//		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\2.png");
//		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\0 (2).png");
//		x.click("C:\\Users\\admin\\Documents\\ss.sikuiltest.sikuli\\=.png");
//		x.click("sdsds\\sadsadas\\dsdsa");
		
		
		
		

	}

}
