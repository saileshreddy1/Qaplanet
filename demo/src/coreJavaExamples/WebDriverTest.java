package coreJavaExamples;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverTest {

	
	
	private org.openqa.selenium.chrome.ChromeDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\drivers\\chromedriver_win32\\chromedriver.exe");
	    driver = new org.openqa.selenium.chrome.ChromeDriver();
	    baseUrl = "http://apps.qaplanet.in/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @org.testng.annotations.Test
	  public void testUntitled() throws Exception {
	    driver.get("http://apps.qaplanet.in/qahrm/login.php");
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("OrangeHRM - New Level of HR Management".equals(driver.getTitle())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    try {
	      assertEquals(driver.getTitle(), "OrangeHRM - New Level of HR Manage");
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (isElementPresent(By.name("txtUserName"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    assertTrue(isElementPresent(By.name("txtUserName")));
	    driver.findElement(By.name("txtUserName")).clear();
	    driver.findElement(By.name("txtUserName")).sendKeys("qaplanet");
	    driver.findElement(By.name("Submit")).click();
	    System.out.println("Entered username Successfully and failed to login");
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
