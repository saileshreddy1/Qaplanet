package coreJavaExamples;
interface WebDriver
{
	public void get(String str);
	
	public void findElement(String str);
	
	public void findElements(String str);
	
	public void close();
	
	public void quit();
	
	public void switchTo();
	
	public void getWindowHandle();

	public void getWindowHandles();
	
	public void navigate();
	
	public void getCurrentUrl();
	
	public void getTitle();
	
	public void getPageSource();
	
	public void manage();
	
}

class FireFoxDriver implements WebDriver  
{

	
	public void get(String str) {
		
		System.out.println("get() method is used to launch the browser");
	}

	
	public void findElement(String str) {
		
		System.out.println("findElement() is used to identify the elements");
	}

	
	public void findElements(String str) {
		
		System.out.println("findElements() is used to identify the multiple elements");
		
	}

	public void sendkeys()
	{
		System.out.println("SendKeys() is used to send the text in text Feild");
	}
	
	
	public void close() {
		
		System.out.println("Close() is used to close the instance of webdriver");
	}

	
	public void quit() {
		
		System.out.println("quit() is used to close all the instance of webdriver");
	}

	
	public void switchTo() {
		
		System.out.println("switchTo() is used to switch to frame, Window, Defaultcontent");
	}

	
	public void getWindowHandle() {
		
		System.out.println("getWindowHandle() is used to capture the window id");
	}

	
	public void getWindowHandles() {
		
		System.out.println("getWindowHandles() is used to capture the multiple window ids");
	}

	
	public void navigate() {
		
		System.out.println("Navigate() is the method used to forward,refresh and back");
	}

	public void getCurrentUrl() {
		
		System.out.println("getCurrentUrl() is used to capture the current url in the web page");
	}

	public void getTitle() {
		
		System.out.println("getTitle() is used to capture the title of the web page");
	}

	public void getPageSource() {
		
		System.out.println("getPageSource() is used to get html page soure");
	}

	public void manage() {
		
		System.out.println("manage() is used to wait statements and maximize the browser");
	}
	
}


class ChromeDriver implements WebDriver
{
	public void get(String str) {
		
		System.out.println("get() method is used to launch the browser");
	}

	
	public void findElement(String str) {
		
		System.out.println("findElement() is used to identify the elements");
	}

	
	public void findElements(String str) {
		
		System.out.println("findElements() is used to identify the multiple elements");
		
	}

	public void sendkeys()
	{
		System.out.println("SendKeys() is used to send the text in text Feild");
	}
	
	
	public void close() {
		
		System.out.println("Close() is used to close the instance of webdriver");
	}

	
	public void quit() {
		
		System.out.println("quit() is used to close all the instance of webdriver");
	}

	
	public void switchTo() {
		
		System.out.println("switchTo() is used to switch to frame, Window, Defaultcontent");
	}

	
	public void getWindowHandle() {
		
		System.out.println("getWindowHandle() is used to capture the window id");
	}

	
	public void getWindowHandles() {
		
		System.out.println("getWindowHandles() is used to capture the multiple window ids");
		
	}

	
	public void navigate() {
		
		System.out.println("Navigate() is the method used to forward,refresh and back");
	}

	public void getCurrentUrl() {
		
		System.out.println("getCurrentUrl() is used to capture the current url in the web page");
	}

	public void getTitle() {
		
		System.out.println("getTitle() is used to capture the title of the web page");
	}

	public void getPageSource() {
		
		System.out.println("getPageSource() is used to get html page soure");
	}

	public void manage() {
		
		System.out.println("manage() is used to wait statements and maximize the browser");
	}
}
public class WebDriverMethods {

	public static void main(String[] args) {
		
		
		System.out.println("Chrome Driver");
		System.out.println("===============");
		ChromeDriver d=new ChromeDriver();
		d.close();
		d.findElement("ChromeDriver");
		d.findElement("WebElement");
		d.findElements("WebElement");
		d.sendkeys();
		d.quit();
		d.getPageSource();
		d.getTitle();
		d.getWindowHandles();
		d.getWindowHandle();
		d.switchTo();
		System.out.println();
		System.out.println("Fire fox driver");
		System.out.println("===============");
		FireFoxDriver d1=new FireFoxDriver();
		d1.close();
		d1.findElement("FireFoxDriver");
		d1.findElement("WebElement");
		d1.findElements("WebElement");
		d1.sendkeys();
		d1.quit();
		d1.getPageSource();
		d1.getTitle();
		d1.getWindowHandles();
		d1.getWindowHandle();
		d1.switchTo();
		
		


	}

}
