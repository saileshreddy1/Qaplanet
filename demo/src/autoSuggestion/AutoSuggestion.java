package autoSuggestion;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException 
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
			
		driver.get("http://google.com");  
		WebElement E=driver.findElement(By.name("q"));
		E.sendKeys("selenium");
		
		Thread.sleep(2000);
	
		WebElement block=driver.findElement(By.xpath("//*[@id='sbtc']/div[2]/div[2]/div[1]"));
		List<WebElement> ajax=block.findElements(By.xpath("//*[starts-with(@id,'sbse')]"));
		System.out.println(ajax.size());
		for(int i=0;i<ajax.size();i++)
		{
			System.out.println(ajax.get(i).getText());
		}
		
		
//		String text=driver.findElement(By.cssSelector(".sbdd_b")).getText();
//		System.out.println(text);
	
		//*[starts-with(@locatorname,'content')]
		
		//*[starts-with(@id,'sbse')]/div[2]
		
		
		
		driver.quit();
		

	}

}
