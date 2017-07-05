package apachiPOIExcel;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedBusExcel {
	ChromeDriver Driver;
	WebDriverWait wait;
	@BeforeMethod 
	public void startDriverser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="https://www.redbus.in/";
		Driver.get(sUrl);
		wait =new WebDriverWait(Driver, 20);
	}
	
	@Test
	public void excelRedBus()throws Exception
	{
		Thread.sleep(7000);
		Robot rb=new Robot();
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.delay(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement objFrom=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("src")));
		objFrom.sendKeys("Hyder");
		Actions action=new Actions(Driver);
		Thread.sleep(1000);
		action.moveToElement(objFrom).sendKeys(Keys.ENTER).build().perform();
		
		WebElement objTo=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dest")));
		objTo.sendKeys("Tirup");
		Thread.sleep(1000);
		action.moveToElement(objTo).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		WebElement objdate=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Onward Date']")));
		objdate.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr/td[@class='current day']")));
		List<WebElement>objDates=Driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr/td[@class='current day']"));
		for (int i = 0; i < objDates.size(); i++)
		{
			objDates.get(i).click();
		}
		Thread.sleep(1000);
		WebElement objSearch=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='search_btn']")));
		objSearch.click();
				
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet ws=wb.createSheet("Sheet1");
		
		HSSFRow r1=ws.createRow(0);
		r1.createCell(0).setCellValue("BusName");
		r1.createCell(1).setCellValue("BusPrice");
				
		String strBusName;
		String strBusPrice;
		
		List<WebElement>objAllBusses=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='buses_viewonward']/div/ul/li/div[1]/div/div[1]/div[3]/div[1]")));
		for (int i = 1; i < objAllBusses.size(); i++)
		{
			strBusName=Driver.findElement(By.xpath("//*[@id='buses_viewonward']/div/ul/li["+i+"]/div[1]/div/div[1]/div[3]/div[1]")).getText();
			List<WebElement>objBusPrice=Driver.findElements(By.xpath("//*[@id='buses_viewonward']/div/ul/li/div[1]/div/div[1]/div[7]/div[1]/div[1]"));
			for(int j=1; j<=objBusPrice.size();j++)
			{
			
				strBusPrice=Driver.findElement(By.xpath("//*[@id='buses_viewonward']/div/ul/li["+i+"]/div[1]/div/div[1]/div[7]/div[1]/div[1]")).getText();
				HSSFRow r2=ws.createRow(i);
				r2.createCell(0).setCellValue(strBusName);
				r2.createCell(1).setCellValue(strBusPrice);
			}
		
		}
	
		FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\Desktop\\BussesWithPrice.xls");
		wb.write(fos);
		fos.flush();
		fos.close();
	}
}
