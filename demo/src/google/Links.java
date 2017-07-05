package google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links 
{
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		WebElement block=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table"));
		List<WebElement> links=block.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (int i = 0; i < links.size(); i++) 
		{
			Thread.sleep(1000);
			String linkname=links.get(i).getText();
			System.out.println(linkname);
			links.get(i).click();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
			block=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table"));
			links=block.findElements(By.tagName("a"));
			
		}
	}

}
