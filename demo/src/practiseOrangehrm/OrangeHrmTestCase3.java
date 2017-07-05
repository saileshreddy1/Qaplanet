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

public class OrangeHrmTestCase3 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		Driver.manage().window().maximize();
		String sUrl="http://apps.qaplanet.in/qahrm/login.php";
		Driver.get(sUrl);
		WebDriverWait wait =new WebDriverWait(Driver, 20);
		
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
		
		String []array=sWelcome.split(" ");
//		array[0]="welcome";
//		array[1]="qaplanet1";
		
		if (array[1].equals(sUserName))
		{
			System.out.println("Using split method username displayed in dashboard");
			
		}
		else
		{
			System.out.println("Using split method username not displayed in dashboard");
		}
	
		
		
		
		WebElement objChangePassword=Driver.findElement(By.xpath("//a[text()='Change Password']"));
		WebElement objLogout=Driver.findElement(By.xpath("//a[text()='Logout']"));
				
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
		
		objLocations.click();
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
			
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[text()='Company Info : Locations']"), "Company Info : Locations"));
			if(Driver.findElement(By.xpath("//h2[text()='Company Info : Locations']")).getText().equals("Company Info : Locations"))
			{
				System.out.println("'Company Info : Locations' text displayed");
			}
			else
			{
				System.out.println("'Company Info : Locations' text not displayed");
			}
				
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loc_code")));
			WebElement objSearchBy=Driver.findElement(By.id("loc_code"));
			WebElement objSearchFor=Driver.findElement(By.id("loc_name"));
			WebElement objSearchButton=Driver.findElement(By.xpath("//div[@class='searchbox']/input[2]"));
			WebElement objResetButton=Driver.findElement(By.xpath("//div[@class='searchbox']/input[3]"));
			WebElement objAddbutton=Driver.findElement(By.xpath("//div[@class='actionbar']/div/input[1]"));
			WebElement objDeleteButton=Driver.findElement(By.xpath("//div[@class='actionbar']/div/input[2]"));
			
			if (objSearchButton.isDisplayed() && objSearchFor.isDisplayed() && objSearchBy.isDisplayed() && objResetButton.isDisplayed() && objAddbutton.isDisplayed() && objDeleteButton.isDisplayed())
			{
				System.out.println("SearchBy, Search For, Search Button, Reset Button, Add Button and Delete Button are dispalyed");
			}
			else
			{
				System.out.println("SearchBy, Search For, Search Button, Reset Button, Add Button and Delete Button are not dispalyed");
			 return;
			}
			
			objAddbutton.click();
			
//			
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[text()='Company Info : Locations']"), "Company Info : Locations"));
			if(Driver.findElement(By.xpath("//h2[text()='Company Info : Locations']")).getText().equals("Company Info : Locations"))
			{
				System.out.println("'Company Info : Locations' text displayed");
			}
			else
			{
				System.out.println("'Company Info : Locations' text not displayed");
			}
			
			
