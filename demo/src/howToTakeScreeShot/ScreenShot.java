package howToTakeScreeShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void main(String[] args) throws IOException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://google.com";
		Driver.get(sUrl);
		
		File srcFile=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("D:\\screenshot\\Google.png"));
		
		Driver.get("https://mail.google.com/mail/u/0/#inbox/15cd37ceea29f50b");
//		Driver.navigate().to("https://mail.google.com/mail/u/0/#inbox/15cd37ceea29f50b");
		File srfFile1=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srfFile1, new File("D:\\screenshot\\Gmail.png"));

		Driver.navigate().to("http://www.seleniumhq.org/");
		File scrFile2=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile2, new File("D:\\screenshot\\Seleniumhq.png"));
		
		Driver.navigate().to("http://apps.qaplanet.in/qahrm/login.php");
		File srcFile3=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile3, new File("D:\\screenshot\\OrangeHrm.png"));
		
		Driver.navigate().to("http://newtours.demoaut.com/mercuryregister.php?osCsid=7b1dde33a038c7428eb5820b3fb493dc");
		File scrFile4=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile4, new File("D:\\screenshot\\Newtours.png"));
		Driver.quit();
		
		
		
	}

}
