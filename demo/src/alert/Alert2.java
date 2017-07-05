package alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert2 {

	public static void main(String[] args) throws InterruptedException 
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		String sUrl="http://classroom:90/WebApp/Ex3.html";
		Driver.get(sUrl);
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		WebElement objSubmit=Driver.findElement(By.xpath("//input[@name='Submit']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='Submit']")));
		if (objSubmit.isDisplayed()) 
		{
			System.out.println("Submit button displayed");
		}
		else {
			System.out.println("Submit button not displayed");
			return;
		}
		Driver.findElement(By.xpath("//input[4]")).click();
		objSubmit.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=Driver.switchTo().alert();
		if (alert.getText().equals("Are you sure you want to submit this answer?"))
		{
			System.out.println("Confirm displayed");
			alert.accept();
			if (alert.getText().equals("submitted"))
			{
				System.out.println("Submitted displayed");
				Thread.sleep(1000);
				alert.accept();
			}
		}
		

		
		

	}

}
