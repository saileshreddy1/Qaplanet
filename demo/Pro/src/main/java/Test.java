import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Test {

	static WebDriver Driver;
	
//	public static void main(String[] args) {
//		
//		System.setProperty("webdriver.chrome.driver", "D:\\tet\\chromedriver.exe");
//		Driver=new ChromeDriver();
//		Driver.manage().window().maximize();
//		Driver.navigate().to("http://apps.qaplanet.in/qahrm/login.php");
//		
//		Driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
//		Driver.findElement(By.name("txtPassword")).sendKeys("user1");
//		Driver.findElement(By.name("Submit")).click();
//	}
	
//	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.navigate().to("http://apps.qaplanet.in/qahrm/login.php");
	}
	
	
	@org.testng.annotations.Test
	public void testcase()
	{
		
		
		Driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		Driver.findElement(By.name("txtPassword")).sendKeys("user1");
		Driver.findElement(By.name("Submit")).click();
	}
	
}
