package lTestScript;

import org.testng.annotations.Test;

import lIB.BussinessFunction;

public class OrangeHrmTestCase1 {
	
	
	@Test
	public void verifyLoginAndLogoutofOrangeHrm()
	{
		BussinessFunction Br=new BussinessFunction();
		Br.configDriver("Chrome");
//		Br.configDriver("Firefox");
//		Br.configDriver("IE");
		Br.openOrangeHRMApplication("http://apps.qaplanet.in/qahrm/login.php");
		Br.loginToOrangeHRMApplication("qaplanet1", "user1");
		Br.logoutFromOrangeHRMApplication("qaplanet1");
		Br.closeBrowser();
		Br.quitBrowser();
	}
	

}
