package dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Dropdown3 {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
//		FirefoxDriver Driver=new FirefoxDriver();
		Driver.get("http://apps.qaplanet.in/qahrm/index.php");
		
		Driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		Driver.findElement(By.name("txtPassword")).sendKeys("user1");
		Driver.findElement(By.name("Submit")).click();
		
		
//		Driver.switchTo().frame("rightMenu");
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id='standardView']/div[3]/div[1]/input[1]")).click();
		
//		List<WebElement>frame=Driver.findElements(By.tagName("iframe"));
//		System.out.println(frame.size());
//		for (int i = 0; i < frame.size(); i++)
//		{
//			
//			Driver.switchTo().frame(i);
//			
//		}
//		
//		
//		
//		Driver.switchTo().parentFrame();
		
		
		Driver.switchTo().defaultContent();
		
		
		Driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		

	}

}