//			Driver.switchTo().frame("rightMenu");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtLocDescription")));
			
			WebElement objName = Driver.findElement(By.id("txtLocDescription"));
			
			WebElement objCountry = Driver.findElement(By.id("cmbCountry"));
			
			WebElement objState = Driver.findElement(By.id("txtState"));
			
			WebElement objCity = Driver.findElement(By.id("cmbDistrict"));
			
			WebElement objAddress = Driver.findElement(By.id("txtAddress"));
			
			WebElement objZipCode = Driver.findElement(By.id("txtZIP"));
			
			WebElement objPhone = Driver.findElement(By.id("txtPhone"));
			
			WebElement objFax = Driver.findElement(By.id("txtFax"));
			
			WebElement objComments = Driver.findElement(By.id("txtComments"));
			
			WebElement objSaveandEdit = Driver.findElement(By.id("editBtn"));
			
			WebElement objReset = Driver.findElement(By.xpath(".//*[@id='frmLocation']/div[2]/input[2]"));
			
			if (objCountry.isDisplayed() && objName.isDisplayed() && objState.isDisplayed() && objCity.isDisplayed() && objAddress.isDisplayed() && objZipCode.isDisplayed() && objPhone.isDisplayed() && objFax.isDisplayed() && objComments.isDisplayed() && objSaveandEdit.isDisplayed() && objReset.isDisplayed())
			{
				System.out.println("Name, Country, State, City, Address, Zip Code, Phone, Fax, Comments, Save and reset fields are dispalyed");
			}
			else
			{
				System.out.println("Name, Country, State, City, Address, Zip Code, Phone, Fax, Comments, Save and reset fields are not dispalyed");
				return;
			}
			
			objSaveandEdit.click();
			
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=Driver.switchTo().alert();
			if (alert.getText().contains("- Location Name has to be specified")) 
			{
				System.out.println("Alert present");
				
				alert.accept();
				
			}
			else
			{
				System.out.println("No alert present");
			}
			String strLocationName="Banglore";
			objName.sendKeys(strLocationName);
			objSaveandEdit.click();
			
			wait.until(ExpectedConditions.alertIsPresent());
			if (alert.getText().contains("- Country should be selected!")) 
			{
				System.out.println("Alert present");
				
				alert.accept();
				
			}
			else
			{
				System.out.println("No alert present");
			}
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmbCountry")));
			Select select= new Select(objCountry);
			select.selectByVisibleText("India");
			objSaveandEdit.click();
			
			wait.until(ExpectedConditions.alertIsPresent());
			if (alert.getText().contains("- Address should be specified")) 
			{
				System.out.println("Alert present");
				
				alert.accept();
				
			}
			else
			{
				System.out.println("No alert present");
			}
			
			objAddress.sendKeys("Tirupath");
			objSaveandEdit.click();
			wait.until(ExpectedConditions.alertIsPresent());
			if (alert.getText().contains("- Zip Code should be specified")) 
			{
				System.out.println("Alert present");
				
				alert.accept();
				
			}
			else
			{
				System.out.println("No alert present");
			}
			
			objZipCode.sendKeys("123456");
			objSaveandEdit.click();
			
			List<WebElement> objTable= Driver.findElements(By.xpath("//div[@class='maincontent']/form/table/tbody/tr/td"));
			for(WebElement e: objTable)
			{
				System.out.println(e.getText());
			}
			
			List<WebElement>objRows=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr"));
			for (int i = 1; i <= objRows.size() ; i++) 
			{
				String strLocationNameinTable=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				if (strLocationNameinTable.equals(strLocationName))
				{
					Driver.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
					break;
				}
				
			}
			WebElement objEditandSave=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editBtn")));
			objEditandSave.click();
			WebElement objEditAddress=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtAddress")));
			objEditAddress.clear();
			objEditAddress.sendKeys("Banglore City");
			objEditandSave.click();
			
			int iRowCount=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
			for (int i = 1; i <=iRowCount; i++) 
			{
				String strTableData=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				if (strTableData.equals(strLocationName))
				{
					Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[1]/input")).click();
					break;
				}
				
			}
			
			WebElement objDelete = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionbuttons']/input[2]")));
			objDelete.click();
			wait.until(ExpectedConditions.alertIsPresent());
			if (alert.getText().equals("Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?"))
			{
				System.out.println("'Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?' alert message displayed");
				alert.accept();
			}
			else
			{
				System.out.println("'Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?' alert not displayed");
			}
		
			
			WebElement objCheckAll=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='data-table']/thead/tr/td/input[1]")));
			if (objCheckAll.isEnabled())
			{
				System.out.println("Multiple Check Boxes are displayed");
				objCheckAll.click();
				WebElement objDeleteinCompanyInfoLocation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionbuttons']/input[2]")));
				Thread.sleep(3000);
				objDeleteinCompanyInfoLocation.click();
				wait.until(ExpectedConditions.alertIsPresent());
				if (alert.getText().equals("Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?"))
				{
				System.out.println("'Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?' alert message displayed");
				Thread.sleep(3000);
				alert.accept();
			}
				else
				{
				System.out.println("'Deletion might affect Company Hierarchy. If the Location has associations deletion may fail. Do you want to delete ?' alert not displayed");
				}
			}
			else
			{
				System.out.println("No multiple Check Boxes are displayed");
			}
		
		
		Driver.switchTo().parentFrame();
		WebElement objLogoutFromPage=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Logout']")));
		objLogoutFromPage.click();
		
		if (title)
		{
			System.out.println("Sign Off sucessfully Home page title displayed");
			
		}
		else
		{
			System.out.println("Sign Off sucessfully HomePage title not displayed");
			return;
		}
		Driver.quit();
		
	}

}
