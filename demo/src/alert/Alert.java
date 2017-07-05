package alert;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert {

	public static void main(String[] args) throws InterruptedException 
	{
//								webdriver.chrome.driver						"C:\Users\admin\Downloads\chromedriver_win32\chromedriver.exe"
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.get("http://classroom:90/webapp/AgeProb.html");
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		wait.until(ExpectedConditions.titleIs("Age Problem"));
		if (Driver.getTitle().equals("Age Problem"))
		{
			System.out.println("Age Problem title displayed");
			
		}
		else {
			System.out.println("Age Problem title not displayed");
		}
		
		String sAge="50";
		Driver.findElement(By.xpath("//form[@name='frmAge']/input[1]")).sendKeys(sAge);
		Driver.findElement(By.xpath("//input[@id='idSubGo']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		org.openqa.selenium.Alert alert=Driver.switchTo().alert();
		if (alert.getText().equals("Adult")) 
		{
			System.out.println("Adult is displayed");
			Thread.sleep(2000);
			alert.accept();
			
		}
		
		
		
		
		
		
		
		

	}

}
