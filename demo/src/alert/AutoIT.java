package alert;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoIT {

	public static void main(String[] args) throws IOException {
		
		
		Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\New AutoIt v3 Script.exe");
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		Driver.get("http://classroom:90/webapp/SelectAWebSite.html");
		WebElement objText =Driver.findElement(By.xpath(""));
		objText.sendKeys(Keys.ALT);
		objText.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		
		
		
		

	}

}
