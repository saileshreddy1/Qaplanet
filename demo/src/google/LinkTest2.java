package google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinkTest2 {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		
		int lengthOfSting =links.size();
		System.out.println(lengthOfSting);
		for (int i = 0; i < links.size(); i++) 
		{
			
			
			String linkname= links.get(i).getText();
			System.out.println("LinkName"+i+linkname);
			if(links.get(i).isDisplayed())
			{
			Thread.sleep(500);
			links.get(i).click();
			Thread.sleep(500);
			driver.navigate().back();
			links=driver.findElements(By.tagName("a"));
			}
			
		}
		
		
		
		

	}

}
