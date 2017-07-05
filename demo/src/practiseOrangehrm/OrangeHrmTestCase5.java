package practiseOrangehrm;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrmTestCase5 {

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://apps.qaplanet.in/qahrm/login.php";
		Driver.get(sUrl);
		WebDriverWait wait =new WebDriverWait(Driver, 10);
		
		Boolean title=wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		if (title)
		{
			System.out.println("OrangeHRM - New Level of HR Management title displayed");
			
		}
		else 
		{
			System.out.println("OrangeHRM - New Level of HR Management title not displayed");
			return;
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));	
		WebElement objUN=Driver.findElement(By.name("txtUserName"));
		WebElement objPWD=Driver.findElement(By.name("txtPassword"));
		WebElement objLOGIN=Driver.findElement(By.name("Submit"));
		WebElement objCLEAR=Driver.findElement(By.name("clear"));
		
		if (objUN.isDisplayed() && objPWD.isDisplayed() && objLOGIN.isDisplayed() && objCLEAR.isDisplayed()) 
		{
			System.out.println("All the fileds in the login page are displayed");
			
		}
		else
		{
			System.out.println("All the fileds in the login page are not displayed");
			return;
		}
		
		String sUserName="qaplanet1";
		
		String sPassword="user1";
		
		objUN.clear();
		objPWD.clear();
		objUN.sendKeys(sUserName);
		
		objPWD.sendKeys(sPassword);
		
		objLOGIN.click();
		
		Boolean bLoginTitle=wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		if (bLoginTitle)
		{
			System.out.println("OrangeHRM title displayed");
			
		}
		else
		{
			System.out.println("OrangeHRM title not displayed");
		}
		
		
		String sWelcome=Driver.findElement(By.xpath("//div[@id='option-menu-bar']/ul/li[1]")).getText();
		
		if (sWelcome.equals("Welcome "+sUserName))
		{
			System.out.println("Welcome UserName displayed");
			
			
		}
		else
		{
			System.out.println("Welcome UserName not displayed");
			return;
		}
		
		
		WebElement objChangePassword=Driver.findElement(By.xpath("//a[text()='Change Password']"));
		WebElement objLogout=Driver.findElement(By.xpath(".//*[@id='option-menu']/li[3]/a"));
				
		if (objChangePassword.isDisplayed() && objLogout.isDisplayed())
		{
			System.out.println("Change Password and Logout fields are displayed");
			
		}
		else
		{
			System.out.println("Change Password and Logout fields are not displayed");
			return;
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Admin']")));
		WebElement objAdmin=Driver.findElement(By.xpath("//span[text()='Admin']"));
		Actions action=new Actions(Driver);
		
		action.moveToElement(objAdmin).build().perform();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@id='admin']/ul/li/a/span")));
		
		List<WebElement> objAdminInnerOptions=Driver.findElements(By.xpath("//li[@id='admin']/ul/li/a/span"));
		for(WebElement e:objAdminInnerOptions)
		{
			if (e.isDisplayed()) 
			{
				System.out.println(e.getText()+" links are displayed");	
			}
			
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Company Info']")));
		WebElement objCompanyInfo=Driver.findElement(By.xpath("//span[text()='Company Info']"));
		action.moveToElement(objCompanyInfo).build().perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='General']")));
		WebElement objGeneral=Driver.findElement(By.xpath("//span[text()='General']"));
		WebElement objLocations=Driver.findElement(By.xpath("//span[text()='Locations']"));
		WebElement objCompanyStructure=Driver.findElement(By.xpath("//span[text()='Company Structure']"));
		WebElement objCompanyProperty=Driver.findElement(By.xpath("//span[text()='Company Property']"));
		if (objGeneral.isDisplayed() && objLocations.isDisplayed() && objCompanyStructure.isDisplayed() && objCompanyProperty.isDisplayed())
		{
			System.out.println("General, Locatioons, CompanyStructure and Company Property link displayed");
			
		}
		else
		{
			System.out.println("General, Locatioons, CompanyStructure and Company Property link displayed");
		}
		objCompanyStructure.click();
		
		
		try
		{
			Thread.sleep(1000);
			Driver.switchTo().frame("rightMenu");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add")));
			WebElement objAddButton=Driver.findElement(By.linkText("Add"));
			objAddButton.click();
				
			WebElement objDepermentId=Driver.findElement(By.id("txtDeptId"));
			WebElement objName=Driver.findElement(By.id("txtTitle"));
			WebElement objType=Driver.findElement(By.id("cmbType"));
			WebElement objLocation=Driver.findElement(By.id("cmbLocation"));
			WebElement objDescription=Driver.findElement(By.id("txtDesc"));
			WebElement objSave=Driver.findElement(By.xpath("//form[@id='frmAddNode']/div/input[1]"));
			WebElement objReset=Driver.findElement(By.xpath("//form[@id='frmAddNode']/div/input[2]"));
			WebElement objHide=Driver.findElement(By.xpath("//form[@id='frmAddNode']/div/input[3]"));
		
			if (objDepermentId.isDisplayed()  && objName.isDisplayed() && objType.isDisplayed()  && objLocation.isDisplayed()  && objDescription.isDisplayed()  && objSave.isDisplayed()  && objReset.isDisplayed() &&  objHide.isDisplayed())
			{
			
				System.out.println("DepermentID, Name, Type, Location, Description, Save, Reset, Hide fields are displayed");
			
			}
			else
			{	
				System.out.println("DepermentID, Name, Type, Location, Description, Save, Reset, Hide fields are not displayed");
			}
		
			String strDepermentId="1234";
			objDepermentId.sendKeys(strDepermentId);
			String strName="Sachin Tendulkar";
			objName.sendKeys(strName);
			Select select= new Select(objType);
			select.selectByVisibleText("Team");
			Select sele =new Select(objLocation);
			sele.selectByVisibleText("Hyderabad");
			objDescription.sendKeys("Playing Cricket");
			objSave.click();
			
			System.out.println("Table Data Starting");		
			List<WebElement>objTableData=Driver.findElements(By.xpath("//table[@id='tblCompStruct']/tbody/tr"));
			System.out.println(objTableData.size());
			for (int i=2; i <=objTableData.size(); i++)
			{
				
				String StrCompanyStructureData=Driver.findElement(By.xpath("//table[@id='tblCompStruct']/tbody/tr["+i+"]/td[1]/a")).getText();
				if (StrCompanyStructureData.equals(strDepermentId+" "+strName+" Team"))
				{									
					System.out.println(StrCompanyStructureData);
					break;
				}
				
			}
			System.out.println("Table Data Completed");
			
//			
//		Edit Company Info : Company Structure	
//			
			for (int i=2; i <=objTableData.size(); i++)
			{
				
				String StrCompanyStructureData=Driver.findElement(By.xpath("//table[@id='tblCompStruct']/tbody/tr["+i+"]/td[1]/a")).getText();
				if (StrCompanyStructureData.equals(strDepermentId+" "+strName+" Team"))
				{									
					Driver.findElement(By.xpath("//table[@id='tblCompStruct']/tbody/tr["+i+"]/td[1]/a")).click();
					break;
				}
				
			}
			String strEditDeparmentID="4321";
			String strEditName="Sailesh Reddy";
			WebElement objEditDeparmentID=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtDeptId")));
			objEditDeparmentID.clear();
			objEditDeparmentID.sendKeys(strEditDeparmentID);
			WebElement objEditName=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtTitle")));
			objEditName.clear();
			objEditName.sendKeys(strEditName);
			WebElement objEditSave=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='formbuttons']/input[1]")));
			objEditSave.click();
			
			
			for (int i=2; i <=objTableData.size(); i++)
			{
				
				String StrEditCompanyStructureData=Driver.findElement(By.xpath("//table[@id='tblCompStruct']/tbody/tr["+i+"]/td[1]/a")).getText();
				if (StrEditCompanyStructureData.equals(strEditDeparmentID+" "+strEditName+" Team"))
				{									
					System.out.println(StrEditCompanyStructureData);
					break;
				}
				
			}
			
