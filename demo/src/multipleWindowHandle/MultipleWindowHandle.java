package multipleWindowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://qaplanet.in/";
		Driver.get(sUrl);
		
		Thread.sleep(2000);
		//Click on Linked icon
		Driver.findElement(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[4]/a/img")).click();
		
		Thread.sleep(4000);
		Set<String> IDS=Driver.getWindowHandles();
		//Way 1
		for(String ID : IDS)
		{
			System.out.println(ID);
		}
		System.out.println("----------------------------------------");
		
		//Way 2
		Iterator<String> ITR=IDS.iterator();
		
		String First_ID=ITR.next();
		
		String Second_ID=ITR.next();
		//Switch to second browser
		
		Driver.switchTo().window(Second_ID);
		Thread.sleep(4000);
		
		//click on Sign in
		Driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		
		//Enter email
		Driver.findElement(By.name("session_key")).sendKeys("qaplanet@gmail.com");
		Thread.sleep(2000);
		
		//close browser
		Driver.close();
		Thread.sleep(2000);
		//--------------------------------------------------------------
		
		//Switch to second browser
		Driver.switchTo().window(First_ID);
		
		//Execute code
		Thread.sleep(2000);
		
		//Click on justdial icon
		Driver.findElement(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[5]/a/img")).click();
		
		//Execute code
		Thread.sleep(2000);		
		
		//---------------------------------------------
		Driver.close();
		Driver.quit();
		

	}

}
