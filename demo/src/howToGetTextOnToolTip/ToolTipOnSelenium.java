package howToGetTextOnToolTip;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTipOnSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("http://www.seleniumhq.org/");
		List<WebElement> objlinks=Driver.findElements(By.xpath("//div[@id='header']/ul/li/a"));
		System.out.println(objlinks.size());
		for (int i = 0; i < objlinks.size(); i++) 
		{
			
			if (objlinks.get(i).isDisplayed())
			{
			String strToolTip=objlinks.get(i).getAttribute("title");
			System.out.println(strToolTip);
			
			}
		}
		
		WebElement objSearchToolTip=Driver.findElement(By.cssSelector("form[title='seleniumhq.org Selenium Search']>div>label"));
		String  strSearchToolTip=objSearchToolTip.getAttribute("title");
		System.out.println(strSearchToolTip);
	
		WebElement objSearchBoxToolTip=Driver.findElement(By.cssSelector("form[title='seleniumhq.org Selenium Search']"));
		String  strSearchBoxToolTip=objSearchBoxToolTip.getAttribute("title");
		System.out.println(strSearchBoxToolTip);
		
		Driver.quit();
		
		
		

	}

}
