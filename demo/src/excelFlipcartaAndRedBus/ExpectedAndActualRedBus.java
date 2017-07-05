package excelFlipcartaAndRedBus;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExpectedAndActualRedBus {
	
	
	
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
		
		
		File f=new File("C:\\Users\\admin\\Desktop\\BussesWithPrice.xls");
		Workbook objWB=Workbook.getWorkbook(f);
		Sheet sheet=objWB.getSheet(0);
		
		WritableWorkbook objWWB=Workbook.createWorkbook(new File("C:\\Users\\admin\\Desktop\\BussesWithPrice2.xls"));
		WritableSheet	objWS=objWWB.createSheet("RedBusData", 0);
		
		Label l1=new Label(0, 0, "BusName");
		Label l2=new Label(1, 0, "BusPrice");
		Label l=new Label(2, 0, "Result");
		
		objWS.addCell(l);
		objWS.addCell(l1);
		objWS.addCell(l2);
	
		
		Label l3;
		
		
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
		
		
		String strBusNameActual = null;
			
		String strBusNameExpected = null;
		
			
		String strPassed="Passed";
		
		String strFailed="Failed";
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='buses_viewonward']/div/ul/li/div[1]/div/div[1]/div[3]/div[1]")));
		List<WebElement>objBusNames=Driver.findElements(By.xpath("//*[@id='buses_viewonward']/div/ul/li/div[1]/div/div[1]/div[3]/div[1]"));
		for (int i = 1; i < objBusNames.size(); i++)
		{
			strBusNameExpected=sheet.getCell(0, i).getContents();
			strBusNameActual = Driver.findElement(By.xpath("//*[@id='buses_viewonward']/div/ul/li["+i+"]/div[1]/div/div[1]/div[3]/div[1]")).getText();
			
			l3=new Label(0, i, strBusNameActual);
			objWS.addCell(l3);
		}
		
		List<WebElement>objBusPrice=Driver.findElements(By.xpath("//*[@id='buses_viewonward']/div/ul/li/div[1]/div/div[1]/div[7]/div[1]/div[@class='fare']"));
		for (int j = 1; j< objBusPrice.size(); j++)
		{
						
			String strBusPriceExpected=sheet.getCell(1, j).getContents();
			
			String strBusPriceActual = Driver.findElement(By.xpath("//*[@id='buses_viewonward']/div/ul/li["+j+"]/div[1]/div/div[1]/div[7]/div[1]/div[@class='fare']")).getText();
			
			l3=new Label(1, j, strBusPriceActual);
			objWS.addCell(l3);
		
			if (strBusNameActual.equals(strBusNameExpected) && strBusPriceActual.equals(strBusPriceExpected))
			{
				l3=new Label(2, j, strPassed);
				objWS.addCell(l3);
			}
			else
			{
				l3=new Label(2, j, strFailed);
				objWS.addCell(l3);
			}
		}
		
		objWWB.write();
		objWWB.close();
		
		Driver.quit();
	}
}
