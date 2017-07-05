package practiceCommanTestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://classroom:90/WebApp/Ex3.html";
		Driver.get(sUrl);
		WebDriverWait wait=new WebDriverWait(Driver, 10);
		WebElement objSubmitButton=Driver.findElement(By.name("Submit"));
		if (objSubmitButton.isDisplayed())
		{
			System.out.println("Home page is displayed with submit button");
			
		}
		else
		{
			System.out.println("Home page is not displayed with submit button");
			return;
		}
		WebElement objMultpleChoice=Driver.findElement(By.xpath("//input[2]"));
		objMultpleChoice.click();
		objSubmitButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=Driver.switchTo().alert();
		if (alert.getText().equals("Are you sure you want to submit this answer?")) 
		{
			System.out.println("'Are you sure you want to submit this answer?' alert message displayed");
			alert.accept();
		}
		else
		{
			System.out.println("No alert present");
		}
		wait.until(ExpectedConditions.alertIsPresent());
		if (alert.getText().equals("submitted"))
		{
			System.out.println("'submitted' alert message displayed");
			alert.accept();
		}
		else
		{
			System.out.println("No alert present");
		}
		
		Driver.quit();

	}

}
