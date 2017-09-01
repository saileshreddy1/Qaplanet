package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable {

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\geckodriver-v0.16.1-win32\\geckodriver.exe");
//		ChromeDriver Driver=new ChromeDriver();
		FirefoxDriver Driver=new FirefoxDriver();
		
		String sUrl="http://classroom:90/webapp/AssertXPath.html";
		Driver.get(sUrl);
		
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		
		boolean title=wait.until(ExpectedConditions.titleIs("AssertXPath"));
		if (title)
		{
			System.out.println("AssertXPath title displayed");
			
		}
		else
		{
			System.out.println("AssertXPath title not displayed");
			return;
		}
		
		
		String xpath1="//table[@id='idCourse']/tbody/tr[";
		
		String xpath2="]/td[";
		
		String xpath3="]";
		
		//*[@id='idCourse']/tbody/tr["+i+"]/td["+j+"]
		
		
		List<WebElement> row=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr"));
		int rowCount=row.size();
		System.out.println("Row Size : "+rowCount);
		
		List<WebElement> clos=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr[1]/td"));
		int colsCount=clos.size();
		System.out.println("Coloumn Size : "+ colsCount);
		
		List<WebElement> cell=Driver.findElements(By.xpath("//table[@id='idCourse']/tbody/tr/td"));
		System.out.println("Celll Count : "+ cell.size());
	
		for (int i = 1; i < rowCount; i++)
		{
			for (int j = 1; j < colsCount; j++)			
			{
				
					String sTableData= Driver.findElement(By.xpath(xpath1+i+xpath2+j+xpath3)).getText();
					System.out.println(sTableData);
					
				
			}
			
		}

		System.out.println("");
		System.out.println("For Each");
		System.out.println("");
		
		for(WebElement ele : cell)
		{
			System.out.println(ele.getText());
			
		}
		
		System.out.println("");
		System.out.println("new logic");
		System.out.println("");
	
		
														
		
		WebElement objBlock=Driver.findElement(By.xpath("//table[@id='idCourse']"));
		List<WebElement> rows=objBlock.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++)
		{
			List<WebElement>cols=rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++)
			{
				String sTableData=cols.get(j).getText();
				System.out.println(sTableData);
			}
			
		}
		
		
		
				
		
		
		
		Driver.quit();
		
		

	}

}
