package lTestScript;

import org.testng.annotations.Test;

import lIB.BussinessFunction;

public class OrangeHrmTestCase2 {
	
	@Test
	public void addEmployee() throws InterruptedException
	{
		BussinessFunction Br=new BussinessFunction();
		Br.configDriver("Chrome");
		Br.openOrangeHRMApplication("http://apps.qaplanet.in/qahrm/login.php");
		Br.loginToOrangeHRMApplication("qaplanet1", "user1");
		Br.pimAddEmployee("Tendulkar", "Sachin");
		Br.logoutFromOrangeHRMApplication("qaplanet1");
		Br.closeBrowser();
		Br.quitBrowser();
		
	}
	

}
