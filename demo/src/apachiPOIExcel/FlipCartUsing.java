package apachiPOIExcel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipCartUsing {

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
	public void getTextFromFlipCartAndStroreInExcel() throws InterruptedException, IOException 
	{
		
	    HSSFWorkbook WB=new HSSFWorkbook();
		HSSFSheet sheet=WB.createSheet("Sheet1");
		HSSFRow r1=sheet.createRow(0);
		r1.createCell(0).setCellValue("MobileName");
		r1.createCell(1).setCellValue("	");
	
		WebElement objElectronics=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Electronics']")));
		Actions action=new Actions(Driver);
		action.moveToElement(objElectronics).build().perform();
		
		Thread.sleep(2000);
		WebElement objLenove=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='container']/div/header/div[2]/div/ul/li/ul/li/ul/li/ul/li[3]/a")));
		action.moveToElement(objLenove).click().build().perform();
		Thread.sleep(2000);
	  
		String	strMobileName;
		HSSFRow	r2;
		
		WebElement objBlock=Driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/a"));
		List<WebElement>objMobileName=objBlock.findElements(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/a/div[2]/div[1]/div[1]"));
		for (int i=1; i<=objMobileName.size(); i++)
		{
				
			strMobileName = Driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+i+"]/a/div[2]/div[1]/div[1]")).getText();
			List<WebElement>objMobilePrice=Driver.findElements(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/a/div[2]/div[2]/div[1]/div/div[1]"));		
			for (int j=1; j<=objMobilePrice.size(); j++) 
			{
				String strMobilePrice = Driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+j+"]/a/div[2]/div[2]/div[1]/div/div[1]")).getText();
				
				
				
//				String strMobileData=strMobileName+"-"+strMobilePrice;
//				String[] string = strMobileData.split("-");
//							
//				r2=sheet.createRow(i);
//				r2.createCell(0).setCellValue(string[0]);
//				r2.createCell(1).setCellValue(string[1]);
				
				r2=sheet.createRow(i);
				r2.createCell(0).setCellValue(strMobileName);
				r2.createCell(1).setCellValue(strMobilePrice);
				
			}
		}
		
//		HSSFRow	r3;
//		List<WebElement>objMobilePrice=Driver.findElements(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div/a/div[2]/div[2]/div[1]/div/div[1]"));
//		for (int j=1; j<=objMobilePrice.size(); j++) 
//		{
//			strMobilePrice = Driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+j+"]/a/div[2]/div[2]/div[1]/div/div[1]")).getText();
//		
//			r3=sheet.createRow(j);
//			r3.createCell(2).setCellValue(strMobilePrice);
//
//		
//		}
		
		
		
		
		
		
//		int i=1;
//		
//		Iterator<Row>rows=sheet.rowIterator();
//		rows.next();
//		while(rows.hasNext())
//		{
////			String strMobileName = Driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+i+"]/a/div[2]/div[1]/div[1]")).getText();
////			String strMobilePrice = Driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+i+"]/a/div[2]/div[2]/div[1]/div/div[1]")).getText();
//			r1=(HSSFRow)rows.next();
//			r2=sheet.createRow(i);
//			r2.createCell(0).setCellValue(strMobileName);
//			r2.createCell(1).setCellValue(strMobilePrice);
//			i++;
//			
//		}
		
		
		FileOutputStream fileOut=new FileOutputStream("C:\\Users\\admin\\Desktop\\Flipcart.xls");
		WB.write(fileOut);
		fileOut.flush();
		fileOut.close();
		Driver.close();
		Driver.quit();
	}
	
	
}
