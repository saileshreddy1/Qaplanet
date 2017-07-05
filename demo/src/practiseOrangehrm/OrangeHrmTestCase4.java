package practiseOrangehrm;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class OrangeHrmTestCase4 {

	
	public static void main(String[] args) {
		
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
	
		WebElement objJob=Driver.findElement(By.xpath("//span[text()='Job']"));
		action.moveToElement(objJob).build().perform();
		
		List<WebElement>objJobInnerLinks=Driver.findElements(By.xpath("//li[@id='admin']/ul/li[2]/ul/li/a/span"));
		for(WebElement e: objJobInnerLinks)
		{
			if (e.isDisplayed()) 
			{
				
				System.out.println(e.getText()+ " link are displayed");
				
			}
		}
		
		WebElement objJobTitles=Driver.findElement(By.xpath("//span[text()='Job Titles']"));
		
		objJobTitles.click();
		
		
		try 
		{
			
			
			Driver.switchTo().frame("rightMenu");
		
			Boolean blnJobTitle=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[text()='Job : Job Title']"), "Job : Job Title"));
			if (blnJobTitle)
			{
				System.out.println("'Job : Job Title' page displayed");
				
			}
			else
			{
				System.out.println("'Job : Job Title' page not displayed");
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
			
			WebElement objJobTitleName =Driver.findElement(By.id("txtJobTitleName"));
			
			WebElement objJobDescription =Driver.findElement(By.id("txtJobTitleDesc"));
			
			WebElement objJobTitleComments =Driver.findElement(By.id("txtJobTitleComments"));
			
			WebElement objSpecification =Driver.findElement(By.id("cmbJobSpecId"));
			
			WebElement objPayGrade =Driver.findElement(By.id("cmbPayGrade"));
			
			WebElement objAddPayGrade =Driver.findElement(By.xpath("//form[@id='frmJobTitle']/div[1]/input[1]"));
			
			WebElement objEditPayGrade =Driver.findElement(By.xpath("//form[@id='frmJobTitle']/div[1]/input[2]"));
			
			WebElement objSave =Driver.findElement(By.xpath	("//form[@id='frmJobTitle']/div[2]/input[1]"));
			
			WebElement objReset =Driver.findElement(By.xpath("//form[@id='frmJobTitle']/div[2]/input[2]"));
			
			
			if (objJobTitleName.isDisplayed() && objJobDescription.isDisplayed() && objJobTitleComments.isDisplayed() && objSpecification.isDisplayed() && objPayGrade.isDisplayed() && objAddPayGrade.isDisplayed() && objEditPayGrade.isDisplayed() && objSave.isDisplayed() && objReset.isDisplayed() ) 
			{
				
				System.out.println("JobTitleName, Job Description, Job Title Comments, Job Specification, Pay Grade , Add pay Grade, Edit Pay Grade, Save and Reset fields are displayed");
			}
			else
			{
				System.out.println("JobTitleName, Job Description, Job Title Comments, Job Specification, Pay Grade , Add pay Grade, Edit Pay Grade, Save and Reset fields are not displayed");
				return;
			}
			
			objSave.click();
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=Driver.switchTo().alert();
			if (alert.getText().equals("Job Title Name should be specified"))
			{
				System.out.println("Alert displayed with message 'Job Title Name should be specified'");
				alert.accept();
			}
			else
			{
				System.out.println("Alert not displayed");
			}
			String strJobTitleName="MLA";
			
			String strJobDescription="Fighting For people";		
			objJobTitleName.sendKeys(strJobTitleName);
			objSave.click();
			wait.until(ExpectedConditions.alertIsPresent());
			if (alert.getText().equals("Job Description should be specified"))
			{
				System.out.println("Alert displayed with message 'Job Description should be specified'");
				alert.accept();
			}
			else
			{
				System.out.println("Alert not displayed");
			}
			
			objJobDescription.sendKeys(strJobDescription);
			objSave.click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cmbAssEmploymentStatus")));
			WebElement objEmployeeStatus=Driver.findElement(By.id("cmbAssEmploymentStatus"));
			if (objEmployeeStatus.isDisplayed())
			{
				System.out.println("Employee Status field displayed");
				
			}
			else
			{
				System.out.println("Employee Status field not displayed");
				return;
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editBtn")));
			WebElement objEditandSave=Driver.findElement(By.id("editBtn"));
			objEditandSave.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editBtn")));
			objEditandSave.click();

			
			
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='data-table']/tbody/tr")));
//			List<WebElement> objTable=Driver.findElements(By.xpath("//div[@class='outerbox']/div[2]/form/table/tbody/tr/td"));
//			for(WebElement Table: objTable)
//			{
//				System.out.println(Table.getText());
//			}
			
			List<WebElement>objRows=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr"));
			for (int i = 1; i <=objRows.size(); i++)
			{
				
				String objDatainTable=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
				String objJobTitleNameinTable=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]")).getText();
				if (objJobTitleNameinTable.equals(strJobTitleName)) 
				{
					System.out.println(objDatainTable+"======="+objJobTitleNameinTable+" Displayed at : "+i);
					break;
				}
			}
			
			for (int i = 1; i <=objRows.size(); i++)
			{
				String objJobTitleNameinTable=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]")).getText();
				if (objJobTitleNameinTable.equals(strJobTitleName)) 
				{
					Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).click();
					break;
				}
			}
			WebElement objEditandSaveButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editBtn")));
			objEditandSaveButton.click();
			WebElement objEditJobTitleName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtJobTitleName']")));
			
			String strEditJobTitleName="Chief Minister";
			
			objEditJobTitleName.clear();
			
			objEditJobTitleName.sendKeys(strEditJobTitleName);
			
			objEditandSaveButton.click();
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='data-table']/tbody/tr")));
			for (int i = 1; i <=objRows.size(); i++)
			{
				
				String objDatainTable=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
				String objEditJobTitleNameinTable=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]")).getText();
				if (objEditJobTitleNameinTable.equals(strEditJobTitleName)) 
				{
					System.out.println(objDatainTable+"======="+objEditJobTitleNameinTable+" Displayed at : "+i);
					break;
				}
			}
			
			
			for (int i = 1; i <=objRows.size(); i++)
			{
				String objEditJobTitleNameinTable=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]")).getText();
				if (objEditJobTitleNameinTable.equals(strEditJobTitleName)) 
				{
					Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[1]/input")).click();
					break;
				}
			}
			WebElement objDelete=Driver.findElement(By.xpath("//div[@class='actionbuttons']/input[2]"));
			objDelete.click();
			
			wait.until(ExpectedConditions.alertIsPresent());
			if (alert.getText().equals("Deletion may affect Pay Grade of Employees in PIM. Do you want to delete ?"))
			{
				System.out.println("'Deletion may affect Pay Grade of Employees in PIM. Do you want to delete ?' alert message displayed");
				alert.accept();
			}
			else
			{
				System.out.println("No alert present");
			}
			
