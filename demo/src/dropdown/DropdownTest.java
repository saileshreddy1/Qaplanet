package dropdown;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownTest {
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		Driver.get("http://newtours.demoaut.com/mercuryregister.php?osCsid=8b70e146b30cabbc6530de62c2fe0727");
		
		try
		{
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		
		Boolean bTitle = wait.until(ExpectedConditions.titleIs("Register: Mercury Tours"));
		if (bTitle)
		{
			System.out.println("Register: Mercury Tours title displayed");
			
		}
		else 
		{
			System.out.println("Register: Mercury Tours title not displayed");
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("country")));
		WebElement objDropdown=Driver.findElement(By.name("country"));
		if (objDropdown.isDisplayed())
		{
			System.out.println("Country drop down displayed");
			
		}
		else
		{
			System.out.println("Country drop down not displayed");
			return;
		}
		
		Select select=new Select(objDropdown);
		
		Thread.sleep(2000);
		select.selectByVisibleText("INDIA");
		
		Thread.sleep(2000);
		select.selectByIndex(5);
		
		Thread.sleep(2000);
		select.selectByValue("6");
		
		List<WebElement> lAllSelectedOptions =select.getAllSelectedOptions();
		System.out.println("");
		System.out.println("Basic For Loop");
		for (int i = 0; i < lAllSelectedOptions.size(); i++) 
		{
			String Options=lAllSelectedOptions.get(i).getText();
			System.out.println(Options); 
			
		}
		System.out.println("");
		System.out.println("For Each loop");
		
		for(WebElement e:lAllSelectedOptions)
		{
			System.out.println(e.getText());
		}
		
		
		System.out.println("");
		System.out.println("Iterator with while loop");
		Iterator<WebElement> it=lAllSelectedOptions.iterator();
		while (it.hasNext()) {
			WebElement webElement = it.next();
			
			System.out.println(webElement.getText());
			
		}
		
		System.out.println("");
		System.out.println("Basic For Loop for all optiions");
		List<WebElement> lAllOptions=select.getOptions();
		for (int i = 0; i < lAllOptions.size(); i++) 
		{
			System.out.println(lAllOptions.get(i).getText());
			
		} 
		

		System.out.println("");
		System.out.println("For Each loop for all options");
		for(WebElement ele:lAllOptions)
		{
			System.out.println(ele.getText());
			
		}
		
		System.out.println("");
		System.out.println("Iterator with while loop for all options");
		Iterator<WebElement> itr=lAllOptions.iterator();
		while(itr.hasNext())
		{
			WebElement objOptions=itr.next();
			System.out.println(objOptions.getText());
		}
		
		
		
		Driver.quit(); 
		}
		catch (Exception e) 
		{
		
		}
		
		
		
		
		
		
	}

}
