package dropdown;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
//		FirefoxDriver Driver=new FirefoxDriver();
		Driver.get("http://classroom:90/webapp/SelectAWebSite.html");
		
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnGo")));
		 if (Driver.findElement(By.name("btnGo")).isDisplayed())
		 {
			 
			System.out.println("Go Button Displayed");
		 }
		 else {
			System.out.println("Go Button Not Displayed");
			return;
		}
		 
	
		 WebElement sel=Driver.findElement(By.name("OptWeb"));
		 org.openqa.selenium.support.ui.Select select= new org.openqa.selenium.support.ui.Select(sel);
		
//	
		 
		 Thread.sleep(2000);
		 select.selectByVisibleText("Google");
		 
		 Thread.sleep(2000);
		 select.selectByIndex(2);
		 
		 Thread.sleep(2000);
		 select.selectByValue("Microsoft");
		 
		 
		 List<WebElement> options=select.getOptions();
		 System.out.println(options.size());
		 for (int i = 0; i < options.size(); i++)
		 {
			 System.out.println(options.get(i).getText());
			
		 }
		 System.out.println("");
		 System.out.println("For Each Loop");
		 
		 for (WebElement e:options) 
		 {
			 System.out.println(e.getText());
			
		 }
		 
//		 select.
		 
		 System.out.println("");
		 
		 System.out.println("Iterator with while loop");
		 Iterator<WebElement> it=options.iterator();
		 while (it.hasNext()) 
		 {
			WebElement webElement = (WebElement) it.next();
			System.out.println(webElement.getText());
			
		 }
		 
		 List<WebElement>dd=sel.findElements(By.tagName("option"));
		 System.out.println("");
		 System.out.println("Basic For Loop");
		 for (int i = 0; i < dd.size(); i++) 
		 {
			 String Options= dd.get(i).getText();
			 System.out.println(Options);
			
		}
		 System.out.println("");
		 System.out.println("For Each");
		 for(WebElement we:dd)
		 {
			 System.out.println(we.getText());
			 
		 }
		 
		 
		 Driver.close();
//		 Driver.quit();
		 
		
		 
		

	}

}