//			
//		Delete 	Company Info : Company Structure
//			
			for (int i=2; i <=objTableData.size(); i++)
			{
				
				String StrEditCompanyStructureData=Driver.findElement(By.xpath("//table[@id='tblCompStruct']/tbody/tr["+i+"]/td[1]/a")).getText();
				if (StrEditCompanyStructureData.equals(strEditDeparmentID+" "+strEditName+" Team"))
				{									
					Driver.findElement(By.xpath("//table[@id='tblCompStruct']/tbody/tr["+i+"]/td[4]/a")).click();
					break;
				}
				
			}
			
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			if (alert.getText().equals("Are you sure you want to delete Sailesh Reddy Team. It could cause the company structure to change."))
			{
				System.out.println("Alert present with messsage 'Are you sure you want to delete Sailesh Reddy Team. It could cause the company structure to change.'");
				alert.accept();
				
			}
			else
			{
				System.out.println("No alert present");
			}
			
			
			
			Thread.sleep(1000);
			Driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
			Thread.sleep(2000);
			Driver.findElement(By.linkText("Logout")).click();
			
			System.out.println("logout");
			if (Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
			{
				System.out.println("Sign-off Sucessfully home page displayed"); 				
			}
			else
			{
				System.out.println("Sign-off Sucessfully home page not displayed");
				return;
			}
			Driver.quit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
