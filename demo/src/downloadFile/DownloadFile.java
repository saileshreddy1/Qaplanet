package downloadFile;

import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFile {

	
	public static void main(String[] args) throws InterruptedException {
		/*
1. Create a PROFILE object of Browser.
2. Set Preference, by giving Download destination Directory.
3. Set Preference, by giving Default Folder.
     0 => Desktop, 
     1=>System Default Location,
     2 => Indicates a custom Folder Location
4. Set Preference, A comma-separated list of MIME types to save to disk without 
asking what to use to open the file. Default value is an empty string.

		 */
//		
		
		
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.download.dir", "D:\\MYDownloads");
		profile.setPreference("browser.download.folderList", 0);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver(profile);
		Driver.manage().window().maximize();
		Driver.get("http://docs.seleniumhq.org/download/");
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//*[@id='mainContent']/p[7]/a[1]")).click();
		
		
	}
	
	
}
