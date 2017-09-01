package practiseOrangehrm;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMTestCase2 {

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
		
		
		
		WebElement objPim=Driver.findElement(By.xpath("//li[@id='pim']"));
		WebElement objAddEmployee=Driver.findElement(By.xpath("//span[text()='Add Employee']"));
		
		Actions action =  new Actions(Driver);
		action.moveToElement(objPim).build().perform();
		if (objPim.isDisplayed() && objAddEmployee.isDisplayed()) 
		{
			System.out.println("PIM and ADD EMPLOYES fields are displayed");
			
		}
		else
		{
			System.out.println("PIM and ADD EMPLOYES fields are not displayed");
			return;
		}
		
		objAddEmployee.click();
		

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
			String sAddEmployee=Driver.findElement(By.xpath("//h2[text()='PIM : Add Employee']")).getText();
			if (sAddEmployee.equals("PIM : Add Employee"))
				{
					System.out.println("PIM : Add Employee page displayed");
				}
				else
				{
					System.out.println("PIM : Add Employee page not displayed");
					return;
				}
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtEmployeeId")));
			
				String strEmployeeCode=Driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
								
				WebElement objSave=Driver.findElement(By.id("btnEdit"));
				objSave.click();
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = Driver.switchTo().alert();
				if (alert.getText().equals("Last Name Empty!"))
				{
					System.out.println("Last Name Empty! Alert displayed");
					alert.accept();
					
					
				}
				else
				{
					System.out.println("Alert not displayed");
				}
				
				String strLastName="Tendulkar";
				String strFirstName="Sachin";
				WebElement objLastName=Driver.findElement(By.xpath("//input[@id='txtEmpLastName']"));
				objLastName.click();
				objLastName.sendKeys(strLastName);
				objSave.click();
				wait.until(ExpectedConditions.alertIsPresent());
				if (alert.getText().equals("First Name Empty!"))
				{
					System.out.println("First Name Empty! Alert displayed");
					alert.accept();
				}
				else
				{
					System.out.println("No alert displayed");
				}
				WebElement objFirstName=Driver.findElement(By.xpath("//input[@id='txtEmpFirstName']"));
				objFirstName.click();
				objFirstName.sendKeys(strFirstName);
				objSave.click();
				Driver.switchTo().defaultContent();
		
				Driver.switchTo().frame("rightMenu");
				String sPesronalDetails=Driver.findElement(By.xpath("//h2[text()='Personal Details']")).getText();
				if (sPesronalDetails.equals("Personal Details"))
				{
					System.out.println("Personal Details page displayed");
				
				}
				else
				{
					System.out.println("Personal Details page not displayed");
				}
				Driver.switchTo().defaultContent();
				
			
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='pim']")));
		action.moveToElement(objPim).build().perform();
		WebElement objEmployeeList=Driver.findElement(By.xpath("//span[text()='Employee List']"));
		objEmployeeList.click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));

//			WebElement objTable=Driver.findElement(By.xpath("//div[@class='outerbox']/div[2]/form/table/tbody"));
//			List<WebElement>objRows=objTable.findElements(By.tagName("tr"));
//			
//			for (int i = 0; i < objRows.size(); i++) 
//			{
//				List<WebElement>objCols=objRows.get(i).findElements(By.tagName("td"));
//				for (int j = 0; j < objCols.size(); j++) 
//				{
//					System.out.println(objCols.get(j).getText());
//					
//				}
//				
//			}
//			System.out.println("Way 2");
//			
//			List<WebElement>objtableData=objTable.findElements(By.xpath("//div[@class='outerbox']/div[2]/form/table/tbody/tr/td"));
//			for(WebElement TD:objtableData)
//			{
//				System.out.println(TD.getText());
//			}
			
//			way3
//			System.out.println("Way 3");
			
			int iRc=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
			for(int i=1; i<=iRc; i++)
			{	
				String strEmployeeID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
				String strEmployeeName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				
				if (strEmployeeID.equals(strEmployeeCode) && strEmployeeName.equals(strFirstName+" "+strLastName))
				{
					System.out.println(strEmployeeID +" "+strEmployeeName + " is displayed at "+i);
					break;
					
					
				}
			
			}
//			
//	edit Employee
//			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='data-table']/tbody/tr")));
			int iRc1=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
			for(int i=1; i<=iRc1; i++)
			{	
				String strEmployeeID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
				String strEmployeeName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				if (strEmployeeID.equals(strEmployeeCode) && strEmployeeName.equals(strFirstName+" "+strLastName))
				{
					Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).click();
					break;
					
					
				}
//				
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnEditPers")));
			
			WebElement objEditandSave = Driver.findElement(By.id("btnEditPers"));
			WebElement objFristName2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtEmpFirstName")));
			WebElement objLastName2 = Driver.findElement(By.id("txtEmpLastName"));
			
			String strEditFirstName="Sailesh";
			String strEditLastName="Dega";
			
			objEditandSave.click();
			objFristName2.clear();
			objLastName2.clear();
			objFristName2.sendKeys(strEditFirstName);
			objLastName2.sendKeys(strEditLastName);
			objEditandSave.click();
			
			Driver.switchTo().defaultContent();	
			action.moveToElement(objPim).build().perform();
			objEmployeeList.click();
		
			
//			Delete Employee
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
			
			List<WebElement>objRows=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr"));
			for(int i=1; i<=objRows.size(); i++)
			{	
				String strEmployeeID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
				String strEmployeeName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				if (strEmployeeID.equals(strEmployeeCode) && strEmployeeName.equals(strEditFirstName+" "+strEditLastName))
				{
					Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[1]/input")).click();
					break;
					
					
				}
				
			}
			
			WebElement objDelete=Driver.findElement(By.xpath("//div[@class='actionbar']/div/input[2]"));
			objDelete.click();
			//-------------------
					
			Driver.switchTo().defaultContent();
			objLogout.click();
			if (title)
			{
			System.out.println("Sign Off sucessfully Home page title displayed");
			}
			else
			{
			System.out.println("Sign Off sucessfully HomePage title not displayed");
			return;
			}
			Driver.close();
			Driver.quit();
		
		
		
		
	}
	
	
}
