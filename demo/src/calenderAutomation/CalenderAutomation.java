package calenderAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalenderAutomation {
	
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
		
		
		
		
		String doj="14/08/2018";
		
		String[]a=doj.split("/");
		String[]months={"January","February","March","April","May","June","July","August","September ","October","November ","December"};
		int x=Integer.parseInt(a[1]);
		String day=a[0];
		String month=months[x-1];
		String year=a[2];
		String calyear=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")).getText();
		while (!calyear.equals(year)) 
		{
		  Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
		  calyear=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/div/span[2]")).getText();
		  String calmonth=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/div/span[1]")).getText();
											
		
					while (!calmonth.equals(month))
					{
							Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
							calmonth=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/div/span[1]")).getText();
					}
						
																
					WebElement table=Driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]"));
						   boolean flag= false;
						List<WebElement>rows=table.findElements(By.tagName("tr"));
						for(int i=0;i<rows.size();i++)
						{
							Thread.sleep(2000);
							List<WebElement>cols=rows.get(i).findElements(By.tagName("td"));
							for( int j=0;j<cols.size();j++)
							{
								if(cols.get(j).getText().equals(day))
								{
								 Thread.sleep(2000);
								 cols.get(j).click();
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

	

}
