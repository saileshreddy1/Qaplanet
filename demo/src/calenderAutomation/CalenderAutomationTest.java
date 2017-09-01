package calenderAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalenderAutomationTest {
	
	ChromeDriver Driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\drivers\\chromedriver_win32\\chromedriver.exe");
		Driver= new ChromeDriver();
		Driver.get("http://www.spicejet.com/Default.aspx");
		
	}
	@Test
	public void calenderTest() throws InterruptedException
	{
		
		
		Driver.findElement(By.id("ctl00_mainContent_txt_Fromdate")).click();
		
		String strMonth="May";
		String strYear="2018";
		
//		Year
		String strcalyear=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")).getText();
		while (!strcalyear.equals(strYear)) 
		{
		  Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
		  strcalyear=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")).getText();
		  
//		 Month  
		  String strCalMonth=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[1]")).getText();
		  while (!strCalMonth.equals(strMonth))
			{
			  Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
			  strCalMonth=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[1]")).getText();
			}
		    
		    boolean flag= false;
//			Date
		    List<WebElement>Date=Driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td/a"));
			for(int i=0;i<Date.size();i++)
			{
				Thread.sleep(2000);
				String strDate="20";
				String DatesInCalender=Date.get(i).getText();
				if (strDate.equals(DatesInCalender)) 
				{
					Date.get(i).click();
					flag=true;
					break;
					
				}
			}
			if(flag==true)
			{
				break;
			}
		}
		
	}

	public void toDateCalender() throws InterruptedException
	{
        Driver.findElement(By.id("ctl00_mainContent_txt_Todate")).click();
		
		String strMonth="August";
		String strYear="2018";

		String strcalyear=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")).getText();
		while (!strcalyear.equals(strYear)) 
		{
										
     	  Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
		  strcalyear=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")).getText();
		  String strCalMonth=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/div/span[1]")).getText();
		
		    while (!strCalMonth.equals(strMonth))
			{
			
		      Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
			  strCalMonth=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/div/span[1]")).getText();
			}
		    
		    boolean flag= false;
			List<WebElement>Date=Driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td/a"));
			for(int i=0;i<Date.size();i++)
			{
				Thread.sleep(2000);
				String strDate="25";
				String DatesInCalender=Date.get(i).getText();
				if (strDate.equals(DatesInCalender)) 
				{
					Date.get(i).click();
					flag=true;
					break;
					
				}
			}
			if(flag==true)
			{
				break;
			}
		}
		
	}
		
	
	

	
}
