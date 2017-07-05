package google;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinikTest3 
{

	public static void main(String[] args)
	{

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://bing.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement block=driver.findElement(By.xpath("//*[@id='sc_hdu']"));
		List<WebElement>links=block.findElements(By.tagName("a"));
		for (int i = 0; i <links.size(); i++)
		{
			if (links.get(i).isDisplayed())
			links.get(i).click();
			String Currenturl= driver.getCurrentUrl();
			System.out.println(Currenturl);
			driver.navigate().back();
//			block=driver.findElement(By.xpath(".//*[@id='sc_hdu']"));
			links=block.findElements(By.tagName("a"));
			}
		}
}
