package ssl;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLChrome {

	public static void main(String[] args) {
//
		File file = new File("C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath()); 
//		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		WebDriver  driver = new ChromeDriver(capability);
		driver.get("https://axisbank.com/");
		
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		

	}

}
