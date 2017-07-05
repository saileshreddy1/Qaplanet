package lTestScript;

import org.testng.annotations.Test;

import lIB.BussinessFunction;

public class OrangeHRMTestCase3 {

	
	@Test
	public void pimEditEmployee() throws InterruptedException
	{
		BussinessFunction br=new BussinessFunction();
		
		br.configDriver("Chrome");
		br.openOrangeHRMApplication("http://apps.qaplanet.in/qahrm/login.php");
		br.loginToOrangeHRMApplication("qaplanet1", "user1");
		br.editAddEmployee("Tendulkar", "Sachin", "Sailesh", "Dega");
		br.logoutFromOrangeHRMApplication("qaplanet1");
		br.closeBrowser();
		br.quitBrowser();
		}
}
