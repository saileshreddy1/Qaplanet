package excelFlipcartaAndRedBus;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelFlipCart {

	
	ChromeDriver Driver;
	WebDriverWait wait;
	@BeforeMethod 
	public void startDriverser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="https://www.flipkart.com/";
		Driver.get(sUrl);
		wait =new WebDriverWait(Driver, 20);
	}
	
	@Test
	public void getTextFromFlipCart() throws InterruptedException, Exception
	{
		
		WritableWorkbook objWWB=Workbook.createWorkbook(new File("C:\\Users\\admin\\Desktop\\FlipkartMobileDataWithPrice.xls"));
		WritableSheet objWS=objWWB.createSheet("MobileData", 0);
		
		Label l1=new Label(0, 0, "Mobile Name");
		
		Label l2=new Label(1, 0, "Mobile Price");
		
		Label l3;
		
//		Label l4;
//		
//		Label l5;
//		
//		Label l6;
//		
//		Label l7;
//		
//		Label l8;
//		
//		Label l9;
//		
//		Label l10;
//		
//		Label l11;
//		
//		Label l12;
//		
//		Label l13;
//		
//		Label l14;
//		
//		Label l15;
//		
//		Label l16;
//		
//		Label l17;
//		
//		Label l18;
//		
//		Label l19;
//		
//		Label l20;
		objWS.addCell(l1);
		objWS.addCell(l2);
		
		
		Thread.sleep(2000);
		WebElement objElectronics=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Electronics']")));
		Actions action=new Actions(Driver);
		action.moveToElement(objElectronics).build().perform();
		Thread.sleep(2000);
		WebElement objLenove=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='container']/div/header/div[2]/div/ul/li/ul/li/ul/li/ul/li[3]/a")));
		action.moveToElement(objLenove).click().build().perform();
		Thread.sleep(2000);
		List<WebElement>objMobileNames=Driver.findElements(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/a/div[2]/div[1]/div[1]"));
		for (int i = 1; i <objMobileNames.size(); i++)
		{
			String strMobileData = Driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+i+"]/a/div[2]/div[1]/div[1]")).getText();
			
			l3=new Label(0, i, strMobileData);
				
//			l4 = new Label(0, i, strMobileData);
//			
//			l5 = new Label(0, i, strMobileData);
//			
//			l6 = new Label(0, i, strMobileData);
//			
//			l7 = new Label(0, i, strMobileData);
//			
//			l8 = new Label(0, i, strMobileData);
//			
//			l9 = new Label(0, i, strMobileData);
//			
//			l10 = new Label(0, i, strMobileData);
//			
//			l11 = new Label(0, i, strMobileData);
//			
//			l12 = new Label(0, i, strMobileData);
//			
//			l13 = new Label(0, i, strMobileData);
//			
//			l14 = new Label(0, i, strMobileData);
//			
//			l15 = new Label(0, i, strMobileData);
//			
//			l16 = new Label(0, i, strMobileData);
//			
//			l17 = new Label(0, i, strMobileData);
//			
//			l18 = new Label(0, i, strMobileData);
//			
//			l19 = new Label(0, i, strMobileData);
//			
//			l20 = new Label(0, i, strMobileData);
//			
			objWS.addCell(l3);
//			
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
//			
//			objWS.addCell(l13);
//			
//			objWS.addCell(l14);
//			
//			objWS.addCell(l15);
//			
//			objWS.addCell(l16);
//			
//			objWS.addCell(l17);
//		
//			objWS.addCell(l18);
//			
//			objWS.addCell(l19);
//			
//			objWS.addCell(l20);
			
		}
		
		List<WebElement>objMobilePrice=Driver.findElements(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/a/div[2]/div[2]/div[1]/div/div[1]"));
		for (int j = 1; j < objMobilePrice.size(); j++)
		{
			String strMobilePrice = Driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+j+"]/a/div[2]/div[2]/div[1]/div/div[1]")).getText();
			
			l3=new Label(1, j, strMobilePrice);
			
//			l4 = new Label(1, j, strMobilePrice);
//			
//			l5 = new Label(1, j, strMobilePrice);
//			
//			l6 = new Label(1, j, strMobilePrice);
//			
//			l7 = new Label(1, j, strMobilePrice);
//			
//			l8 = new Label(1, j, strMobilePrice);
//			
//			l9 = new Label(1, j, strMobilePrice);
//			
//			l10 = new Label(1, j, strMobilePrice);
//			
//			l11 = new Label(1, j, strMobilePrice);
//			
//			l12 = new Label(1, j, strMobilePrice);
//			
//			l13 = new Label(1, j, strMobilePrice);
//			
//			l14 = new Label(1, j, strMobilePrice);
//			
//			l15 = new Label(1, j, strMobilePrice);
//			
//			l16 = new Label(1, j, strMobilePrice);
//			
//			l17 = new Label(1, j, strMobilePrice);
//			
//			l18 = new Label(1, j, strMobilePrice);
//			
//			l19 = new Label(1, j, strMobilePrice);
//			
//			l20 = new Label(1, j, strMobilePrice);
//			
			objWS.addCell(l3);
//			
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
//			
//			objWS.addCell(l13);
//			
//			objWS.addCell(l14);
//			
//			objWS.addCell(l15);
//			
//			objWS.addCell(l16);
//			
//			objWS.addCell(l17);
//		
//			objWS.addCell(l18);
//			
//			objWS.addCell(l19);
//			
//			objWS.addCell(l20);
		
			
			
		}
		
		
		
		objWWB.write();
		objWWB.close();
		
		
		
	}
	
	
		
	
	
	
	
}