//			
//			Add Job Specification Test Case
//			
			Driver.switchTo().defaultContent();
			WebElement objAdmininMenu=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Admin']")));
			WebElement objJobInAdmin=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Job']")));
			action.moveToElement(objAdmininMenu).moveToElement(objJobInAdmin).build().perform();
			WebElement objJobSpecifications=Driver.findElement(By.xpath("//span[text()='Job Specifications']"));
			objJobSpecifications.click();
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
			Boolean blnJobSpecifications=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[text()='Job : Job Specifications']"), "Job : Job Specifications"));
			if (blnJobSpecifications)
			{
				System.out.println("'Job : Job Specifications' page title displayed");
				
			}
			else
			{
				System.out.println("'Job : Job Specifications' page title not displayed");
				return;
			}
			WebElement objAdd=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionbuttons']/input[1]")));
			objAdd.click();
				
			WebElement objNameinJobSpecifications=Driver.findElement(By.id("txtFieldName"));
			WebElement objSaveinJobSpecifications=Driver.findElement(By.id("editBtn"));
			
			String strName="Sachin Tendulkar";
			objNameinJobSpecifications.sendKeys(strName);
			objSaveinJobSpecifications.click();
			
			List<WebElement> objDataTable=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='data-table']/tbody/tr")));
			for(int i=1; i<=objDataTable.size(); i++)
			{
				
				String strJobSpecificationsID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]/a")).getText();
				String strJobSpecificationsName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				
				if (strJobSpecificationsName.equals(strName))
				{
					System.out.println(strJobSpecificationsID+"===="+strJobSpecificationsName+" is displayed at : "+ i);	
					break;
				}
			}
//			
//			Edit Job Specification
//			
			for(int i=1; i<=objDataTable.size(); i++)
			{
				String strJobSpecificationsName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				if (strJobSpecificationsName.equals(strName))
				{
					Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).click();	
					break;
				}
			}
			
			WebElement objEditandSaveInJobSpecifications=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editBtn")));
			objEditandSaveInJobSpecifications.click();
			
			WebElement objEditNameInJobSpecifications=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtFieldName")));
			objEditNameInJobSpecifications.clear();
			String strEditName="Sailesh Reddy";
			objEditNameInJobSpecifications.sendKeys(strEditName);
			objEditandSaveInJobSpecifications.click();
			for(int i=1; i<=objDataTable.size(); i++)
			{
				
				String strEditJobSpecificationsID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]/a")).getText();
				String strEditJobSpecificationsName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				
				if (strEditJobSpecificationsName.equals(strEditName))
				{
					System.out.println(strEditJobSpecificationsID+"===="+strEditJobSpecificationsName+" is displayed at : "+ i);	
					break;
				}
			}
