package autoSuggestion;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException 
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
			
		driver.get("http://google.com");  
		WebElement E=driver.findElement(By.id("lst-ib"));
		E.sendKeys("selenium");
		
//		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sbdd_b")));
		
		
		WebElement block =driver.findElement(By.xpath("//div[@class='sbsb_a']/ul[@role='listbox']"));
		List<WebElement>list=block.findElements(By.xpath(".//*[contains(@id,'sbse')]/div[2]"));
		
		for (int i = 0; i < list.size(); i++) 
		{
			
			System.out.println(list.get(i).getText());
			
		}
		
		
		
		
		String text=driver.findElement(By.cssSelector(".sbdd_b")).getText();
		System.out.println(text);
	
		   //find UL with class property
//		  WebElement ul = driver.findElement(By.className("sbsb_b"));   
//		  
//		  List<WebElement> Lic = ul.findElements(By.tagName("li")); 
//		  //----------------------------------------------------------------
//		  //Way 1
//		  //--------------------------------------------------------------------
//		  for (WebElement LI : Lic)
//		  {
//			 String itemname=LI.findElement(By.cssSelector("div.sbqs_c")).getText();
//			 System.out.println(itemname);
//			 if(itemname.equals("selenium webdriver"))
//	            {
//				 LI.click();
//	            	break;
//	            }
//		  }
//		  Thread.sleep(1000);
//		  //------------------------------------------------------------------------
//		  //Way 2
//		  //---------------------------------
//		  Iterator<WebElement> i = Lic.iterator(); 
//		  System.out.println("-----------------------------------------");   
//		  while(i.hasNext()) 
//		  {   
//			  Thread.sleep(1000);
//		     WebElement LiI = i.next();   
//		    //WebElement E=LiI.findElement(By.xpath("//div[@id='sbse0']/div[2]"));
//		     String data=LiI.findElement(By.cssSelector("div.sbqs_c")).getText();
//          System.out.println(data);   
//          System.out.println("-----------------------------------------");   
//          if(data.equals("selenium webdriver"))
//          {
//          	LiI.click();
//          	break;
//          }
//		  } 

		
		
		
		
		
		
		
//		WebElement objGoogleSeachbox=Driver.findElement(By.name("q"));
//		objGoogleSeachbox.sendKeys("Selenium");
//		
//		
////		String []str={"sbse0","sbse1","sbse2","sbse3"};
////		System.out.println("hai");
////		for (int i = 0; i < str.length; i++) 
////		{
////			System.out.println("hello");
////			List<WebElement>testdata=Driver.findElements(By.xpath("//div[@id='"+str[i]+"']/div[2][@class='sbqs_c']/b"));
////			for (int j = 0; j < testdata.size(); j++)
////			{
////				System.out.println("1");
////				String strlist=testdata.get(j).getText();
////				System.out.println(strlist);
////				
////			}
////			
////			
////			
////			
////		}
//		
//		
////		"//div[@id='sbse0']/div[2][@class='sbqs_c']/b"
//		
//		
//		
//		
//		//div[@class='sbsb_a']/ul/li[2]/div/div[2]/b
//		
//		List<WebElement> objText2=driver.findElements(By.xpath("//div[@class='sbsb_a']/ul/li"));
//		for (int i = 1; i < objText2.size(); i++) 
//		{
//			String strtext=driver.findElement(By.xpath("//div[@class='sbsb_a']/ul/li["+i+"]/div/div[2]/b")).getText();
//			System.out.println(strtext);
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
////		WebElement objUL=Driver.findElement(By.xpath("//ul[@class='sbsb_b']/li"));
//		
////		String xpathpart1="//div[@id='sbse";
////		String xpathPart2="']/div[2][@class='sbqs_c']/b";
////		List<WebElement>objList=Driver.findElements(By.xpath("//ul[@class='sbsb_b']/li/div/div[2]"));
////		for (int i = 0; i < objList.size(); i++)
////		{
////			String strdata=objList.get(i).getText();
////			System.out.println(strdata);
////			System.out.println("Hai");
////			String str=Driver.findElement(By.xpath(xpathpart1+i+xpathPart2)).getText();
////			System.out.println("What");
//////			System.out.println(str);
////			
////		}
//							
//		
////		 WebElement ul = Driver.findElement(By.className("sbsb_b"));   
////		  
////		  List<WebElement> Lic = ul.findElements(By.tagName("li")); 
////		  //----------------------------------------------------------------
////		  //Way 1
////		  //--------------------------------------------------------------------
////		  for (WebElement LI : Lic)
////		  {
////			 String itemname=LI.findElement(By.cssSelector("div.sbqs_c")).getText();
////			 System.out.println(itemname);
////			 if(itemname.equals("selenium webdriver"))
////	            {
////				 LI.click();
////	            	break;
////	            }
////		  }
//		
//		
//		
//		
//	
//		
//		
////		for(int i=0;i<objAutoSuggestion.size();i++)
////		{
////			String strAutoSuggestion=objAutoSuggestion.get(i).getText();	
////			System.out.println(strAutoSuggestion);
////			if (strAutoSuggestion.equals("selenium webdriver"))
////			{
////				objAutoSuggestion.get(i).click();
////				break;
////			}
////		}
//		
//		
//		
//		
////		Driver.quit();
		
		
		
		

	}

}
