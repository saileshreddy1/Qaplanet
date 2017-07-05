package google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinkTest4 
{
	
	public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.16.1-win32\\geckodriver.exe");
//		FirefoxDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://bing.com/");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (int i = 0; i < links.size(); i++) 
		{
			Thread.sleep(2000);
			String linkname=links.get(i).getText();
			System.out.println(linkname);
			if(!links.get(i).getText().isEmpty())
			{
			links.get(i).click();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
			links=driver.findElements(By.tagName("a"));
			}
		}
	}

}