//			
//			Delete Job Specification
//			
			
			for(int i=1; i<=objDataTable.size(); i++)
			{
				String strEditJobSpecificationsName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				if (strEditJobSpecificationsName.equals(strEditName))
				{
					Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[1]/input")).click();
					break;
				}
			}
			WebElement objDeleteInJobSpecifications=Driver.findElement(By.xpath("//div[@class='actionbuttons']/input[2]"));
			objDeleteInJobSpecifications.click();
			wait.until(ExpectedConditions.alertIsPresent());
			if (alert.getText().equals("Deletion might affect employee information. Do you want to delete ?"))
			{
				System.out.println("'Deletion might affect employee information. Do you want to delete ?' alert displayed");
				alert.accept();
			}
			else
			{
				System.out.println("'Deletion might affect employee information. Do you want to delete ?' alert not displayed");
			}
			
//			
//			Add Qualification
//			
			Driver.switchTo().defaultContent();
			WebElement objAdminAddQualification=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Admin']")));
			WebElement objQualificationAddQualification=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Qualification']")));
			WebElement objEducationAddQualification=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Education']")));
			action.moveToElement(objAdminAddQualification).moveToElement(objQualificationAddQualification).build().perform();
			objEducationAddQualification.click();
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
			Boolean blnQualificationEducation=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[text()='Qualification : Education']"), "Qualification : Education"));
			if (blnQualificationEducation)
			{
				System.out.println("'Qualification : Education' title displayed");
				
			}
			else
			{
				System.out.println("'Qualification : Education' title not displayed");
			}
			
			WebElement objAddQualificationEducation=Driver.findElement(By.xpath("//div[@class='actionbuttons']/input[1]"));
			objAddQualificationEducation.click();
			
			WebElement objInstitute=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUni")));
			WebElement objCourse=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtDeg")));
			WebElement objSaveQualificationEducation=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editBtn")));
			
			String strInstitute="James";
			String strCourse="Diploma";
			
			objInstitute.sendKeys(strInstitute);
			objCourse.sendKeys(strCourse);
			objSaveQualificationEducation.click();
			
			List<WebElement> objTableEducation=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@class='data-table']/tbody/tr")));
			for (int i = 1; i <=objTableEducation.size(); i++) 
			{
				
				String strEducationID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
				String strCourseName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]")).getText();
				String strInstituteName	=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[4]")).getText();
				
				if (strCourseName.equals(strCourse) && strInstituteName.equals(strInstitute))
				{
					System.out.println(strEducationID+"==="+strCourseName+"==="+strInstituteName+" is dislpayed at : "+i);
					break;
				}
				
			}
			
//			
//			Edit Qualification
//			
			for (int i = 1; i <=objTableEducation.size(); i++) 
			{
				
				
				String strCourseName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]")).getText();
				String strInstituteName	=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[4]")).getText();
				
				if (strCourseName.equals(strCourse) && strInstituteName.equals(strInstitute))
				{
					Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).click();
					break;
				}
				
			}
			
			String strEditInstitute="MITS";
			String strEditCourse="B.Tech";
		
			WebElement objEditandSaveEducation=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editBtn")));
			objEditandSaveEducation.click();
			
			WebElement objEditInstituteEducation=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUni")));
			objEditInstituteEducation.clear();
			objEditInstituteEducation.sendKeys(strEditInstitute);
	
			WebElement objEditCourseEducation=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtDeg")));
			objEditCourseEducation.clear();
			objEditCourseEducation.sendKeys(strEditCourse);
			objEditandSaveEducation.click();
			
			
			for (int i = 1; i <=objTableEducation.size(); i++) 
			{
				
				String strEditEducationID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
				String strEditCourseName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]")).getText();
				String strEditInstituteName	=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[4]")).getText();
				
				if (strEditCourseName.equals(strEditCourse) && strEditInstituteName.equals(strEditInstitute))
				{
					System.out.println(strEditEducationID+"==="+strEditCourseName+"==="+strEditInstituteName+" is dislpayed at : "+i);
					break;
				}
				
			}
			
//			
//			Delete Qualification : Education
//			
			
			for (int i = 1; i <=objTableEducation.size(); i++) 
			{
				
			
				String strEditCourseName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]")).getText();
				String strEditInstituteName	=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[4]")).getText();
				
				if (strEditCourseName.equals(strEditCourse) && strEditInstituteName.equals(strEditInstitute))
				{
					Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[1]/input")).click();
					break;
				}
				
			}
			
			Driver.findElement(By.xpath("//div[@class='actionbuttons']/input[2]")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			if (alert.getText().equals("Deletion might affect Education. Do you want to delete ?"))
			{
				System.out.println("'Deletion might affect Education. Do you want to delete ?' alert message displayed");
				alert.accept();
			}
			else
			{
				System.out.println("No alert present");
			}
			
			System.out.println("9 to 17 Test cases completed");
			
			Driver.quit();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	} 
}
