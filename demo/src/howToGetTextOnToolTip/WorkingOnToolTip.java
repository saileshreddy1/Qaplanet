package howToGetTextOnToolTip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingOnToolTip {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.get("https://www.google.co.in/?gfe_rd=cr&ei=GPNNWcDmEsOL8Qea7o_IDA");
		Driver.manage().window().maximize();		
		WebElement objGoogleApps=Driver.findElement(By.xpath("//*[@id='gbwa']/div[1]/a"));
		String strGoogleApp=objGoogleApps.getAttribute("title");
		System.out.println(strGoogleApp);		
		
		WebElement objToolTipOnGoogleImage=Driver.findElement(By.id("hplogo"));
		String strToolTipOnGoogleImage=objToolTipOnGoogleImage.getAttribute("title");
		System.out.println(strToolTipOnGoogleImage);
		
		WebElement objGoogleSeacrh=Driver.findElement(By.id("lst-ib"));
		String strToolTip=objGoogleSeacrh.getAttribute("title");
		System.out.println(strToolTip);
		
		Driver.quit();
	}

}
