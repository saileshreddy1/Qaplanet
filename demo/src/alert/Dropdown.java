package alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.16.1-win32\\geckodriver.exe");
//		ChromeDriver Driver=new ChromeDriver();
		FirefoxDriver Driver=new FirefoxDriver();
		
		String sUrl="http://classroom:90/webapp/SelectAWebSite.html";
		Driver.get(sUrl);
		WebElement dd=Driver.findElement(By.xpath("//select[@name='OptWeb']"));
		dd.sendKeys("QAPlanet");
	}
}
