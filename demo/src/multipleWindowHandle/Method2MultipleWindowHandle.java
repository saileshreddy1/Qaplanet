package multipleWindowHandle;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Method2MultipleWindowHandle {

	ChromeDriver Driver;
	WebDriverWait wait;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\drivers\\chromedriver_win32\\chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://qaplanet.in/");
	}
	
	@Test
	public void multipleWindowTest() throws InterruptedException
	{
		
		wait=new WebDriverWait(Driver, 20);
		// LinkedIn 
		WebElement objLinedIn=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[4]/a/img")));
		objLinedIn.click();
		
		//SignIn Button
		switchWindow("//*[@id='minimal-util-nav']/ul/li[1]/a");
		Driver.close();
		
		// Google Pluse
		switchWindow("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[1]/a/img");
		
		//SignIn Button
		switchWindow("//*[@id='gb_70']");
					  //*[@id='gb_70
	}
		
		public void switchWindow(String strXpath) throws InterruptedException
		{
			wait=new WebDriverWait(Driver, 20);
			Set<String> windowids=Driver.getWindowHandles();
			Iterator<String> it=windowids.iterator();
			while(it.hasNext())
			{
			   Driver.switchTo().window(it.next());
			   try
			   {
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(strXpath)));
				  Driver.findElement(By.xpath(strXpath)).click();
			      break;
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
			}
		}
}
