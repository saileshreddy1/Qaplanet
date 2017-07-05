package practiceCommanTestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://classroom:90/webapp/AgeProb.html";
		Driver.get(sUrl);
		WebDriverWait wait =new WebDriverWait(Driver, 10);
		Boolean bWebPageTitle = wait.until(ExpectedConditions.titleIs("Age Problem"));
		if (bWebPageTitle)
		{
			System.out.println("Age Problem title displayed");
			
		}
		else
		{
			System.out.println("Age Problem title not displayed");
			return;
		}
		
		WebElement objEnterYourAge=Driver.findElement(By.id("idAge"));
		WebElement objSubmitButton=Driver.findElement(By.id("idSubGo"));
		if (objEnterYourAge.isDisplayed() && objSubmitButton.isDisplayed())
		{
			System.out.println("Text box and button fields are displayed");
			
		}
		else
		{
			System.out.println("Text box and button fields are not displayed");
			return;
		}
		objEnterYourAge.sendKeys("10");
		objSubmitButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=Driver.switchTo().alert();
		if (alert.getText().equals("Kid"))
		{
			System.out.println("kid alert message displayed");
			alert.accept();
		} 
		else
		{
			System.out.println("No alert displayed");
		}
		
		
		Driver.quit();
		
				
		
		
		

	}

}
