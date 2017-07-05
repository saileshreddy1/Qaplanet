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

public class CompareRedBusDataWithExcel {
	
	
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
		
		
		File f=new File("D:\\workspace\\demo\\src\\RedBUSExcel\\BussesWithPrice.xls");
		Workbook objWB=Workbook.getWorkbook(f);
		Sheet sheet=objWB.getSheet(0);
		
//		int iRC=sheet.getRows();
		
		
		
		
		WritableWorkbook objWWB=Workbook.createWorkbook(new File("C:\\Users\\admin\\Desktop\\BussesWithPrice.xls"));
		WritableSheet	objWS=objWWB.createSheet("RedBusData", 0);
		
		Label l1=new Label(0, 0, "BusName");
		
		Label l2=new Label(1, 0, "BusPrice");
			
		Label l=new Label(2, 0, "ResultBusses");
		
		Label r=new Label(3, 0, "ResultPrice"); 
		
		objWS.addCell(l);
		objWS.addCell(l1);
		objWS.addCell(l2);
		objWS.addCell(r);
		
		Label l3;
//		Label l4;
//		Label l5;
//		Label l6;
//		Label l7;
//		Label l8;
//		Label l9;
//		Label l10;
//		Label l11;
//		Label l12;
		
		
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
//		action.moveToElement(objSearch).click().build().perform();
		objSearch.click();
		
		
		
																				
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='buses_viewonward']/div/ul/li/div[1]/div/div[1]/div[3]/div[1]")));
		List<WebElement>objBusNames=Driver.findElements(By.xpath("//*[@id='buses_viewonward']/div/ul/li/div[1]/div/div[1]/div[3]/div[1]"));
		for (int i = 1; i < objBusNames.size(); i++)
		{
			String strBusNameExpected=sheet.getCell(0, i).getContents();
			
			String strPassed="Passed";
			
			String strFailed="Failed";
			
			String strBusNameActual = Driver.findElement(By.xpath("//*[@id='buses_viewonward']/div/ul/li["+i+"]/div[1]/div/div[1]/div[3]/div[1]")).getText();
			
			l3=new Label(0, i, strBusNameActual);
//			l4=new Label(0, i, strBusNameActual);
//			l5=new Label(0, i, strBusNameActual);
//			l6=new Label(0, i, strBusNameActual);
//			l7=new Label(0, i, strBusNameActual);
//			l8=new Label(0, i, strBusNameActual);
//			l9=new Label(0, i, strBusNameActual);
//			l10=new Label(0, i, strBusNameActual);
//			l11=new Label(0, i, strBusNameActual);
//			l12=new Label(0, i, strBusNameActual);
			
			objWS.addCell(l3);
//			objWS.addCell(l4);
//			objWS.addCell(l5);
//			objWS.addCell(l6);
//			objWS.addCell(l7);
//			objWS.addCell(l8);
//			objWS.addCell(l9);
//			objWS.addCell(l10);
//			objWS.addCell(l11);
//			objWS.addCell(l12);
			
			if (strBusNameActual.equals(strBusNameExpected))
			{
				l3=new Label(2, i, strPassed);
//				l4=new Label(2, i, strPassed);
//				l5=new Label(2, i, strPassed);
//				l6=new Label(2, i, strPassed);
//				l7=new Label(2, i, strPassed);
//				l8=new Label(2, i, strPassed);
//				l9=new Label(2, i, strPassed);
//				l10=new Label(2, i, strPassed);
//				l11=new Label(2, i, strPassed);
//				l12=new Label(2, i, strPassed);
				
				objWS.addCell(l3);
				
//				objWS.addCell(l4);
//				
//				objWS.addCell(l5);
//				
//				objWS.addCell(l6);
//				
//				objWS.addCell(l7);
//				
//				objWS.addCell(l8);
//				
//				objWS.addCell(l9);
//				
//				objWS.addCell(l10);
//				
//				objWS.addCell(l11);
//				
//				objWS.addCell(l12);
				
			}
			else
			{
				l3=new Label(2, i, strFailed);
//				l4=new Label(2, i, strFailed);
//				l5=new Label(2, i, strFailed);
//				l6=new Label(2, i, strFailed);
//				l7=new Label(2, i, strFailed);
//				l8=new Label(2, i, strFailed);
//				l9=new Label(2, i, strFailed);
//				l10=new Label(2, i, strFailed);
//				l11=new Label(2, i, strFailed);
//				l12=new Label(2, i, strFailed);
				
				objWS.addCell(l3);
				
//				objWS.addCell(l4);
//				
//				objWS.addCell(l5);
//				
//				objWS.addCell(l6);
//				
//				objWS.addCell(l7);
//				
//				objWS.addCell(l8);
//				
//				objWS.addCell(l9);
//				
//				objWS.addCell(l10);
//				
//				objWS.addCell(l11);
//				
//				objWS.addCell(l12);
				
			}
			
		}
		List<WebElement>objBusPrice=Driver.findElements(By.xpath("//*[@id='buses_viewonward']/div/ul/li/div[1]/div/div[1]/div[7]/div[1]/div[@class='fare']"));
		for (int j = 1; j< objBusPrice.size(); j++)
		{
			String strPassed="Passed";
			
			String strFailed="Failed";
			
			String strBusPriceExpected=sheet.getCell(1, j).getContents();
			
			String strBusPriceActual = Driver.findElement(By.xpath("//*[@id='buses_viewonward']/div/ul/li["+j+"]/div[1]/div/div[1]/div[7]/div[1]/div[@class='fare']")).getText();
			
			l3=new Label(1, j, strBusPriceActual);
//			l4=new Label(1, j, strBusPriceActual);
//			l5=new Label(1, j, strBusPriceActual);
//			l6=new Label(1, j, strBusPriceActual);
//			l7=new Label(1, j, strBusPriceActual);
//			l8=new Label(1, j, strBusPriceActual);
//			l9=new Label(1, j, strBusPriceActual);
//			l10=new Label(1, j, strBusPriceActual);
//			l11=new Label(1, j, strBusPriceActual);
//			l12=new Label(1, j, strBusPriceActual);
			
			objWS.addCell(l3);
			
//			objWS.addCell(l4);
//			
//			objWS.addCell(l5);
//			
//			objWS.addCell(l6);
//			
//			objWS.addCell(l7);
//			
//			objWS.addCell(l8);
//			
//			objWS.addCell(l9);
//			
//			objWS.addCell(l10);
//			
//			objWS.addCell(l11);
//			
//			objWS.addCell(l12);
			
			
			if (strBusPriceActual.equals(strBusPriceExpected))
			{
				l3=new Label(3, j, strPassed);
//				l4=new Label(3, j, strPassed);
//				l5=new Label(3, j, strPassed);
//				l6=new Label(3, j, strPassed);
//				l7=new Label(3, j, strPassed);
//				l8=new Label(3, j, strPassed);
//				l9=new Label(3, j, strPassed);
//				l10=new Label(3, j, strPassed);
//				l11=new Label(3, j, strPassed);
//				l12=new Label(3, j, strPassed);
			
				objWS.addCell(l3);
				
//				objWS.addCell(l4);
//				
//				objWS.addCell(l5);
//				
//				objWS.addCell(l6);
//				
//				objWS.addCell(l7);
//				
//				objWS.addCell(l8);
//				
//				objWS.addCell(l9);
//				
//				objWS.addCell(l10);
//				
//				objWS.addCell(l11);
//				
//				objWS.addCell(l12);
				
			}
			else
			{
				l3=new Label(3, j, strFailed);
//				l4=new Label(3, j, strFailed);
//				l5=new Label(3, j, strFailed);
//				l6=new Label(3, j, strFailed);
//				l7=new Label(3, j, strFailed);
//				l8=new Label(3, j, strFailed);
//				l9=new Label(3, j, strFailed);
//				l10=new Label(3, j, strFailed);
//				l11=new Label(3, j, strFailed);
//				l12=new Label(3, j, strFailed);
		
				objWS.addCell(l3);
				
//				objWS.addCell(l4);
//				
//				objWS.addCell(l5);
//				
//				objWS.addCell(l6);
//				
//				objWS.addCell(l7);
//				
//				objWS.addCell(l8);
//				
//				objWS.addCell(l9);
//				
//				objWS.addCell(l10);
//				
//				objWS.addCell(l11);
//					
//				objWS.addCell(l12);
				
			}
		}
		
		objWWB.write();
		objWWB.close();
		
		Driver.quit();
		
	}
	

}
